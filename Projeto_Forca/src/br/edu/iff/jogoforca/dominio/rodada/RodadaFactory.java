package br.edu.iff.jogoforca.dominio.rodada;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;

//Interface
//Factory
public interface RodadaFactory {
	public Rodada getRodada(Jogador jogador);
}