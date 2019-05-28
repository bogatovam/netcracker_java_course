package com.netcracker;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import java.util.Scanner;

public class CalculationRestClient {

    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/calc");

        Scanner scanner = new Scanner(System.in);

        Integer userResp = 0;
        while (userResp != 5) {
            System.out.println("1.Addition");
            System.out.println("2.Subtraction");
            System.out.println("3.Multiplication");
            System.out.println("4.Division");
            System.out.println("5.Exit");
            System.out.println();
            System.out.println("Enter operation:");

            userResp = scanner.nextInt();

            if (userResp != 5) {

                System.out.println("Enter first number:");
                Double first = scanner.nextDouble();
                System.out.println("Enter second number:");
                Double second = scanner.nextDouble();

                WebTarget newWebTarget = null;

                switch (userResp) {
                    case (1):
                        newWebTarget = webTarget.path("add/" + first + "/" + second);
                        break;
                    case (2):
                        newWebTarget = webTarget.path("sub/" + first + "/" + second);
                        break;
                    case (3):
                        newWebTarget = webTarget.path("mult/" + first + "/" + second);
                        break;
                    case (4):
                        newWebTarget = webTarget.path("div/" + first + "/" + second);
                        break;
                }

                if (newWebTarget == null) {
                    System.out.println("Enter correct number of operation!");
                    System.out.println();
                } else {
                    Response responseJson = newWebTarget.request(MediaType.APPLICATION_JSON).get().readEntity(Response.class);
                    String responseText = newWebTarget.request(MediaType.TEXT_PLAIN).get().readEntity(String.class);
                    System.out.println("JSON: " + responseJson);
                    System.out.println("TEXT: " + responseText);
                    System.out.println();
                }
            }
        }
    }
}
