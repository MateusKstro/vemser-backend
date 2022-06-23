public abstract class Conta implements Movimentacao{

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

    @Override
    public boolean depositar(double valorDeposito) {
        if(valorDeposito <= 0 ) {
            System.out.println("Para depositar o valor nao pode ser menor ou igual a R$0.00.");
            return false;
        } else {
           saldo += valorDeposito;
           return true;
        }
    }

    @Override
    public boolean sacar(double valorSaque) {
        if(valorSaque > saldo || valorSaque <= 0) {
            System.out.println("Valor para saque nao pode ser menor ou igual a R$0.00.");
            return false;
        } else {
            valorSaque -= saldo;
            return true;
        }
    }

    @Override
    public boolean transferir(Conta conta, double valorTranferido) {
        if((valorTranferido <= 0) || (this.saldo - valorTranferido) > 0) {
            return false;
        } else {
            this.saldo -= valorTranferido;
            conta.saldo += valorTranferido;
            return true;
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