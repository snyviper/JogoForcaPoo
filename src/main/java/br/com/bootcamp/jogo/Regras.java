package br.com.bootcamp.jogo;

import java.util.ArrayList;
import java.util.Scanner;

public class Regras {

    private String[] listaLetrasCorretas;
    private ArrayList<String> dica = new ArrayList<>();
    private PalavraChave palavraChave = new PalavraChave();
    private static int pontuacao = 10;
    private static boolean acertou = false;

    public void validaLetraInserida(String letraDigitada){
        listaLetrasCorretas = palavraChave.getPalavraChave().split("");
        int qtdLetras = palavraChave.getPalavraChave().length();
        dica = palavraChave.getDica();
        int i = 0;
        while (i < qtdLetras) {
            if (listaLetrasCorretas[i].equals(letraDigitada)) {
                dica.remove(i);
                dica.add(i,letraDigitada);
                acertou = true;
            }
            i++;
        }
        validaPalavra();
        controlaPontuacao(pontuacao);
        palavraChave.setDica(dica);
    }

    private void validaPalavra(){
        if(palavraChave.getPalavraChave().equals(palavraChave.converteDicaEmString())){
            System.out.println("Você Ganhou... Parabéns!!");
            System.exit(0);
        }
    }

    private void controlaPontuacao(int pontuacao) {
        if(!acertou){
            this.pontuacao = pontuacao - 1;
        } else {
            this.pontuacao = pontuacao;
        }

        System.out.println("Vida(s): "+this.pontuacao);

        if(this.pontuacao == 0){
            System.out.println("Você Perdeu!!");
            System.exit(0);
        }
    }

    public void selecionaDificuldade(){
        Scanner in = new Scanner(System.in);
        System.out.print("Qual dificuldade você deseja?(D)Díficil, (N)Normal, (F)Fácil --> ");
        String dificuldade =  in.next();

        switch (dificuldade.toUpperCase()) {
            case "D":
                palavraChave.escolhePalavraChave("listaDificil");
                break;
            case "N":
                palavraChave.escolhePalavraChave("listaNormal");
                break;
            case "F":
                palavraChave.escolhePalavraChave("listaFacil");
                break;
            default:
                System.out.println("Por Favor selecione uma opção válida! Fechando Jogo.");
                System.exit(0);
        }
    }

    public int getPontuacao(){
        return Regras.pontuacao;
    }
}
