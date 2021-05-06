package jugadores.liga;

import java.util.Scanner;

public class VistaAltaJugadores extends VistaGeneral {

	/**
	 * Hereda atributos del padre {@link VistaGeneral}
	 * 
	 * @param in
	 */
	public VistaAltaJugadores(Scanner in) {
		super(in);
	}

	/**
	 * Permite dar de alta nuevos objetos de la clase Jugador,pidiendo e
	 * introduciendo los datos de este.
	 * 
	 * @param jugadorNuevo
	 * @return
	 */
	public boolean gestionarAlta(Jugador jugadorNuevo) {

		boolean datosCorrectos = false;
		boolean datosAceptados = false;
mostrarTexto("    _     _   _               \n"
		+ "   /_\\   | | | |_   __ _   ___\n"
		+ "  / _ \\  | | |  _| / _` | (_-<\n"
		+ " /_/ \\_\\ |_|  \\__| \\__,_| /__/\n\n\n");
		do {
			try {
				mostrarTexto("Introduzca el Nombre del Nuevo Jugador → ");
				jugadorNuevo.setNombre(recogerTexto());

				mostrarTexto("Introduzca los Apellidos del Nuevo Jugador → ");
				jugadorNuevo.setApellido(recogerTexto());

				mostrarTexto("Introduzca la Ciudad del Nuevo Jugador → ");
				jugadorNuevo.setCiudadProcedencia(recogerTexto());

				mostrarTexto("Introduzca el País del Nuevo Jugador → ");
				jugadorNuevo.setPais(recogerTexto());

				mostrarTexto("Introduzca la edad del Nuevo Jugador → ");
				jugadorNuevo.setEdad(recogerNúmeroEntero(1, 110));

				mostrarTexto("Introduzca el Equipo del Nuevo Jugador → ");
				jugadorNuevo.setEquipo(recogerTexto());

				mostrarTexto("Introduzca el Deporte que practica el Nuevo Jugador → ");
				jugadorNuevo.setDeporteX(deporteElegido());

				datosCorrectos = true;

			} catch (ExceptionVistaAltas e) {

				mostrarAviso("Codigo incorrecto");

			}
		} while (!datosCorrectos);

		datosAceptados = pedirConfirmación("¿Desea dar de alta a este jugador?", jugadorNuevo);

		return datosAceptados;
	}

	/**
	 * Da la opción de confirmación.
	 * 
	 * @param mensaje
	 * @return verdadero/falso
	 */
	private boolean pedirConfirmación(String mensaje, Jugador jugadorNuevo) {
		boolean confirmacionAceptada = false;
		boolean confirmacionContestada = false;
		do {
			out.printf("%n%s%n    %s%n", mensaje, jugadorNuevo);
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
/**
 * Elección de uno de los deportes de la enumeración.
 * @return
 * @throws ExceptionVistaAltas
 */
	public Deportes deporteElegido() throws ExceptionVistaAltas {
		Deportes deporteElegido;
		int indice;
		int i = 0;

		Deportes[] listaDeportes = Deportes.values();

		for (Deportes d : listaDeportes) {
			String nombre = d.name();
			out.printf("%n%n%d: %s%n", ++i, nombre);
		}

		indice = recogerNúmeroEntero(0, listaDeportes.length);
		deporteElegido = listaDeportes[indice - 1];

		return deporteElegido;
	}

}
