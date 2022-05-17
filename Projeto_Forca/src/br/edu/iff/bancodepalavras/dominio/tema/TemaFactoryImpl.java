package br.edu.iff.bancodepalavras.dominio.tema;

import br.edu.iff.factory.EntityFactory;

public class TemaFactoryImpl extends EntityFactory implements TemaFactory{

	private TemaFactoryImpl soleInstance;
	
	public static void createSoleInstance(TemaRepository temaRepository) {
		soleInstance = new TemaFactoryImpl(temaRepository);
	}
	
	
}
