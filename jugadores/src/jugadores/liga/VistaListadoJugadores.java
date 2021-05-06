package jugadores.liga;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Crea un listado y permite visualizarlo.
 * @author ivanm
 *
 */
public class VistaListadoJugadores extends VistaGeneral {
/**
 * Hereda atributos del padre {@link VistaGeneral}
 * @param in
 */
	public VistaListadoJugadores(Scanner in) {
		super(in);

	}

	/**
	 * Muestra por pantalla el listado de jugadores. 
	 * @param arrayConjun
	 */
	public void mostrarListado(ArrayList<String> arrayConjun) {
		int linea = 0;
		mostrarTexto("  _      _        _               _              _                           _                        \n"
				+ " | |    (_)  ___ | |_   __ _   __| |  ___     _ | |  _  _   __ _   __ _   __| |  ___   _ _   ___   ___\n"
				+ " | |__  | | (_-< |  _| / _` | / _` | / _ \\   | || | | || | / _` | / _` | / _` | / _ \\ | '_| / -_) (_-<\n"
				+ " |____| |_| /__/  \\__| \\__,_| \\__,_| \\___/    \\__/   \\_,_| \\__, | \\__,_| \\__,_| \\___/ |_|   \\___| /__/\n"
				+ "                                                           |___/                                      \n");
		for (int i = 0; i < arrayConjun.size(); i++) {
			out.println(VistaMenu.rellenar(30, '-'));
			out.println(arrayConjun.get(i));
			
			linea++;
			if (linea % 10 == 0) {

				if (!confirmar("¿desea ver todo el listado?")) {
					break;
				}
			}

		}
	}
/**
 * Da la opción de confirmación.
 * @param mensaje
 * @return verdadero/falso 
 */
	private boolean confirmar(String mensaje) {
		boolean confirmacionAceptada = false;
		boolean confirmacionContestada = false;
		do {
			out.printf("%n%s%n", mensaje);
			out.printf("%n S / N%n");

			String entrada = in.nextLine();

			if ("S".equals(entrada.toUpperCase())) {
				confirmacionAceptada = true;
				confirmacionContestada = true;
			} else if ("N".equals(entrada.toUpperCase())) {
				confirmacionAceptada = false;
				confirmacionContestada = true;
			} else {
				confirmacionAceptada = false;
				confirmacionContestada = false;
			}

		} while (!confirmacionContestada);
		return confirmacionAceptada;

	}
}