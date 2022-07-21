package br.com.dbc.vemser.pessoaapi.entity;



import java.util.Arrays;

public enum TipoPet {

    CACHORRO(1),
    GATO(2),
    GUAXINIM(3);

    private Integer tipo;

    TipoPet(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public static TipoPet ofTipo(Integer tipo){
        return Arrays.stream(TipoPet.values())
                .filter(tp -> tp.getTipo().equals(tipo))
                .findFirst()
                .get();
    }
}


