package main.cliente;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private ArrayList<Contato> contatos = new ArrayList<>();
    private ArrayList<Endereco> enderecos= new ArrayList<>();

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

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Cliente(String nome, String cpf, ArrayList<Contato> contatos, ArrayList<Endereco> enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

    void imprimirContatos(){
        for(int i = 0; i < contatos.size(); i++){
            if (contatos.get(i) != null){
                contatos.get(i).imprimirContato();
            }
        }
    }
    void imprimirEnderecos(){
        for(int i = 0; i < enderecos.size(); i++){
            if(enderecos.get(i) != null) {
                enderecos.get(i).imprimirEndereco();
            }
        }
    }
    public void imprimirCliente(){
        System.out.println("Nome: " + nome + ", CPF: " + cpf);
        imprimirContatos();
        imprimirEnderecos();
    }
}
