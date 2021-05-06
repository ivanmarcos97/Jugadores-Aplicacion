package jugadores.liga;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Conjunto de objetos de la clase {@link Jugador}.
 * 
 * @author ivanm
 *
 */
public class ConjuntoJugadores {
	/**
	 * Matriz de jugadores
	 */
	private ArrayList<Jugador> lista;

	/**
	 * Crea e inicializa una nueva lista.
	 */
	public ConjuntoJugadores() {
		lista = new ArrayList<Jugador>();
	}

	/**
	 * Agrega jugadores a la lista
	 * 
	 * @param jugador
	 */
	public void añadir(Jugador jugador) {
		lista.add(jugador);
	}

	/**
	 * Devuelve una representación textual de los jugadores .
	 * 
	 * @return listaJug lista del jugador transformado a texto.
	 */
	public ArrayList<String> toListaString() {
		ArrayList<String> listaJug = new ArrayList<String>(lista.size());
		String texto;
		for (Jugador resultado : lista) {
			texto = resultado.toString();
			listaJug.add(texto);
		}
		return listaJug;
	}

	/**
	 * Devuelve una representación en Pseudo-CSV de los jugadores separados por un
	 * parámetro.
	 * 
	 * @param separador
	 * @return listaJug lista del jugador transformado a texto.
	 */
	public ArrayList<String> toListaStringCSV(String separador) {
		ArrayList<String> listaJug = new ArrayList<String>(lista.size());
		String texto;
		for (Jugador resultado : lista) {
			texto = resultado.toStringCSV(separador);
			listaJug.add(texto);
		}
		return listaJug;
	}

}
