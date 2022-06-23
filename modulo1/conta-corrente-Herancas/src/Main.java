

public class Main {
    public static void main(String[] args) {

        Contato[] contatosCliente1 = new Contato[2];
        contatosCliente1[0] = new Contato("Celular", "519999-8888", 1);
        contatosCliente1[1] = new Contato("Telefone", "517777-6666", 2);

        Contato[] contatosCliente2 = new Contato[2];
        contatosCliente2[0] = new Contato("Celular", "517887-6556", 1);
        contatosCliente2[1] = new Contato("Telefone", "514778-6986", 2);

        Endereco[] enderecosCliente1 = new Endereco[2];
        enderecosCliente1[0] = new Endereco(1, 543, "Rua Pokemon", "Casa", "Cachoeirinha", "RS", "BR", "19918-116");
        enderecosCliente1[1] = new Endereco(2, 549, "Rua Naruto", "Ap22", "Cachoeirinha", "RS", "BR", "19918-119");

        Endereco[] enderecosCliente2 = new Endereco[2];
        enderecosCliente2[0] = new Endereco(1, 560, "Rua Dragon ball Z", "Casa", "Cachoeirinha", "RS", "BR", "19918-009");
        enderecosCliente2[1] = new Endereco(2, 570, "Rua Street Fighter", "Ap24", "Cachoeirinha", "RS", "BR", "19918-098");

        Cliente cliente1 = new Cliente("Rafael", "619189708-90", contatosCliente1, enderecosCliente1);
        Cliente cliente2 = new Cliente("Mateus", "196198908-12", contatosCliente2, enderecosCliente2);

        ContaCorrente contaCorrenteCliente1 = new ContaCorrente(cliente1, "19849799","198",500, 100);
        ContaCorrente contaCorrenteCliente2 = new ContaCorrente(cliente2, "198791136", "205", 300,200);

        ContaPoupanca contaPoupancaCliente1 = new ContaPoupanca(cliente1, "1981987","152", 35);
        ContaPoupanca contaPoupancaCliente2 = new ContaPoupanca(cliente2, "555555", "156", 50);





        System.out.println("=================================================");
        System.out.println("Realizando tranferencia entre contas:");
        contaCorrenteCliente1.transferir(contaCorrenteCliente2, 600);
        System.out.println("Seu saldo atualizado: R$" + contaCorrenteCliente1.getSaldo());
        System.out.println("=================================================");
        System.out.println("Realizando saque da conta :");
        contaCorrenteCliente2.sacar(200);
        System.out.println("Saldo atualizado apos o saque: R$" + contaCorrenteCliente2.getSaldo());
        System.out.println("================================================");

        System.out.println("Conta cliente1: ");
        contaCorrenteCliente1.imprimir();
        System.out.println("==========================================");
        System.out.println("Conta Cliente2: ");
        contaCorrenteCliente2.imprimir();
        System.out.println("==========================================");
        System.out.println("Conta Poupanca cliente1:");
        contaPoupancaCliente1.imprimir();
        System.out.println("==========================================");
        System.out.println("Conta Poupanca cliente2:");
        contaPoupancaCliente2.imprimir();


    }
}
