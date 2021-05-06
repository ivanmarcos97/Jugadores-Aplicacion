package jugadores.liga;
/**
	 * Excepción usada en la aplicación «Jugadores» cuando se intenta
	 * manipular una entrada que no corresponde a un valor válido.
	 * 
	 * @versión 2021.2.0
	 * @author <a href="ivanm@hotmail.com">ivanm</a>
	 */
public class JugadorException extends Exception {
	
		/**
		 * Número de serie, asociado a la versión de la clase.
		 */
		private static final long serialVersionUID = 20210324001L;

		/**
		 * Crea una excepción sin ninguna información adicional.
		 */
		public JugadorException() {
			super();
		}

		/**
		 * Crea una excepción con un texto descriptivo.
		 * 
		 * @param mensaje el texto correspondiente
		 */
		public JugadorException(String mensaje) {
			super(mensaje);
		}

		/**
		 * Crea una excepción secundaria almacenando otra excepción de referencia.
		 * 
		 * @param causa la excepción –o {@link Throwable}– correspondiente
		 */
		public JugadorException(Throwable causa) {
			super(causa);
		}

		/**
		 * Crea una excepción secundaria almacenando otra excepción de referencia y un
		 * texto descriptivo.
		 * 
		 * @param mensaje el texto correspondiente
		 * @param causa   la excepción –o {@link Throwable}– correspondiente
		 */
		public JugadorException(String mensaje,
				Throwable causa) {
			super(mensaje, causa);
		}
	}

