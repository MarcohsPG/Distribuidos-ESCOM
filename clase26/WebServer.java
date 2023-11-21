/*
 *  MIT License
 *
 *  Copyright (c) 2019 Michael Pogrebinsky - Distributed Systems & Cloud Computing with Java
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;

public class WebServer {
    private static final String TASK_ENDPOINT = "/task";
    private static final String STATUS_ENDPOINT = "/status";
    private static final String SEARCH_TOKEN_ENDPOINT = "/searchtoken";

    private final int port;
    private HttpServer server;

    public static void main(String[] args) {
        int serverPort = 8080;
        if (args.length == 1) {
            serverPort = Integer.parseInt(args[0]);
        }

        WebServer webServer = new WebServer(serverPort);
        webServer.startServer();

        System.out.println("Servidor escuchando en el puerto " + serverPort);

    }

    public WebServer(int port) {
        this.port = port;
    }

    public void startServer() {
        try {
            this.server = HttpServer.create(new InetSocketAddress(port), 0);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        HttpContext statusContext = server.createContext(STATUS_ENDPOINT);
        HttpContext taskContext = server.createContext(TASK_ENDPOINT);
        HttpContext searchContext = server.createContext(SEARCH_TOKEN_ENDPOINT);

        statusContext.setHandler(this::handleStatusCheckRequest);
        taskContext.setHandler(this::handleTaskRequest);
        searchContext.setHandler(this::handleSearchRequest);

        server.setExecutor(Executors.newFixedThreadPool(8));
        server.start();
    }

    private void handleSearchRequest(HttpExchange exchange) throws IOException {
        if (!exchange.getRequestMethod().equalsIgnoreCase("post")) {
            exchange.close();
            return;
        }
        if (exchange.getRequestURI().getPath().equals("/searchtoken")) {
            Headers headers = exchange.getRequestHeaders();
            long startTime = System.nanoTime();

            InputStream requestBody = exchange.getRequestBody();
            byte[] requestBytes = requestBody.readAllBytes();

            String requestBodyString = new String(requestBytes, StandardCharsets.UTF_8);
            String[] requestData = requestBodyString.split(",");
            int tamañoCadena = Integer.parseInt(requestData[0]);
            String cadenaBuscada = URLDecoder.decode(requestData[1], StandardCharsets.UTF_8);

            String cadena = generarCadenota(tamañoCadena);

            int contador = 0;
            int indice = cadena.indexOf(cadenaBuscada);
            while (indice != -1) {
                contador++;
                indice = cadena.indexOf(cadenaBuscada, indice + 1);
            }

            long finishTime = System.nanoTime();
            long nanoseg = finishTime - startTime;
            long seg = nanoseg / 1000000000;
            long miliseg = (nanoseg % 1000000000) / 1000000;
            boolean isDebugMode = false;
            if (headers.containsKey("X-Debug") && headers.get("X-Debug").get(0).equalsIgnoreCase("true")) {
                isDebugMode = true;
            }
            if (isDebugMode) {
                String debugMessage = String.format(
                        "La operación tomó %d nanosegundos = %d segundos con %d milisegundos.", nanoseg, seg, miliseg);
                exchange.getResponseHeaders().put("X-Debug-Info", Arrays.asList(debugMessage));
            }
            String response = String.valueOf(contador);
            sendResponse(response.getBytes(), exchange);

        }
        try {
            // Pausa la ejecución del hilo actual durante 5 segundos (5000 milisegundos).
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // Maneja la excepción si se interrumpe la pausa.
            e.printStackTrace();
        }
    }

    private void handleTaskRequest(HttpExchange exchange) throws IOException {
        if (!exchange.getRequestMethod().equalsIgnoreCase("post")) {
            exchange.close();
            return;
        }
        if (exchange.getRequestURI().getPath().equals("/task")) {
            Headers headers = exchange.getRequestHeaders();
            // Contar el numero de headers recibidos
            int headerCount = headers.size();

            System.out.println("Número de encabezados recibidos: " + headerCount);

            // Imprimir todos los encabezados (clave-valor).
            System.out.println("Encabezados recibidos:");
            for (String key : headers.keySet()) {
                List<String> values = headers.get(key);
                for (String value : values) {
                    System.out.println(key + ": " + value);
                }
            }
            if (headers.containsKey("X-Test") && headers.get("X-Test").get(0).equalsIgnoreCase("true")) {
                String dummyResponse = "123\n";
                sendResponse(dummyResponse.getBytes(), exchange);
                return;
            }

            boolean isDebugMode = false;
            if (headers.containsKey("X-Debug") && headers.get("X-Debug").get(0).equalsIgnoreCase("true")) {
                isDebugMode = true;
            }

            long startTime = System.nanoTime();

            InputStream requestBody = exchange.getRequestBody();// Creamos el flujo de entrada de la solicitud
            byte[] requestBytes = requestBody.readAllBytes();
            byte[] responseBytes = calculateResponse(requestBytes);

            String requestBodyString = new String(requestBytes, StandardCharsets.UTF_8);// Convertimos el flujo en una
                                                                                        // cadena
            System.out.println("Cuerpo del mensaje recibido:");
            System.out.println(requestBodyString);// Imprimimos los datos recibidos

            long finishTime = System.nanoTime();
            long nanoseg = finishTime - startTime;
            long seg = nanoseg / 1000000000;
            long miliseg = (nanoseg % 1000000000) / 1000000;

            if (isDebugMode) {
                String debugMessage = String.format(
                        "La operación tomó %d nanosegundos = %d segundos con %d milisegundos.", nanoseg, seg, miliseg);
                exchange.getResponseHeaders().put("X-Debug-Info", Arrays.asList(debugMessage));
            }
            sendResponse(responseBytes, exchange);
        }

        try {
            // Pausa la ejecución del hilo actual durante 5 segundos (5000 milisegundos).
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Maneja la excepción si se interrumpe la pausa.
            e.printStackTrace();
        }
    }

    private String generarCadenota(int length) {
        StringBuilder cadenota = new StringBuilder(length);
        for (int i = 0; i < length * 4; i++) {
            if (i % 4 == 0) {
                cadenota.append(' ');
            } else {
                cadenota.append((char) (Math.random() * (26) + 65));
            }
        }
        return cadenota.toString();
    }

    private byte[] calculateResponse(byte[] requestBytes) {
        String bodyString = new String(requestBytes);
        String[] stringNumbers = bodyString.split(",");

        BigInteger result = BigInteger.ONE;

        for (String number : stringNumbers) {
            BigInteger bigInteger = new BigInteger(number);
            result = result.multiply(bigInteger);
        }

        return String.format("El resultado de la multiplicación es %s\n", result).getBytes();
    }

    private void handleStatusCheckRequest(HttpExchange exchange) throws IOException {
        if (!exchange.getRequestMethod().equalsIgnoreCase("get")) {
            exchange.close();
            return;
        }

        String responseMessage = "El servidor está vivo\n";
        sendResponse(responseMessage.getBytes(), exchange);
    }

    private void sendResponse(byte[] responseBytes, HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(200, responseBytes.length);
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(responseBytes);
        outputStream.flush();
        outputStream.close();
        exchange.close();
    }
}