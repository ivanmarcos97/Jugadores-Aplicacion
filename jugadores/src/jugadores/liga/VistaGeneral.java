package jugadores.liga;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Proporciona metodos comunes de las vistas
 * 
 * @author ivanm
 *
 */
public class VistaGeneral {
	/**
	 * Entrada
	 */
	protected Scanner in;
	/**
	 * Salida por pantalla
	 */
	protected PrintStream out;

	/**
	 * Asigna la entrada y salida.
	 * 
	 * @param in
	 */
	public VistaGeneral(Scanner in) {
		this.in = in;
		out = System.out;
	}

	/**
	 * formato para mostrar textos.
	 * 
	 * @param mensaje
	 */
	public void mostrarTexto(String mensaje) {
		out.printf("%n%s", mensaje);
	}

	/**
	 * formato para mostrar Avisos.
	 * 
	 * @param aviso
	 */
	public void mostrarAviso(String aviso) {
		out.printf("%n%s%n", aviso);

	}

	/**
	 * Recoge los textos de la entrada.
	 * 
	 * @param resultado
	 */
	protected String recogerTexto() throws ExceptionVistaAltas {
		String resultado = "";
		boolean salir = false;
		
		do {
			try {
				 resultado = in.nextLine();
				if (resultado.equals("")||resultado.equals(null)||resultado.equals(" ")){
					throw new ExceptionVistaAltas("Texto no válido");
				}else if(!resultado.matches("^[a-zA-ZñÑ-áÁéÉíÍóÓúÚç\s]+")) {
					throw new ExceptionVistaAltas("No puede contener numeros ni caracteres especiales");
				}
				
				salir = true;
			} catch (ExceptionVistaAltas e) {
				mostrarTexto("Texto no válido");
			}
		} while (!salir);
		return resultado;

	}

	/**
	 * Recoge los numeros enteros de la entrada.
	 * @param mínimo
	 * @param máximo
	 * @return
	 * @throws ExceptionVistaAltas
	 */
	protected int recogerNúmeroEntero(int mínimo, int máximo) throws ExceptionVistaAltas {
		int resultado = 0;
		boolean salir = false;

		do {
			try {
				String s = in.nextLine();
				resultado = Integer.parseInt(s);
				if (resultado < mínimo || resultado > máximo) {
					throw new ExceptionVistaAltas("Numero entero no valido");
				}
				salir = true;
			} catch (NumberFormatException e) {
				mostrarTexto("¡El sistema solo admite números enteros!");
			} catch (ExceptionVistaAltas e) {
				String mensaje = String.format("¡Hay que introducir una opción de menú válida (%d-%d, 0 para salir)!",
						mínimo, máximo);
				mostrarTexto(mensaje);
			}
		} while (!salir);

		return resultado;
	}

}
