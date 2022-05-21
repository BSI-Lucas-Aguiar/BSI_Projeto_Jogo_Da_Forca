package br.edu.iff.bancodepalavras.dominio.letra;

//Interface
//Factory
public interface LetraFactory {

	public Letra getLetra(char codigo);

	public Letra getLetraEncoberta();

}