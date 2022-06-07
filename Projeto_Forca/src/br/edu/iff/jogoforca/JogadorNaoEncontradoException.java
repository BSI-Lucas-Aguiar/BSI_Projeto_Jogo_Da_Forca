package br.edu.iff.jogoforca;

public class JogadorNaoEncontradoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String jogador;
	
	//Construtor
	public JogadorNaoEncontradoException(String jogador) {
		super(jogador);
	}
	

	//Get
	public String getJogador() {
		return this.jogador;
	}
	

}