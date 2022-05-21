package br.edu.iff.bancodepalavras.dominio.letra.texto;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;

public class LetraTexto extends Letra {

	protected LetraTexto(char codigo) {
		super(codigo);

	}

	//Implementado com system.out.print conforme documentação
	@Override
	public void exibir(Object object) {
		System.out.print(this.getCodigo());
	}
}