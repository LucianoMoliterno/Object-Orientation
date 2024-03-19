package modelo;

public class Fraccion {
	private int numerador, denominador;

	public Fraccion(int numerador, int denominador) throws Exception {
		this.numerador = numerador; // en el constructor sólo se asigna por el this.atributo
		this.setDenominador(denominador); // o por this.setAtributo, NO se debe implementar funcionalidad en el
											// constructor
	}

	public int getNumerador() {
		return numerador;
	}

	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	public int getDenominador() {
		return denominador;
	}

public void setDenominador(int denominador) throws Exception {
	if (denominador ==0) throw new Exception("Error: Objeto Fracción inválido, el denominador NO puede ser cero");
	this.denominador = denominador;
}

	public String toString() {
		return "(" + numerador + "/" + denominador + ")";
	}

	public Fraccion dividir(Fraccion f) throws Exception {
		if (f.convertirAReal() == 0)
			throw new Exception("Error División por cero: " + f);

		return new Fraccion(numerador * f.getDenominador(), denominador * f.getNumerador());
	}

	public double convertirAReal() throws Exception {
		return (Funciones.convertirADouble(numerador) / Funciones.convertirADouble(denominador));
	}

public double raizCuadrada() throws Exception{
	if (numerador *denominador <0) throw new Exception("Error: el radicando es negativo");
	return Math.pow(this.convertirAReal(), 0.5);
}
}
