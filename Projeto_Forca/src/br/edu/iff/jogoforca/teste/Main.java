package br.edu.iff.jogoforca.teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraFactory;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.bancodepalavras.dominio.tema.TemaFactory;
import br.edu.iff.jogoforca.Aplicacao;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.jogador.JogadorFactory;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaAppService;
import br.edu.iff.jogoforca.dominio.rodada.RodadaFactory;

public class Main {

	public static void main(String[] args) {
		Aplicacao aplicacao = Aplicacao.getSoleInstance();
		RodadaAppService rodadaapp = RodadaAppService.getSoleInstance();
		
		JogadorFactory jogadorFactory = aplicacao.getJogadorFactory();
		TemaFactory temaFactory = aplicacao.getTemaFactory();
		RodadaFactory rodadaFactory = aplicacao.getRodadaFactory();
		
		//Temas e cadastros
		Tema temaAnimais = temaFactory.getTema("Animais");
		PalavraFactory palavraNomesFactory = aplicacao.getPalavraFactory();

		palavraNomesFactory.getPalavra("Leao", temaAnimais);
		palavraNomesFactory.getPalavra("Tigre", temaAnimais);
		palavraNomesFactory.getPalavra("Zebra", temaAnimais);
		palavraNomesFactory.getPalavra("Gato", temaAnimais);
		palavraNomesFactory.getPalavra("Dromedario", temaAnimais);
		palavraNomesFactory.getPalavra("Jabuti", temaAnimais);
		
		Tema temaCarros = temaFactory.getTema("Marcas de Carro");
		PalavraFactory palavraPaisCidadeFactory = aplicacao.getPalavraFactory();
		
		palavraPaisCidadeFactory.getPalavra("Wolksvagen", temaCarros);
		palavraPaisCidadeFactory.getPalavra("Fiat", temaCarros);
		palavraPaisCidadeFactory.getPalavra("Chevrolet", temaCarros);
		palavraPaisCidadeFactory.getPalavra("Hyundai", temaCarros);
		palavraPaisCidadeFactory.getPalavra("Chery", temaCarros);
		palavraPaisCidadeFactory.getPalavra("Mercedes-Benz", temaCarros);
		
		//Menu do Jogo
		Scanner input = new Scanner(System.in);
		int opcao;
		
		do {
			System.out.println("MENU DO JOGO");
			System.out.println("1 - jogar");
			System.out.println("0 - sair");
			System.out.println("digite uma opcao: ");
			opcao = input.nextInt();
			switch (opcao) {
			case 1:
				System.out.println("Entre com o nome do jogador: ");
				String nomeJogador = input.next();
				
				Jogador jogador = jogadorFactory.getJogador(nomeJogador);
				
				Rodada rodada = rodadaFactory.getRodada(jogador);
				
				jogar(rodada, jogador);
							
				break;

			default:
				System.out.println("Obrigado por jogar");
				System.out.println("Grupo: Mateus, Amarildo e Lucas");
				break;
			}
			
		}while(opcao!= 0);
		
		input.close();
		
	}
	
	private static void jogar(Rodada rodada, Jogador jogador) {
		Scanner input = new Scanner(System.in);
		
		while(rodada.encerrou() != true ) {
			System.out.println("Tema: " + rodada.getTema().getNome());
			System.out.println("jogador: " + jogador.getNome());
			
			System.out.println("Letras arriscadas: ");
			for(Letra letraTentativa: rodada.getTentativas()) {
				letraTentativa.exibir(null);
				System.out.print(" ");
			}
			
			System.out.println();
            
            System.out.println("Palavras:");
            rodada.exibirItens(null);
            System.out.println();
            System.out.println("Erros: " + rodada.getQtdeErros() + "/" + Rodada.getMaxErros());
            System.out.println("Corpo: ");
            rodada.exibirBoneco(null);
            System.out.println();

            System.out.println("Selecione uma opcao: ");
            System.out.println("1 - Digitar uma letra");
            System.out.println("2 - Arriscar palavra");

            String escolha = input.next();
            
            if (escolha.equalsIgnoreCase("1")) {
                System.out.print("Digite uma letra: ");
                char codigo = input.next().charAt(0);

                if (codigo >= 'A' && codigo <= 'Z') {
                    codigo = (char)(codigo+32);
                } 
                
                rodada.tentar(codigo); 

                System.out.println("");
            } else if (escolha.equalsIgnoreCase("2")) {
                List<String> palavras = new ArrayList<>();

                for (int i = 1; i <= rodada.getNumPalavras(); i++) {
                    System.out.println("Qual a palavra? ");
                    String palavra = input.next();
                    palavras.add(palavra);
                }

                rodada.arriscar(palavras);
                System.out.println("");
            }
            
           
        }

        if (rodada.descobriu() == true) {
            System.out.println("Parabens");
            rodada.exibirPalavras(null);
            
        } else {
            System.out.println("Você nao conseguiu, a palavra era: ");
            rodada.exibirPalavras(null);
            rodada.exibirBoneco(null);
            
        }

        System.out.println("Seus pontos foram: " + rodada.calcularPontos());
		}
	}
	
