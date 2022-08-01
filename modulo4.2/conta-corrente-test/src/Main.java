import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Contato> contatosCliente1 = new ArrayList<>();
        contatosCliente1.add(new Contato("Celular", "519999-8888", 1));
        contatosCliente1.add(new Contato("Telefone", "517777-6666", 2));

        ArrayList<Contato> contatosCliente2 = new ArrayList<>();
        contatosCliente2.add(new Contato("Celular", "517887-6556", 1));
        contatosCliente2.add(new Contato("Telefone", "514778-6986", 2));

        ArrayList<Endereco> enderecosCliente1 = new ArrayList<>();
        enderecosCliente1.add(new Endereco(1, 543, "Rua Pokemon", "Casa", "Cachoeirinha", "RS", "BR", "19918-116"));
        enderecosCliente1.add(new Endereco(2, 549, "Rua Naruto", "Ap22", "Cachoeirinha", "RS", "BR", "19918-119"));

        ArrayList<Endereco> enderecosCliente2 = new ArrayList<>();
        enderecosCliente2.add(new Endereco(1, 560, "Rua Dragon ball Z", "Casa", "Cachoeirinha", "RS", "BR", "19918-009"));
        enderecosCliente2.add(new Endereco(2, 570, "Rua Street Fighter", "Ap24", "Cachoeirinha", "RS", "BR", "19918-098"));

        Cliente cliente1 = new Cliente("Rafael", "619189708-90", contatosCliente1, enderecosCliente1);
        Cliente cliente2 = new Cliente("Mateus", "196198908-12", contatosCliente2, enderecosCliente2);

        ContaCorrente contaCorrenteCliente1 = new ContaCorrente(cliente1, "19849799","198",500, 100);
        ContaPagamento contaPagamentoCliente1 = new ContaPagamento(cliente1, "198799", "896", 300);
        ContaPoupanca contaPoupancaCliente2 = new ContaPoupanca(cliente2, "555555", "156", 50);






        System.out.println("=================================================");
        System.out.println("Realizando tranferencia entre contas:");
        contaCorrenteCliente1.transferir(contaPoupancaCliente2, 300);
        System.out.println("Seu saldo atualizado: R$" + contaCorrenteCliente1.getSaldo());
        System.out.println("=================================================");
        System.out.println("Realizando saque da conta poupanca:");
        contaPoupancaCliente2.sacar(200);
        System.out.println("Saldo atualizado apos o saque: R$" + contaPoupancaCliente2.getSaldo());
        System.out.println("================================================");
        System.out.println("Realizando deposito Conta1:");
        contaCorrenteCliente1.depositar(200);
        System.out.println("Seu saldo atualizado: R$" + contaCorrenteCliente1.getSaldo());
        System.out.println("================================================");
        contaPagamentoCliente1.sacar(200);
        System.out.println("Seu saldo atualizado, conta de pagamento: R$" + contaPagamentoCliente1.getSaldo());
        System.out.println("================================================");
        System.out.println("Realizando tranferencia entre contas:");
        contaPagamentoCliente1.transferir(contaCorrenteCliente1, 50);
        System.out.println("Seu saldo atualizado: R$" + contaPagamentoCliente1.getSaldo());

        System.out.println("==========================================");
        System.out.println("Conta cliente1: ");
        contaCorrenteCliente1.imprimir();
        System.out.println("==========================================");
        System.out.println("Conta Pagamento Cliente1: ");
        contaPagamentoCliente1.imprimir();
        System.out.println("==========================================");
        System.out.println("Conta Poupanca cliente2:");
        contaPoupancaCliente2.imprimir();

    }
}
