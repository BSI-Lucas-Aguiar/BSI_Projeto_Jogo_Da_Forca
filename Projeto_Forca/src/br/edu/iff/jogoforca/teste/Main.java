package br.edu.iff.jogoforca.teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraFactory;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraFactoryImpl;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.bancodepalavras.dominio.tema.TemaFactory;
import br.edu.iff.jogoforca.Aplicacao;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.jogador.JogadorFactory;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaAppService;
import br.edu.iff.jogoforca.dominio.rodada.RodadaFactory;
import br.edu.iff.repository.RepositoryException;

public class Main {

	public static void main(String[] args) throws RepositoryException {
		
		Scanner input = new Scanner(System.in); 
		Aplicacao aplicacao = Aplicacao.getSoleInstance();
		RodadaAppService rodadaAppService = RodadaAppService.getSoleInstance();
		int opcao;
		
		JogadorFactory jogadorFactory = aplicacao.getJogadorFactory();
		TemaFactory temaFactory = aplicacao.getTemaFactory();
		RodadaFactory rodadaFactory = aplicacao.getRodadaFactory();
		
		//Inicio - cadastro de temas 
		//Durante o cadastro não é permitido:
		//Espaço, Caracteres especiais, Maiusculas
		
		Tema temaNomes = temaFactory.getTema("Nome de Pessoas");
		PalavraFactory palavraNomesFactory = aplicacao.getPalavraFactory();
		
		palavraNomesFactory.getPalavra("amarildo", temaNomes);
		palavraNomesFactory.getPalavra("mateus", temaNomes);
		palavraNomesFactory.getPalavra("lucas", temaNomes);
		
		Tema temaCarros = temaFactory.getTema("Marcas de Carro");
		PalavraFactory palavraCarrosFactory = aplicacao.getPalavraFactory();
		
		palavraCarrosFactory.getPalavra("wolksvagen", temaCarros);
		palavraCarrosFactory.getPalavra("chevrolet", temaCarros);
		palavraCarrosFactory.getPalavra("hyundai", temaCarros);
		//Fim Cadastro --

		do {
			System.out.println("*-*JOGO DA FORCA v1.0*-*\n");
			System.out.println("1 - Jogar");
			System.out.println("0 - Sair");
			System.out.println("Digite uma opcao: ");
			opcao = input.nextInt();
			switch (opcao) {
			case 1:
				System.out.println("Entre com o nome do jogador atual: ");
				String nomeJogador = input.next();
				
				Jogador jogador = jogadorFactory.getJogador(nomeJogador);
				
				Rodada rodada = rodadaFactory.getRodada(jogador);
				
				jogar(rodada, jogador);
				//Salvamento de rodada, não implementado
				//rodadaAppService.salvarRodada(rodada);
				
				break;
			default:
				System.out.println("Jogo Encerrado!");
				System.out.println("Grupo: Amarildo, Lucas, Mateus");
				break;
			}
			
		}while(opcao!= 0);
		
		input.close();

	}
	private static void jogar(Rodada rodada, Jogador jogador) {
		
		Scanner input = new Scanner(System.in);
		
		String temaAtual = rodada.getTema().getNome();
		String jogadorAtual = jogador.getNome();

		while(rodada.encerrou() == false) {
			System.out.println("Tema: " + temaAtual + " || Jogador: " + jogadorAtual);

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
			System.out.println("-----Parabens voce acertou!-----");
			rodada.exibirPalavras(null);

		} else {
			System.out.println("Resposta incorreta, a palavra era: ");
			rodada.exibirPalavras(null);
			rodada.exibirBoneco(null);
			System.out.println("");
			System.out.println("Enforcado!!");
		}

		System.out.println("Seus pontos foram: " + rodada.calcularPontos());


	}		

}
