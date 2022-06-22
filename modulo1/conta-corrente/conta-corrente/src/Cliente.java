import java.sql.SQLOutput;

public class Cliente {
    String nome;
    String cpf;
    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new Endereco[2];


    public Cliente(String nome, String cpf, Contato[] contatos, Endereco[] enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

    void imprimirContatos(){
        for(int i = 0; i < contatos.length; i++){
            contatos[i].imprimirContato();
        }
    }
    void imprimirEnderecos(){
        for(int i = 0; i < enderecos.length; i++){
            enderecos[i].imprimirEndereco();
        }
    }
    void imprimirCliente(){
        System.out.println("Nome: " + nome + ", CPF: " + cpf);
        imprimirContatos();
        imprimirEnderecos();
    }
}
