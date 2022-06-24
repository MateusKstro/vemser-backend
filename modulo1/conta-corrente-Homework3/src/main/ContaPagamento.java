package main;


public class ContaPagamento extends Conta implements Impressao {

    private static final double TAXA_SAQUE = 4.25;


    @Override
    public boolean sacar(double valorSaque) {
        if (valorSaque <= this.getSaldo() + TAXA_SAQUE){
            return super.sacar(valorSaque + TAXA_SAQUE);
        } else {
            System.out.println("Valor do saque maior que o saldo disponivel + taxas.");
        } return false;
    }

    @Override
    public boolean transferir(Conta conta, double valorTranferido) {
       if((valorTranferido > 0) && (valorTranferido < this.getSaldo())) {
           this.setSaldo(this.getSaldo() - valorTranferido);
           return conta.depositar(valorTranferido);
       } else {
          return false;
       }
    }

    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    @Override
    public void imprimir() {
        System.out.println("O numero da conta de pagamento: " + getNumeroConta() + "ag: " + getAgencia() + " com saldo: R$" + getSaldo());
        getCliente().imprimirCliente();
    }
}
