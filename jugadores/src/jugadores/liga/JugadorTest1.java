/**
 * 
 */
package jugadores.liga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Prueba unitaria de los metodos de {@link Jugador}.
 * 
 * @author ivanm
 *
 */
class JugadorTest1 {
	/**
	 * Objeto clase Jugador.
	 */
	private Jugador j1;

	/**
	 * Prepara diferentes valores para posteriormente realizar la prueba.
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		j1 = new Jugador("Iván", "Marcos", "Burgos", "España", 23, "Burgos CF", Deportes.FUTBOL);

	}

	/**
	 * Verifica que el Nombre sea el correcto.
	 */
	@Test
	void testGetNombre() {
		String resultadoReal = j1.getNombre();
		String resultadoEsperado = ("Iván");
		assertEquals(resultadoEsperado, resultadoReal);
	}

	/**
	 * Verifica que al modificar el Nombre ,este sea correcto.
	 */
	@Test
	void testSetNombre() {
		j1.setNombre("Iván");
		assertEquals("Iván", j1.getNombre());
	}

	/**
	 * Verifica que el Apellido sea el correcto.
	 */
	@Test
	void testGetApellido() {
		String resultadoReal = j1.getApellido();
		String resultadoEsperado = ("Marcos");
		assertEquals(resultadoEsperado, resultadoReal);
	}

	/**
	 * Verifica que al modificar el Apellido ,este sea correcto.
	 */
	@Test
	void testSetApellido() {
		j1.setApellido("Marcos");
		assertEquals("Marcos", j1.getApellido());
	}

	/**
	 * Verifica que la Ciudad sea la correcta.
	 */
	@Test
	void testGetCiudadProcedencia() {
		String resultadoReal = j1.getCiudadProcedencia();
		String resultadoEsperado = ("Burgos");
		assertEquals(resultadoEsperado, resultadoReal);
	}

	/**
	 * Verifica que al modificar la ciudad ,esta sea correcto.
	 */
	@Test
	void testSetCiudadProcedencia() {
		j1.setCiudadProcedencia("Burgos");
		assertEquals("Burgos", j1.getCiudadProcedencia());
	}

	/**
	 * Verifica que el Pais sea el correcto.
	 */
	@Test
	void testGetPais() {
		String resultadoReal = j1.getPais();
		String resultadoEsperado = ("España");
		assertEquals(resultadoEsperado, resultadoReal);
	}

	/**
	 * Verifica que al modificar el Pais ,este sea correcto.
	 */
	@Test
	void testSetPais() {
		j1.setCiudadProcedencia("España");
		assertEquals("España", j1.getPais());
	}

	/**
	 * Verifica que la edad sea la correcta.
	 */
	@Test
	void testGetEdad() {
		int resultadoReal = j1.getEdad();
		int resultadoEsperado = (23);
		assertEquals(resultadoEsperado, resultadoReal);
	}

	/**
	 * Verifica que al modificar la edad ,esta sea correcta.
	 */
	@Test
	void testSetEdad() {
		j1.setEdad(23);
		assertEquals(23, j1.getEdad());
	}

	/**
	 * Verifica que el equipo sea el correcto.
	 */
	@Test
	void testGetEquipo() {
		String resultadoReal = j1.getEquipo();
		String resultadoEsperado = ("Burgos CF");
		assertEquals(resultadoEsperado, resultadoReal);
	}

	/**
	 * Verifica que al modificar el equipo ,este sea correctO.
	 */
	@Test
	void testSetEquipo() {
		j1.setEquipo("Burgos CF");
		assertEquals("Burgos CF", j1.getEquipo());
	}

	/**
	 * Verifica que el deporte sea el correcto.
	 */
	@Test
	void testGetDeporteX() {
		Deportes resultadoReal = j1.getDeporteX();
		Deportes resultadoEsperado = (Deportes.FUTBOL);
		assertEquals(resultadoEsperado, resultadoReal);
	}

	/**
	 * Verifica que al modificar el deporte ,este sea correcto.
	 */
	@Test
	void testSetDeporteX() {
		j1.setDeporteX(Deportes.FUTBOL);
		assertEquals(Deportes.FUTBOL, j1.getDeporteX());
	}

	/**
	 * Verifica que la salida por pantalla sea correcta.
	 */
	@Test
	void testToString() {
		assertEquals("\n" + " Nombre: Iván\n" + "  Apellido: Marcos\n" + "  Ciudad: Burgos\n" + "  Pais: España\n"
				+ "  Edad: 23\n" + "  Equipo: Burgos CF\n" + "  Deporte: FUTBOL\n" + " ", j1.toString());
	}

	/**
	 * Método de prueba para
	 * {@link jugadores.liga.Jugador#toStringCSV(java.lang.String)}.
	 */
	@Test
	void testToStringCSV() {
		assertEquals("Iván#Marcos#Burgos#España#23#Burgos CF#FUTBOL#", j1.toStringCSV("#"));
	}

}
