package modelos.genericos;

import java.util.List;

public class Objeto {

    private static final long serialVersionUID = 1L;
    private String id;
    private String numeroApartamento;

    public Objeto(String id, String numeroApartamento) {
        this.id = id;
        this.numeroApartamento = numeroApartamento;
    }

    public Objeto() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroApartamento() {
        return numeroApartamento;
    }

    public void setNumeroApartamento(String numeroApartamento) {
        this.numeroApartamento = numeroApartamento;
    }

    @Override
    public String toString() {
        return "Objeto{" +
                "id='" + id + '\'' +
                ", numeroApartamento='" + numeroApartamento + '\'' +
                '}';
    }

    public Objeto acessarBanco(List<String> linhadoBanco) {
        return null;
    }
}
