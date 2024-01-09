package br.com.fakecompany.models;

public record ApiAddress(String cep, String logradouro, String complemento, String bairro,
                         String localidade, String uf) {
}
