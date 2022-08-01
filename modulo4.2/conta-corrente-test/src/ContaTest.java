import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaTest {

    @Test
    public void deveTestarSaqueContaCorrenteEverificarSaldoComSucesso() {
        //setup

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(1000);
        contaCorrente.setChequeEspecial(1000);
        int saque = 1500;

        //act

        boolean conseguiuSacar = contaCorrente.sacar(saque);

        //assert

        Assertions.assertTrue(conseguiuSacar);
        Assertions.assertEquals(-500, contaCorrente.getSaldo());
    }

    @Test
    public void deveTestarSaqueContaCorrenteSemSaldo() {
        //setup

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(1000);
        contaCorrente.setChequeEspecial(1000);
        int saque = 3000;

        //act

        boolean conseguiuSacar = contaCorrente.sacar(saque);

        //assert

        Assertions.assertFalse(conseguiuSacar);
        Assertions.assertEquals(1000, contaCorrente.getSaldo());
    }

    @Test
    public void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso() {
        //setup

        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(1000);
        contaPoupanca.creditarTaxa();
        int saque = 500;

        //act

        boolean conseguiuSacar = contaPoupanca.sacar(saque);

        //assert

        Assertions.assertTrue(conseguiuSacar);
        Assertions.assertEquals(510, contaPoupanca.getSaldo());
    }

    @Test
    public void deveTestarSaqueContaPoupancaSemSaldo(){
        //setup

        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(1000);
        contaPoupanca.creditarTaxa();
        int saque = 1500;

        //act

        boolean conseguiuSacar = contaPoupanca.sacar(saque);

        //assert

        Assertions.assertFalse(conseguiuSacar);
        Assertions.assertEquals(1010, contaPoupanca.getSaldo());

    }
    @Test
    public void deveTestarSaqueContaPagamentoEVerificarSaldoComSucesso(){
        // setup

        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(500);
        int saque = 250;

        //act

        boolean conseguiuSacar = contaPagamento.sacar(saque);

        //assert

        Assertions.assertTrue(conseguiuSacar);
        Assertions.assertEquals(245.75, contaPagamento.getSaldo());

    }

    @Test
    public void deveTestarSaqueContaPagamentoSemSaldo(){
        // setup

        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(500);
        int saque = 500;

        //act

        boolean conseguiuSacar = contaPagamento.sacar(saque);

        //assert

        Assertions.assertFalse(conseguiuSacar);
        Assertions.assertEquals(500, contaPagamento.getSaldo());
    }

    @Test
    public void deveTestarTransferenciaEVerificarSaldoComSucesso(){
        //setup

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(1000);
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(950);
        contaPoupanca.creditarTaxa();
        int transf = 200;

        //act

        boolean conseguiuTransferir = contaCorrente.transferir(contaPoupanca, transf);

        //assert

        Assertions.assertTrue(conseguiuTransferir);
        Assertions.assertEquals(800, contaCorrente.getSaldo());
        Assertions.assertEquals(1159.50, contaPoupanca.getSaldo());
    }

    @Test
    public void deveTestarTransferenciaSemSaldo(){
        //setup

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(500);
        contaCorrente.setChequeEspecial(100);
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(950);
        contaPoupanca.creditarTaxa();

        int transf = 700;

        //act

        boolean conseguiuTransferir = contaCorrente.transferir(contaPoupanca, transf);

        //assert

        Assertions.assertFalse(conseguiuTransferir);
        Assertions.assertEquals(500, contaCorrente.getSaldo());
        Assertions.assertEquals(959.50, contaPoupanca.getSaldo());
    }

    @Test
    public void deveTestarDepositoEVerificarSaldoComSucesso(){
        //setup

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(500);
        contaCorrente.setChequeEspecial(200);

        int deposito = 800;

        //act

        boolean conseguiuDepositar = contaCorrente.depositar(deposito);

        //assert

        Assertions.assertTrue(conseguiuDepositar);
        Assertions.assertEquals(1300, contaCorrente.getSaldo());
    }

    @Test
    public void deveTestarDepositoNegativo(){
        //setup

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(500);
        contaCorrente.setChequeEspecial(200);

        int deposito = -200;

        //act

        boolean conseguiuDepositar = contaCorrente.depositar(deposito);

        //assert

        Assertions.assertFalse(conseguiuDepositar);
        Assertions.assertEquals(500, contaCorrente.getSaldo());
    }
}
