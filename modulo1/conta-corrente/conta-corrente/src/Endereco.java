public class Endereco {
    int tipo;
    int numero;
    String logradouro;
    String complemento;
    String cidade;
    String estado;
    String pais;
    String cep;


    public Endereco(int tipo, int numero, String logradouro, String complemento, String cidade, String estado, String pais, String cep) {
        this.tipo = tipo;
        this.numero = numero;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cep = cep;
    }

    void imprimirEndereco(){
        System.out.println("Endereço é: " + tipo + " localizado na rua: " + logradouro + " numero: " + numero +  "complemento: " + complemento + " na cidade: " + cidade + "/" + estado + ", Pais: " + pais + ", CEP: " + cep);
    }



}
