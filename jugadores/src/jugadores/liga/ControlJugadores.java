package jugadores.liga;

import java.util.ArrayList;
import java.util.Scanner;

import jugadores.liga.JugadorException;

/**
 * Contiene el bucle principal que contendra las distintas opciones del programa
 * a elegir.
 * 
 * @author ivanm
 *
 */
public class ControlJugadores {
	/**
	 * Matriz con las opciones a elegir.
	 */
	private static final String[] OP_MENÚ_PRINCIPAL = {
			"                                                                                                              \n"
					+ "   `7MMF'`7MMF'   `7MF'  .g8\"\"\"bgd        db      `7MM\"\"\"Yb.     .g8\"\"8q.   `7MM\"\"\"Mq.  `7MM\"\"\"YMM   .M\"\"\"bgd \n"
					+ "     MM    MM       M  .dP'     `M       ;MM:       MM    `Yb. .dP'    `YM.   MM   `MM.   MM    `7  ,MI    \"Y \n"
					+ "     MM    MM       M  dM'       `      ,V^MM.      MM     `Mb dM'      `MM   MM   ,M9    MM   d    `MMb.     \n"
					+ "     MM    MM       M  MM              ,M  `MM      MM      MM MM        MM   MMmmdM9     MMmmMM      `YMMNq. \n"
					+ "     MM    MM       M  MM.    `7MMF'   AbmmmqMA     MM     ,MP MM.      ,MP   MM  YM.     MM   Y  , .     `MM \n"
					+ "(O)  MM    YM.     ,M  `Mb.     MM    A'     VML    MM    ,dP' `Mb.    ,dP'   MM   `Mb.   MM     ,M Mb     dM \n"
					+ " Ymmm9      `bmmmmd\"'    `\"bmmmdPY  .AMA.   .AMMA..JMMmmmdP'     `\"bmmd\"'   .JMML. .JMM..JMMmmmmMMM P\"Ybmmd\"  ",
			"Altas", "Ver listado", "Exportar", "Importar" };
	/**
	 * 
	 */
	private Scanner in;
	/**
	 * atributo de la clase Conjunto
	 */
	private ConjuntoJugadores jugadores;

	/**
	 * Asigna el valor de entrada y crea objetos de la clase conjunto.
	 * 
	 * @param in
	 */
	public ControlJugadores(Scanner in) {
		this.in = in;
		jugadores = new ConjuntoJugadores();
	}

	/**
	 * Activa el bucle principal de la clase .
	 */
	private void buclePrincipal() {
		String[] opciones = OP_MENÚ_PRINCIPAL;
		VistaMenu menu = new VistaMenu(opciones, in);

		int entrada = -1;

		// Bucle principal
		do {
			entrada = menu.elegirOpción();
			switch (entrada) {
			case 0: // Salir
				menu.mostrarMensaje("¡¡¡HASTA PRONTO JUGADOR!!");
				break;
			case 1: // Opción 1
				darDeAlta();
				break;
			case 2: // Opción 2
				listadoJugadores();
				break;
			case 3: // Opción 3
				try {
					volcarArchivo();
				} catch (JugadorException e) {
					String mensaje = String.format("Atencion: %s", e.getMessage());
					menu.mostrarMensaje(mensaje);
				}
				break;
			case 4: // Opción 4
				try {
					importarJugadores();
				} catch (JugadorException e) {
					String mensaje = String.format("Atencion: %s", e.getMessage());
					menu.mostrarMensaje(mensaje);
				}
				break;
			}

		} while (entrada != 0);
	}

	/**
	 * Permite dar de alta a nuevos objetos de la clase jugador.
	 */
	private void darDeAlta() {
		VistaAltaJugadores vista;
		Jugador jugadorNuevo;

		vista = new VistaAltaJugadores(in);
		jugadorNuevo = new Jugador();
		if (vista.gestionarAlta(jugadorNuevo)) {
			jugadores.añadir(jugadorNuevo);
		}
	}

	/**
	 * Permite sacar un listado de todos los jugadores almacenados en el programa.
	 */
	private void listadoJugadores() {
		VistaListadoJugadores vista;
		vista = new VistaListadoJugadores(in);
		vista.mostrarListado(jugadores.toListaString());

	}

	/**
	 * Permite pasar los jugadores a un archivo .txt.
	 * 
	 * @throws JugadorException
	 */
	private void volcarArchivo() throws JugadorException {

		VistaGeneral vista = new VistaGeneral(null);
		if (jugadores == null) {
			throw new JugadorException("No hay jugadores");
		}
		AccesoArchivoJugador.escribir("jugadores.txt", jugadores.toListaStringCSV("#"));
		AccesoArchivoJugador.escribir("jugadores.csv", jugadores.toListaStringCSV("#"));
		vista.mostrarTexto(
				"\n\n\n\n\n  ___                            _                 _                              _   _                     \n"
						+ " | __| __ __  _ __   ___   _ _  | |_   __ _   __  (_)  ___   _ _      ___  __ __ (_) | |_   ___   ___  __ _ \n"
						+ " | _|  \\ \\ / | '_ \\ / _ \\ | '_| |  _| / _` | / _| | | / _ \\ | ' \\    / -_) \\ \\ / | | |  _| / _ \\ (_-< / _` |\n"
						+ " |___| /_\\_\\ | .__/ \\___/ |_|    \\__| \\__,_| \\__| |_| \\___/ |_||_|   \\___| /_\\_\\ |_|  \\__| \\___/ /__/ \\__,_|\n"
						+ "             |_|                                                                                            \n\n\n\n\n");
	}

	/**
	 * Permite Dar de alta objetos de jugador desde un Archivo txt, No elimina los
	 * que ya esten dados de alta,es decir,los añade a los existentes.
	 * 
	 * @throws JugadorException
	 */
	private void importarJugadores() throws JugadorException {
		String[] listaDatosJugador;
		ArrayList<String> texto = new ArrayList<String>();
		Jugador archivoJugador;
		VistaGeneral vista = new VistaGeneral(null);

		texto = AccesoArchivoJugador.leer();
		for (String datosJugador : texto) {
			listaDatosJugador = datosJugador.split("#");
			archivoJugador = new Jugador(listaDatosJugador);
			jugadores.añadir(archivoJugador);
		}
		vista.mostrarTexto(
				"\n\n\n\n\n  ___                              _                 _                              _   _                     \n"
						+ " |_ _|  _ __    _ __   ___   _ _  | |_   __ _   __  (_)  ___   _ _      ___  __ __ (_) | |_   ___   ___  __ _ \n"
						+ "  | |  | '  \\  | '_ \\ / _ \\ | '_| |  _| / _` | / _| | | / _ \\ | ' \\    / -_) \\ \\ / | | |  _| / _ \\ (_-< / _` |\n"
						+ " |___| |_|_|_| | .__/ \\___/ |_|    \\__| \\__,_| \\__| |_| \\___/ |_||_|   \\___| /_\\_\\ |_|  \\__| \\___/ /__/ \\__,_|\n"
						+ "               |_|                                                                                             \n\n\n\n\n\n");
	}

	/**
	 * Inicializa los objetos y pone en marcha las distintas partes del programa.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ControlJugadores jugador = new ControlJugadores(sc);
		jugador.buclePrincipal();
		sc.close();
	}
}
