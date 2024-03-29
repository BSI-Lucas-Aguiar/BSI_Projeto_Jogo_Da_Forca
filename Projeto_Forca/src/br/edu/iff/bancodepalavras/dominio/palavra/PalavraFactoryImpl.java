package br.edu.iff.bancodepalavras.dominio.palavra;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.factory.EntityFactory;
import br.edu.iff.repository.Repository;
import br.edu.iff.repository.RepositoryException;

//Singleton Parametrizado
public class PalavraFactoryImpl extends EntityFactory implements PalavraFactory{

	private static PalavraFactoryImpl soleInstance = null;
	
	//Get e Set
	public static PalavraFactoryImpl getSoleInstance() {
		if(soleInstance == null) {
			throw new RuntimeException("cria��o de palavras nao iniciada");
		}
		
		return soleInstance;
	}
	
	//Construtor
	private PalavraFactoryImpl(Repository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}
	
	//Metodo Singleton Parametrizado
	public static void createSoleInstance(PalavraRepository palavraRepository) {
		soleInstance = new PalavraFactoryImpl(palavraRepository);
	}
	
	private PalavraRepository getPalavraRepository() {
		return (PalavraRepository) getRepository();
	}
	
	

	@Override
	public Palavra getPalavra(String palavra, Tema tema) {
		Palavra palavraTemp = Palavra.criar(getProximoId(), palavra, tema);
		try {
			getPalavraRepository().inserir(palavraTemp);
		} catch (RepositoryException repositoryException) {
			throw new RuntimeException("Erro para gravar palavra");
			// TODO: handle exception
		}
		return palavraTemp;
	}
	

}