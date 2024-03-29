package br.edu.iff.jogoforca.dominio.jogador;

import br.edu.iff.factory.EntityFactory;
import br.edu.iff.repository.RepositoryException;

//Singleton Parametrizado
public class JogadorFactoryImpl extends EntityFactory implements JogadorFactory {

	private static JogadorFactoryImpl soleInstance = null;

	//Singleton
	public static void createSoleInstance(JogadorRepository jogadorRepository) {
		soleInstance = new JogadorFactoryImpl(jogadorRepository);
	}

	public static JogadorFactoryImpl getSoleInstance() {
		if(soleInstance == null) {
			throw new RuntimeException(" jogador n�o inicializado");
		}

		return soleInstance;

	}

	private JogadorFactoryImpl(JogadorRepository jogadorRepository) {
		super(jogadorRepository);
	}

	private JogadorRepository getJogadorRepository() {
		return (JogadorRepository) getRepository();
	}


	@Override
	public Jogador getJogador(String nome) {

		Jogador jogador = Jogador.criar(getProximoId(), nome);

		try {
			getJogadorRepository().inserir(jogador);
		} catch ( RepositoryException repositoryException) {
			throw new RuntimeException ("Ocorreu um erro ao tentar salvar o jogador");

		}

		return jogador;
	}

}