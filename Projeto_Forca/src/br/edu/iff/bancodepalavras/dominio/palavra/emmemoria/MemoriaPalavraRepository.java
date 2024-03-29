package br.edu.iff.bancodepalavras.dominio.palavra.emmemoria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.repository.RepositoryException;

//Implementa��o do banco de dados em mem�ria para a Palavra, utilizado na execu��o da aplica��o
public class MemoriaPalavraRepository implements PalavraRepository {

	private static MemoriaPalavraRepository soleInstance = null;

	//Singleton
	public static MemoriaPalavraRepository getSoleInstance() {
		if(soleInstance == null) {
			soleInstance = new MemoriaPalavraRepository();
		}
		return soleInstance;
	}

	private List<Palavra> pool;

	private MemoriaPalavraRepository() {
		pool = new ArrayList<Palavra>();
	}

	@Override
	public long getProximoId() {
		int contador = pool.size() + 1;
		return contador;
	}

	@Override
	public Palavra getPorId(long id) {
		for(Palavra palavraTemp: pool) {
			if(palavraTemp.getId() == id) {
				return palavraTemp;
			}
		}
		throw new RuntimeException("Palavra n�o encontrada no ID: " + id);
	}

	@Override
	public List<Palavra> getPorTema(Tema tema){
		List<Palavra> palavrasList = new ArrayList<>();
		for(Palavra palavraTemp: pool) {
			if(palavraTemp.getTema() == tema) {
				palavrasList.add(palavraTemp);
			}

		}
		return palavrasList;

	}

	@Override
	public List<Palavra> getTodas(){
		return Collections.unmodifiableList(pool);
	}

	@Override
	public Palavra getPalavras(String palavra) {
		for(Palavra palavraTemp: pool) {
			if(palavraTemp.comparar(palavra)) {
				return palavraTemp;
			}
		}

		throw new RuntimeException("A plavra n�o foi encontrada, palavra: " + palavra);
	}

	@Override
	public void inserir(Palavra palavra) throws RepositoryException{
		if(pool.contains(palavra)) {
			throw new RepositoryException("A palavra j� se encontra no reposit�rio");
		}
		else {
			pool.add(palavra);
		}
	}

	@Override
	public void remover(Palavra palavra)throws RepositoryException{
		if(pool.contains(palavra)) {
			pool.remove(palavra);
		}
		else {
			throw new RepositoryException("Palavra n�o localizada no reposit�rio");
		}
	}

	@Override
	public void atualizar(Palavra palavra) throws RepositoryException{
		this.remover(palavra);
		this.inserir(palavra);
	}

}