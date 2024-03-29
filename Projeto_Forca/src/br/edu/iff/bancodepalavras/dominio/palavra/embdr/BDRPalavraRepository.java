package br.edu.iff.bancodepalavras.dominio.palavra.embdr;

import java.util.List;

import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.repository.RepositoryException;

//N�o foi feita implementa��o pois foi feita utilizando banco de dados em mem�ria
//No entando possui algumas m�todos, que n�o s�o utilizados
public class BDRPalavraRepository implements PalavraRepository {

	private static BDRPalavraRepository soleInstance = null;

	public static BDRPalavraRepository getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new BDRPalavraRepository();
		}

		return soleInstance;
	}

	private BDRPalavraRepository() {

	}

	@Override
	public long getProximoId() {
		return 0;
	}

	@Override
	public Palavra getPorId(long id) {
		return null;
	}

	@Override
	public void atualizar(Palavra palavra) throws RepositoryException {

	}

	@Override
	public void remover(Palavra palavra) throws RepositoryException {

	}

	@Override
	public void inserir(Palavra palavra) throws RepositoryException {

	}

	@Override
	public Palavra getPalavras(String palavra) {
		return null;
	}

	@Override
	public List<Palavra> getTodas() {
		return null;
	}

	@Override
	public List<Palavra> getPorTema(Tema tema) {
		return null;
	}

}