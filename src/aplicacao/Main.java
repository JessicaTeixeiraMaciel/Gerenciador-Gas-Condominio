package aplicacao;

import modelos.gerenciadores.GerenciarBanco;

public class Main {
    public static void main(String[] args) {

        GerenciarBanco gerenciarBanco = new GerenciarBanco();
        System.out.println(gerenciarBanco.getListaDeApartamentos());

    }
}