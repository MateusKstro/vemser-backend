public class ContaCorrente extends Conta implements Impressao {

    private double chequeEspecial;


    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, double saldo, double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    public ContaCorrente(){
    }

    @Override
    public boolean sacar(double valorSaque) {
        if(valorSaque > 0 && valorSaque <= this.retornarSaldoComChequeEspecial()){
            this.setSaldo(this.getSaldo() - valorSaque);
            return true;
        } else {
            return false;
        }
    }

    public double retornarSaldoComChequeEspecial(){
        double saldoTotal = this.getSaldo() + this.chequeEspecial;
        return saldoTotal;
    }



    @Override
    public void imprimir() {
        System.out.println("O numero da conta: " + getNumeroConta() + "ag: " + getAgencia() + " com saldo: R$" + getSaldo() + " Cheque especial: R$" + chequeEspecial);
        getCliente().imprimirCliente();
    }
}
