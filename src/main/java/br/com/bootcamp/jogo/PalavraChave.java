package br.com.bootcamp.jogo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PalavraChave {
    private static String palavraChave;
    private static ArrayList<String> dica = new ArrayList<>();
    public ArrayList<String> palavras = new ArrayList<String>();

    public void escolhePalavraChave(String nomeArquivo) {
        //Pega o arquivo
        File file = new File("./src/"+ nomeArquivo + ".txt");
        Scanner inputFile = null;

        try {
            inputFile = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Preenche o array
        while (inputFile.hasNext()) {
            palavras.add(inputFile.next());
        }
        inputFile.close();

        //Apartir do arraylist seleciona uma palavra randomica
        String palavra = palavras.get((int) (Math.random() * palavras.size()));

        setPalavraChave(palavra);
    }

    public void montaDica(){

        for(int cont = 0; cont < getPalavraChave().length(); cont++){
            dica.add(" __ ");
        }

        setDica(dica);
    }

    public String converteDicaEmString(){
        String novaDica = "";
        for (String s : this.getDica()) {
            novaDica += s;
        }
        return novaDica;
    }

    public ArrayList<String> getDica() {
        return dica;
    }

    public void setDica(ArrayList<String> dica) {
        PalavraChave.dica = dica;
    }

    public String getPalavraChave() {
        return palavraChave;
    }

    public void setPalavraChave(String palavraChave) {
        PalavraChave.palavraChave = palavraChave;
    }
}
