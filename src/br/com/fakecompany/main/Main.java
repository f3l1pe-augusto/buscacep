package br.com.fakecompany.main;

import br.com.fakecompany.models.Endereco;
import br.com.fakecompany.models.EnderecoApi;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);

        Gson gson = new Gson();

        System.out.println("Digite seu CEP: ");
        int cep = scanner.nextInt();

        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            EnderecoApi enderecoApi = gson.fromJson(json, EnderecoApi.class);

            Endereco endereco = new Endereco(enderecoApi);
            System.out.println(endereco);
        } catch (JsonSyntaxException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("\nPrograma Finalizado!");
        }
    }
}
