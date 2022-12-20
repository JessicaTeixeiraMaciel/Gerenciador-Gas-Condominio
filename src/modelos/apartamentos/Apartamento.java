package modelos.apartamentos;

import modelos.genericos.Objeto;

import java.util.List;

public class Apartamento extends Objeto {

    private boolean possuiMedidor;
    private boolean estaAlugado;

    public Apartamento(String id, String numeroApartamento, boolean possuiMedidor, boolean estaAlugado) {
        super(id, numeroApartamento);
        this.possuiMedidor = possuiMedidor;
        this.estaAlugado = estaAlugado;
    }

    public Apartamento() {

    }
    @Override
    public Apartamento acessarBanco(List<String> linhaDoBanco) {
        return new Apartamento(linhaDoBanco.get(0),linhaDoBanco.get(1),Boolean.parseBoolean(linhaDoBanco.get(2)),Boolean.parseBoolean(linhaDoBanco.get(3)));
    }

    public boolean isPossuiMedidor() {
        return possuiMedidor;
    }

    public void setPossuiMedidor(boolean possuiMedidor) {
        this.possuiMedidor = possuiMedidor;
    }

    public boolean isEstaAlugado() {
        return estaAlugado;
    }

    public void setEstaAlugado(boolean estaAlugado) {
        this.estaAlugado = estaAlugado;
    }
}
