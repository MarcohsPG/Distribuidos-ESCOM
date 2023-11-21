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

import networking.WebClient;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class Aggregator {
    private WebClient webClient;

    public Aggregator() {
        this.webClient = new WebClient();
    }

    public List<String> sendTasksToWorkers(List<String> workersAddresses, List<String> tasks) {
        CompletableFuture<String>[] futures = new CompletableFuture[workersAddresses.size()];
        List<String> tareasAsignadas = new ArrayList<>();

        // Envia tareas a los workers
        for (int i = 0; i < workersAddresses.size(); i++) {
            String workerAddress = workersAddresses.get(i);
            String task = tasks.get(i);

            byte[] requestPayload = task.getBytes();
            futures[i] = webClient.sendTask(workerAddress, requestPayload);

            // Validacion de tareas asignadas
            tareasAsignadas.add("Servidor " + workerAddress + " -> Tarea: " + task);
        }
        System.out.println("En el método sendTasksToWorkers se asignaron las siguientes tareas a los servidores:");
        for (String tareaAsignada : tareasAsignadas) {
            System.out.println(tareaAsignada);
        }
        
        // Esperar a que todos los futuros estén completos
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures);
        allOf.join();
        
        String firstCompletedServer = findFirstCompletedServer(futures, workersAddresses);
        
        // Verificar si firstCompletedServer es null antes de proceder
        if (firstCompletedServer != null) {
            int indexOfCompletedServer = workersAddresses.indexOf(firstCompletedServer);
            int indexOfThirdTask = (indexOfCompletedServer + 2) % tasks.size();
            String thirdTask = tasks.get(indexOfThirdTask);
        
            System.out.println("\nEl primer servidor en terminar fue: " + firstCompletedServer +
                    ". Y se le asigna la tarea: " + thirdTask);
        
            // Imprimir el número de apariciones para cada tarea
            for (String task : tasks) {
                byte[] taskBytes = task.getBytes();
                CompletableFuture<Integer> appearancesFuture = webClient.getNumberOfAppearances(firstCompletedServer,
                        taskBytes);
        
                // Obtener el resultado y manejarlo
                int appearances = appearancesFuture.join();
                System.out.println("Para la tarea " + task + " el número de apariciones es " + appearances);
            }
        } else {
            // Manejar el caso en el que firstCompletedServer es null
            System.out.println("Error: No se encontraron servidores completados");
        }

        return tareasAsignadas;

    }

    private String findFirstCompletedServer(CompletableFuture<String>[] futures, List<String> workersAddresses) {
        for (int i = 0; i < futures.length; i++) {
            if (futures[i].isDone()) {
                return workersAddresses.get(i);
            }
        }
        return null; // Indica si las tareas no se completaron
    }

}
