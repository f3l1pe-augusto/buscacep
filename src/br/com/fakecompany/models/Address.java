package br.com.fakecompany.models;

public class Address {
    private String cep;
    private String rua;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;

    public Address(ApiAddress apiAddress) {
        this.cep = apiAddress.cep();
        this.rua = apiAddress.logradouro();
        this.complemento = apiAddress.complemento();
        this.bairro = apiAddress.bairro();
        this.cidade = apiAddress.localidade();
        this.uf = apiAddress.uf();
    }

    @Override
    public String toString() {
        return "\nCEP: " + cep + "\nRua: " + rua + "\nComplemento: " + complemento + "\nBairro: " + bairro +
                "\nCidade: " + cidade + "\nUF: " + uf;
    }
}
