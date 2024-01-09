package br.com.fakecompany.main;

import br.com.fakecompany.models.*;
import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);

        Gson gson = new GsonBuilder().
                setPrettyPrinting().
                create();

        List<Address> addresses = new LinkedList<>();

        while (true) {

            System.out.println("Digite seu CEP: ");
            String cep = scanner.nextLine();

            if (cep.equalsIgnoreCase("sair")) {
                break;
            }

            String url = "https://viacep.com.br/ws/" + cep.replace(" ", "") + "/json/";

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                ApiAddress apiAddress = gson.fromJson(json, ApiAddress.class);

                Address address = new Address(apiAddress);
                System.out.println(address);

                addresses.add(address);

            } catch (JsonSyntaxException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("\nDigite sair para encerrar a aplicação");
        }
        System.out.println(addresses);

        FileWriter writer = new FileWriter("address.json");
        writer.write(gson.toJson(addresses));
        writer.close();

        System.out.println("\nPrograma Finalizado!");
    }
}
