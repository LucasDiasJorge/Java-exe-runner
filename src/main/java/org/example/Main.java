package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting ...");
        Thread.sleep(1000);
        try {

            String exeFilePath = "hello.exe";

            // Run the .exe file using ProcessBuilder
            ProcessBuilder processBuilder = new ProcessBuilder(exeFilePath);
            Process process = processBuilder.start();

            // Obtain the output stream of the process
            BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = output.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to finish
            process.waitFor();
        } catch (IOException e) {
            System.out.println("Wasn't possible to run hello.exe.");
        }
    }
}