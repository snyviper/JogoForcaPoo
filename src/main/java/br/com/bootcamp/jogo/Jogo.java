package br.com.bootcamp.jogo;

import java.util.Arrays;
import java.util.Scanner;

public class Jogo {

    public static void main(String[] args) {
        PalavraChave palavraChave = new PalavraChave();
        Regras regras = new Regras();
        Scanner in = new Scanner(System.in);

        regras.selecionaDificuldade();
        palavraChave.montaDica();
        while(regras.getPontuacao() > 0) {

            System.out.println(palavraChave.converteDicaEmString());

            System.out.print("Qual letra você chuta: ");
            String letra = in.next();

            regras.validaLetraInserida(letra);


        }
    }
}
