package br.edu.iff.jogoforca;

import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;

//Interface
//Factory
//Busca os demais repositories da aplica��o
public interface RepositoryFactory {

	public PalavraRepository getPalavraRepository();
	
	public TemaRepository getTemaRepository();
	  
	public RodadaRepository getRodadaRepository();
	  
	public JogadorRepository getJogadorRepository();


}