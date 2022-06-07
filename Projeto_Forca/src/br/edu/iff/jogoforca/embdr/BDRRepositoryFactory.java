package br.edu.iff.jogoforca.embdr;

import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.jogoforca.RepositoryFactory;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;

//Singleton
public class BDRRepositoryFactory implements RepositoryFactory  {
	
	private static BDRRepositoryFactory soleInstance = null;
	
	//get set
	public static BDRRepositoryFactory getSoleInstance() {
		if(soleInstance == null) {
			soleInstance = new BDRRepositoryFactory();
		}
		
		return soleInstance;
	}
	
	private BDRRepositoryFactory() {

	}

	@Override
	public PalavraRepository getPalavraRepository() {
		return null;
	}

	@Override
	public TemaRepository getTemaRepository() {
		return null;
	}

	@Override
	public RodadaRepository getRodadaRepository() {
		return null;
	}

	@Override
	public JogadorRepository getJogadorRepository() {
		return null;
	}


}