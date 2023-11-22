import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class HttpCliente {

    private static final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10)).build();

    public static void main(String[] args) throws IOException, InterruptedException {

        if (args.length > 0) {
            if (args[0].equals("status")) {
                HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create("http://localhost:8080/status"))
                        .setHeader("X-Debug", "true").build();
                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                HttpHeaders headers = response.headers();
                headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

                System.out.println(response.statusCode());
                System.out.println(response.body());
            } else if (args[0].equals("search")) {

                URI[] uris = {
                        URI.create("http://localhost:8080/searchtoken"),
                        URI.create("http://35.223.206.131/searchtoken"),
                        URI.create("http://34.31.190.31/searchtoken"),

                };

                for (URI uri : uris) {
                    long startTime = System.currentTimeMillis();
                    int tamañoCadena = 600000;
                    String cadenaBuscada = "IPN";
                    HttpRequest request = HttpRequest.newBuilder().uri(uri)
                            .timeout(Duration.ofSeconds(10)).header("Content-Type", "text/plain")
                            .POST(HttpRequest.BodyPublishers.ofString(
                                    tamañoCadena + "," + URLEncoder.encode(cadenaBuscada, StandardCharsets.UTF_8)))
                            .build();

                    HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                    long endTime = System.currentTimeMillis();
                    long elapsedTime = endTime - startTime;

                    System.out.println(response.body());
                    System.out.println("Tiempo total de la solicitud: " + elapsedTime + " milisegundos");
                }
            }
        } else {
            System.out.println("Proporcione el nombre del endpoint como argumento");
        }

    }
}
