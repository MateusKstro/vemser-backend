public class Endereco {
    private int tipo;
    private int numero;
    private String logradouro;
    private String complemento;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

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
        System.out.println("Endereço é: " + tipo + ", localizado na rua: " + logradouro + ", numero: " + numero +  ", complemento: " + complemento + ", na cidade: " + cidade + "/" + estado + ", Pais: " + pais + ", CEP: " + cep);
    }



}
