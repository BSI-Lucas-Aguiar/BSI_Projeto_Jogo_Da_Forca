package br.edu.iff.jogoforca.dominio.jogador.embdr;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.repository.RepositoryException;

public class BDRJogadorRepository implements JogadorRepository {
	
	private static BDRJogadorRepository soleInstance = null;
	
	public static BDRJogadorRepository getSoleInstance() {
		if(soleInstance == null) {
			soleInstance = new BDRJogadorRepository();
		}
		
		return soleInstance;
	}

	@Override
	public long getProximoId() {
		return 0;
	}

	@Override
	public Jogador getPorId(Long id) {
		return null;
	}

	@Override
	public Jogador getPorNome(String nome) {
		return null;
	}

	@Override
	public void inserir(Jogador jogador) throws RepositoryException {
		
	}

	@Override
	public void atualizar(Jogador jogador) throws RepositoryException {
		
	}

	@Override
	public void remover(Jogador jogador) throws RepositoryException {
		
	}

}