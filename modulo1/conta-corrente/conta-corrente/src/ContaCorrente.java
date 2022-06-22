public class ContaCorrente {

    Cliente cliente;
    String numeroConta;
    int agencia;
    double saldo;
    double chequeEspecial;

    public ContaCorrente(Cliente cliente, String numeroConta, int agencia, double saldo, double chequeEspecial) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.chequeEspecial = chequeEspecial;
    }

    void imprimirContaCorrente(){
        System.out.println("Numero da conta:" + numeroConta + ", Ag: " + agencia + " , Saldo: R$" + saldo + " , Cheque especial: R$" + chequeEspecial);
        cliente.imprimirCliente();
    }
    public boolean sacarDinheiro(double valorSaque){
        if (valorSaque > (saldo + chequeEspecial) || valorSaque <= 0){
            System.out.println("Nao foi possivel sacar seu dinheiro.");
            return false;
        } else {
            saldo -= valorSaque;
            return true;
        }
    }
    public boolean depositarDinheiro(double valorDeposito){
        if(valorDeposito <= 0){
            System.out.println("valor depositado tem que ser maior que R$0.00");
            return false;
        } else {
            saldo += valorDeposito;
            return true;
        }
    }
    public double retornarSaldoComChequeEspecial(){
        return saldo + chequeEspecial;
    }
    public boolean tranferir(ContaCorrente contaCorrente, double valor){
        if((valor <= 0) || ((this.saldo - valor + chequeEspecial) < 0)){
            System.out.println("Nao foi possivel fazer sua transferencia.");
            return false;
        } else {
            this.saldo -= valor;
            contaCorrente.saldo += valor;
            return true;
        }
    }

}
