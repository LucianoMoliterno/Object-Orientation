package modelo;

public class Programa extends Contenido {
	private String tipo;

	public Programa(int idContenido, String codContenido, String titulo, int duracion, String tipo) throws Exception {
		super(idContenido, codContenido, titulo, duracion);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Programa [tipo=" + tipo + "]";
	}

}
