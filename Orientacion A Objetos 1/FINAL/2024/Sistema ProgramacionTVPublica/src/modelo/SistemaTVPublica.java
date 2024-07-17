package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SistemaTVPublica {
	private List<Contenido> contenido = new ArrayList<Contenido>();
	private List<Calendario> calendario = new ArrayList<Calendario>();

	public SistemaTVPublica() {
		super();
	}

	public List<Contenido> getContenido() {
		return contenido;
	}

	public void setContenido(List<Contenido> contenido) {
		this.contenido = contenido;
	}

	public List<Calendario> getCalendario() {
		return calendario;
	}

	public void setCalendario(List<Calendario> calendario) {
		this.calendario = calendario;
	}

	@SuppressWarnings("serial")
	public class InvalidCodContenidoException extends Exception {
		public InvalidCodContenidoException(String message) {
			super(message);
		}
	}

	public boolean agregarPrograma(String codContenido, String titulo, int duracion, String tipo) throws Exception {
		try {
			Programa nuevoPrograma = new Programa(contenido.size() + 1, codContenido, titulo, duracion, tipo);
			contenido.add(nuevoPrograma);
			return true;
		} catch (InvalidCodContenidoException e) {
			System.err.println("Error al agregar programa: " + e.getMessage());
			return false;
		}
	}

	public boolean agregarPelicula(String codContenido, String titulo, int duracion, String genero) throws Exception {
		try {
			Pelicula nuevaPelicula = new Pelicula(contenido.size() + 1, codContenido, titulo, duracion, genero);
			contenido.add(nuevaPelicula);
			return true;
		} catch (InvalidCodContenidoException e) {
			System.err.println("Error al agregar película: " + e.getMessage());
			return false;
		}
	}

	public Contenido traerContenido(String codContenido) {
		for (Contenido c : contenido) {
			if (c.getCodContenido().equals(codContenido)) {
				return c;
			}
		}
		return null; // Si no se encuentra el contenido con el código dado
	}

	public boolean agregarCalendario(LocalDate fecha, LocalTime hora, Contenido contenido) {
		if (contenido == null) {
			System.err.println("Error: El contenido no puede ser nulo");
			return false;
		}

		Calendario nuevoCalendario = new Calendario(calendario.size() + 1, fecha, hora, contenido);
		calendario.add(nuevoCalendario);
		return true;
	}

	public List<Pelicula> traerPelicula(String genero) {
        List<Pelicula> peliculas = new ArrayList<>();
        for (Contenido c : contenido) {
            if (c instanceof Pelicula) {
                Pelicula p = (Pelicula) c;
                if (p.getGenero().equalsIgnoreCase(genero)) {
                    peliculas.add(p);
                }
            }
        }
        return peliculas;
    }
}