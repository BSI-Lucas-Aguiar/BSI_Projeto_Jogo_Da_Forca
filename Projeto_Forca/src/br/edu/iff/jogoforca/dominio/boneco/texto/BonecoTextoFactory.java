package br.edu.iff.jogoforca.dominio.boneco.texto;

import br.edu.iff.jogoforca.dominio.boneco.Boneco;
import br.edu.iff.jogoforca.dominio.boneco.BonecoFactory;

public class BonecoTextoFactory implements BonecoFactory {
	//Singleton - Se a instancia for nula, cria uma nova, do contrário retorna a que já existe
	private static BonecoTextoFactory solInstance = null;

	public static BonecoTextoFactory getSolInstance() {
		if(solInstance == null) {
			solInstance = new BonecoTextoFactory();
		}
		return solInstance;
	}

	private BonecoTextoFactory() {

	}

	@Override
	public Boneco getBoneco() {
		return BonecoTexto.getSoleInstance();
	}


}