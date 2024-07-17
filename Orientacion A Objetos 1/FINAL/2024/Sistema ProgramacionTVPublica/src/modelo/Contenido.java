package modelo;

import java.util.Objects;

public abstract class Contenido {
	protected int idContenido;
	protected String codContenido;
	protected String titulo;
	protected int duracion;

	public Contenido(int idContenido, String codContenido, String titulo, int duracion) throws Exception {
		super();
		this.idContenido = idContenido;
		this.setCodContenido(codContenido);
		;
		this.titulo = titulo;
		this.duracion = duracion;
	}

	public int getIdContenido() {
		return idContenido;
	}

	public void setIdContenido(int idContenido) {
		this.idContenido = idContenido;
	}

	public String getCodContenido() {
		return codContenido;
	}

	public void setCodContenido(String codContenido) throws Exception {
		if (isValidCodContenido(codContenido)) {
			this.codContenido = codContenido;
		} else {
			throw new Exception("codContenido Invalido: " + codContenido);
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Contenido [idContenido=" + idContenido + ", codContenido=" + codContenido + ", titulo=" + titulo
				+ ", duracion=" + duracion + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Contenido other = (Contenido) obj;
		return Objects.equals(codContenido, other.codContenido);
	}

	private boolean isValidCodContenido(String codContenido) {
		if (codContenido == null || codContenido.length() != 5) {
			return false;
		}

		try {
			int sum = 0;
			for (int i = 0; i < 4; i++) {
				sum += Character.getNumericValue(codContenido.charAt(i));
			}
			int congruence = sum % 10;
			return congruence == Character.getNumericValue(codContenido.charAt(4));
		} catch (NumberFormatException e) {
			return false;
		}
	}
}