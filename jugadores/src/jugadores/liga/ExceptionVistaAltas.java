package jugadores.liga;

public class ExceptionVistaAltas extends Exception {

	/**
	 * Número de serie, asociado a la versión de la clase.
	 */
	private static final long serialVersionUID = 20210324001L;

	/**
	 * Crea una excepción sin ninguna información adicional.
	 */
	public ExceptionVistaAltas() {
		super();
	}

	/**
	 * Crea una excepción con un texto descriptivo.
	 * 
	 * @param mensaje el texto correspondiente
	 */
	public ExceptionVistaAltas(String mensaje) {
		super(mensaje);
	}

	/**
	 * Crea una excepción secundaria almacenando otra excepción de referencia.
	 * 
	 * @param causa la excepción –o {@link Throwable}– correspondiente
	 */
	public ExceptionVistaAltas(Throwable causa) {
		super(causa);
	}

	/**
	 * Crea una excepción secundaria almacenando otra excepción de referencia y un
	 * texto descriptivo.
	 * 
	 * @param mensaje el texto correspondiente
	 * @param causa   la excepción –o {@link Throwable}– correspondiente
	 */
	public ExceptionVistaAltas(String mensaje, Throwable causa) {
		super(mensaje, causa);

	}

}
