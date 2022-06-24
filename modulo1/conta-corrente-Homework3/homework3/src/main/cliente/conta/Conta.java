package main.cliente.conta;

import main.cliente.Cliente;
import main.cliente.conta.interfaces.Movimentacao;

public abstract class Conta implements Movimentacao {

    private Cliente cliente;

    private String numeroConta;

    private String agencia;

    private double saldo;

    public Conta(Cliente cliente, String numeroConta, String agencia, double saldo) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }


    public boolean depositar(double valorDeposito) {
        if(valorDeposito <= 0 ) {
            System.out.println("Para depositar o valor nao pode ser menor ou igual a R$0.00.");
            return false;
        } else {
           this.setSaldo(getSaldo() + valorDeposito);
           return true;
        }
    }


    public boolean sacar(double valorSaque) {
        if(valorSaque > saldo || valorSaque <= 0) {
            System.out.println("Valor para saque nao pode ser menor ou igual a R$0.00.");
            return false;
        } else {
            this.setSaldo(this.getSaldo() - valorSaque);;
            return true;
        }
    }


    public boolean transferir(Conta conta, double valorTranferido) {
        if((valorTranferido <= 0) && ((saldo - valorTranferido) < 0)) {
            System.out.println("Nao foi possivel realizar a tranferencia.");
            return false;
        } else {
            this.setSaldo(this.getSaldo() - valorTranferido);
            return conta.depositar(valorTranferido);
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente (Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
