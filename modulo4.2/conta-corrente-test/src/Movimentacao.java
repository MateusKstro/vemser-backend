
public interface Movimentacao {

    public boolean sacar(double valorSaque);
    public boolean depositar(double valorDeposito);
    public boolean transferir(Conta conta, double valorTranferido);
}
