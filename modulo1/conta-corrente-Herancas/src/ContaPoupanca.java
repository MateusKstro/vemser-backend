public class ContaPoupanca extends Conta implements Impressao{

    public static final double JUROS_MENSAL = 1.01;

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public void creditarTaxa(){
        setSaldo(getSaldo() * JUROS_MENSAL);
    }

    @Override
    public void imprimir() {
        System.out.println("O numero da conta: " + getNumeroConta() + "ag: " + getAgencia() + " com saldo: R$" + getSaldo());
        getCliente().imprimirCliente();
    }
}
