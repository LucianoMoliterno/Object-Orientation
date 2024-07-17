package modelo;

public class Pelicula extends Contenido {
	private String genero;

	public Pelicula(int idContenido, String codContenido, String titulo, int duracion, String genero) throws Exception {
		super(idContenido, codContenido, titulo, duracion);
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Pelicula [genero=" + genero + "]";
	}

}
