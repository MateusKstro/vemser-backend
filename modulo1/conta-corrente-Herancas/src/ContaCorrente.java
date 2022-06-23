public class ContaCorrente extends Conta implements Impressao{

    private double chequeEspecial;

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, double saldo, double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }




    public boolean sacarDinheiro(double valorSaque){
        if (valorSaque > (this.getSaldo() + this.chequeEspecial) || valorSaque <= 0){
            System.out.println("Nao foi possivel sacar seu dinheiro.");
            return false;
        } else {
            super.setSaldo(getSaldo() - valorSaque);
            return true;
        }
    }

    @Override
    public boolean transferir(Conta conta, double valorTranferido) {
        if((valorTranferido <= 0) || (this.getSaldo() - valorTranferido + chequeEspecial < 0)) {
            System.out.println("Nao foi possivel realizar o tranferencia.");
            return false;
        } else {
            this.setSaldo(this.getSaldo() - valorTranferido);
            conta.setSaldo(this.getSaldo() + valorTranferido);
            return true;
        }
    }


    public double retornarSaldoComChequeEspecial(){
        return this.getSaldo() + this.chequeEspecial;
    }



    @Override
    public void imprimir() {
        System.out.println("O numero da conta: " + getNumeroConta() + "ag: " + getAgencia() + " com saldo: R$" + getSaldo() + " Cheque especial: R$" + getChequeEspecial());
        getCliente().imprimirCliente();
    }
}
