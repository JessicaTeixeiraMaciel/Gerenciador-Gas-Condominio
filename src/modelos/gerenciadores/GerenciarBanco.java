package modelos.gerenciadores;

import modelos.apartamentos.Apartamento;
import modelos.genericos.Objeto;
import org.apache.commons.lang3.ArrayUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GerenciarBanco {

    private List<Apartamento> listaDeApartamentos;
    private List<Objeto> listaDeProprietarios;
    private List<Objeto> listaDeInquilinos;
    private List<Objeto> listaDeObjetos;

    public GerenciarBanco(List<Apartamento> listaDeApartamentos, List<Objeto> listaDeProprietarios, List<Objeto> listaDeInquilinos, List<Objeto> listaDeObjetos) {
        this.listaDeApartamentos = listaDeApartamentos;
        this.listaDeProprietarios = listaDeProprietarios;
        this.listaDeInquilinos = listaDeInquilinos;
        this.listaDeObjetos = listaDeObjetos;
    }

    public GerenciarBanco() {

    }

    public List criarListaDeObjetos(String caminhoDoArquivo1,String caminhoDoArquivo2, Objeto objeto){
        File arquivo1 = new File(caminhoDoArquivo1);
        File arquivo2 = new File(caminhoDoArquivo2);
        List<String> banco1 = new ArrayList<>();
        List<String> banco2 = new ArrayList<>();
        List<Objeto> lista = new ArrayList<>();
        try {
            if (!arquivo1.exists()) {arquivo1.createNewFile();}
            FileReader fr1 = new FileReader(arquivo1);
            BufferedReader br1 = new BufferedReader(fr1);
            FileReader fr2 = new FileReader(arquivo2);
            BufferedReader br2 = new BufferedReader(fr2);
            while (br1.ready() && br2.ready()) {
                String linha1 = br1.readLine();
                banco1.add(linha1);
                String linha2 = br2.readLine();
                banco2.add(linha2);
                String[] linhaDoBanco1 = linha1.split(";");
                System.out.println(Arrays.toString(linhaDoBanco1));
                String[] linhaDoBanco2 = linha2.split(";");
                System.out.println(Arrays.toString(linhaDoBanco2));
                String[] concatenarLinhas = ArrayUtils.addAll(linhaDoBanco1,linhaDoBanco2);
                lista.add(objeto.acessarBanco(List.of(concatenarLinhas)));
            }
            br1.close();
            fr1.close();
            br2.close();
            fr2.close();
        } catch (IOException ex) {ex.printStackTrace();}
        System.out.println(lista);
        return lista;
    }

    public List<Apartamento> getListaDeApartamentos() {
        GerenciarBanco gerenciarBanco = new GerenciarBanco();
        Apartamento apartamento = new Apartamento();
        setListaDeApartamentos(gerenciarBanco.criarListaDeObjetos("src/banco/objetos.txt","src/banco/apartamentos.txt",apartamento));
        return listaDeApartamentos;
    }

    public void setListaDeApartamentos(List<Apartamento> listaDeApartamentos) {
        this.listaDeApartamentos = listaDeApartamentos;
    }

    public List<Objeto> getListaDeProprietarios() {
        GerenciarBanco gerenciarBanco = new GerenciarBanco();
        Objeto proprietario = new Objeto();
        setListaDeProprietarios(gerenciarBanco.criarListaDeObjetos("src/banco/objetos.txt","src/banco/proprietarios.txt",proprietario));
        return listaDeProprietarios;
    }

    public void setListaDeProprietarios(List<Objeto> listaDeProprietarios) {
        this.listaDeProprietarios = listaDeProprietarios;
    }

    public List<Objeto> getListaDeInquilinos() {
        GerenciarBanco gerenciarBanco = new GerenciarBanco();
        Objeto inquilino = new Objeto();
        setListaDeInquilinos(gerenciarBanco.criarListaDeObjetos("src/banco/objetos.txt","src/banco/inquilinos.txt",inquilino));
        return listaDeInquilinos;
    }

    public void setListaDeInquilinos(List<Objeto> listaDeInquilinos) {
        this.listaDeInquilinos = listaDeInquilinos;
    }

    @Override
    public String toString() {
        return "gerenciarBanco{" +
                "listaDeApartamentos=" + listaDeApartamentos +
                ", listaDeProprietarios=" + listaDeProprietarios +
                ", listaDeInquilinos=" + listaDeInquilinos +
                '}';
    }
}
