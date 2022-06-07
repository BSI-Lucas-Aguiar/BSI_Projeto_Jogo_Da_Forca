package br.edu.iff.bancodepalavras.dominio.palavra;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;

//Interface
//Factory
public interface PalavraFactory {
	
	public Palavra getPalavra(String palavra, Tema tema);
}