package br.com.fakecompany.models;

public class Endereco {
    private String cep;
    private String rua;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;

    public Endereco(EnderecoApi enderecoApi) {
        this.cep = enderecoApi.cep();
        this.rua = enderecoApi.logradouro();
        this.complemento = enderecoApi.complemento();
        this.bairro = enderecoApi.bairro();
        this.cidade = enderecoApi.localidade();
        this.uf = enderecoApi.uf();
    }

    @Override
    public String toString() {
        return "\nCEP: " + cep + "\nRua: " + rua + "\nComplemento: " + complemento + "\nBairro: " + bairro +
                "\nCidade: " + cidade + "\nUF: " + uf;
    }
}
