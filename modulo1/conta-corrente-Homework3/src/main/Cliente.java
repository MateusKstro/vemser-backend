package main;

import main.Contato;
import main.Endereco;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private ArrayList<Contato> contatos;
    private ArrayList<Endereco> enderecos;

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

    void imprimirContatos() {
        if (contatos != null) {
            for (int i = 0; i < contatos.size(); i++) {
                if (contatos != null) {
                    contatos.get(i).imprimirContato();
                }
            }
        }
    }
    void imprimirEnderecos() {
        if (enderecos != null) {
            for (int i = 0; i < enderecos.size(); i++) {
                if (enderecos != null) {
                    enderecos.get(i).imprimirEndereco();
                }
            }
        }
    }
    public void imprimirCliente(){
        System.out.println("Nome: " + nome + ", CPF: " + cpf);
        imprimirContatos();
        imprimirEnderecos();
    }
}
