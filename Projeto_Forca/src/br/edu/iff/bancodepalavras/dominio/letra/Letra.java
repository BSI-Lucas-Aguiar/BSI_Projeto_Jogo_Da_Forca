package br.edu.iff.bancodepalavras.dominio.letra;

//Abstract
//Value
//flyweigth
public abstract class Letra {

	protected char codigo;

	public char getCodigo() {
		return codigo;
	}

	protected Letra(char codigo) {
		this.codigo = codigo;
	}


	public abstract void exibir(Object object);

	@Override
	public final String toString() {
		return "Letra" + codigo ;
	}

	//Implementa��o do Flyweight
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Letra)) {
			return false;
		}
		Letra outra = (Letra) o;

		return this.codigo == outra.codigo && this.getClass().equals(outra.getClass());
	}

	@Override
	public int hashCode() {
		return this.codigo + this.getClass().hashCode();
	}
}