import java.util.ArrayList;

public class Contato {
    String descricao;
    String telefone;
    int tipo;



    public Contato(String descricao, String telefone, int tipo) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    void imprimirContato(){
        System.out.println("Contato:" + descricao + ":" + telefone + " tipo de contato: " + tipo);
    }

}
