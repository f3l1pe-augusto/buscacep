package br.com.fakecompany.models;

public record EnderecoApi(String cep, String logradouro, String complemento, String bairro,
                          String localidade, String uf) {
}
