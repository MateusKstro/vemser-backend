
public class Cliente {
    private String nome;
    private String cpf;
    private Contato[] contatos = new Contato[2];
    private Endereco[] enderecos = new Endereco[2];

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco[] enderecos) {
        this.enderecos = enderecos;
    }

    public Cliente(String nome, String cpf, Contato[] contatos, Endereco[] enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

    void imprimirContatos(){
        for(int i = 0; i < contatos.length; i++){
            if (contatos[i] != null){
                contatos[i].imprimirContato();
            }
        }
    }
    void imprimirEnderecos(){
        for(int i = 0; i < enderecos.length; i++){
            if(enderecos[i] != null) {
                enderecos[i].imprimirEndereco();
            }
        }
    }
    void imprimirCliente(){
        System.out.println("Nome: " + nome + ", CPF: " + cpf);
        imprimirContatos();
        imprimirEnderecos();
    }
}
