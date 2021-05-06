package jugadores.liga;

/**
 * Establece a un jugador sus datos.
 * 
 * @author ivanm
 *
 */
public class Jugador {
	/**
	 * Nombre del jugador
	 */
	private String nombre;
	/**
	 * Apellido del jugador
	 */
	private String apellido;
	/**
	 * Ciudad de procedencia del jugador
	 */
	private String ciudadProcedencia;
	/**
	 * Pais de procedencia del Jugador
	 */
	private String pais;
	/**
	 * Edad del Jugador
	 */
	private int edad;
	/**
	 * Equipo en el que juega El jugador
	 */
	private String equipo;
	/**
	 * Deporte practicado por el jugador
	 */
	private Deportes deporteX;

	
	public Jugador() {
		super();
	}

	/**
	 * Crea un objeto con los datos correspondientes.
	 * @param nombre
	 * @param apellido
	 * @param ciudadProcedencia
	 * @param pais
	 * @param edad
	 * @param equipo
	 * @param deporteX
	 */

	public Jugador(String nombre, String apellido, String ciudadProcedencia, String pais, int edad, String equipo,
			Deportes deporteX) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.ciudadProcedencia = ciudadProcedencia;
		this.pais = pais;
		this.edad = edad;
		this.equipo = equipo;
		this.deporteX = deporteX;
	}
/**
 * Crea una matriz con los datos del jugador
 * @param listaDatosJugador
 */
	public Jugador(String[] listaDatosJugador) {
		this(listaDatosJugador[0],listaDatosJugador[1],listaDatosJugador[2],listaDatosJugador[3]
				,Integer.parseInt(listaDatosJugador[4]),listaDatosJugador[5],Deportes.valueOf(listaDatosJugador[6]));
		}
	

	/**
	 * Devuelve el nombre
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * el nombre a establecer
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el apellido
	 * @return el apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * el apellido a establecer
	 * 
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Devuelve la ciudad del jugador.
	 * @return la ciudad de procedencia
	 */
	public String getCiudadProcedencia() {
		return ciudadProcedencia;
	}

	/**
	 * la ciudad de procedencia a establecer 
	 * @param ciudadProcedencia
	 */
	public void setCiudadProcedencia(String ciudadProcedencia) {
		this.ciudadProcedencia = ciudadProcedencia;
	}

	/**
	 * Devuelve el pais
	 * @return el pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * el pais a establecer
	 * @param pais
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * Devuelve la edad
	 * @return edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * la edad a establecer
	 * @param edad
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Devuelve el equipo
	 * @return el equipo
	 */
	public String getEquipo() {
		return equipo;
	}

	/**
	 * el equipo a establecer
	 * @param equipo
	 */
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	/**
	 * Devuelve el deporte
	 * @return el deporteX
	 */
	public Deportes getDeporteX() {
		return deporteX;
	}

	/**
	 * el deporteX a establecer
	 * @param deporteX el deporteX a establecer
	 */
	public void setDeporteX(Deportes deporteX) {
		this.deporteX = deporteX ;
	}
	/**
	 * Devuelve una representación textual de los  valores que forman el
	 * jugador con formato:
	 * <pre>
	Nombre: %s%n  Apellido:%s%n  Ciudad: %s%n  Pais: %s%n  Edad: %s%n  Equipo: %s%n  Deporte: %s%n 
	 * </pre>
	 * 
	 * @return el texto correspondiente.
	 */
	public String toString() {
		String texto;
		texto = String.format("%n Nombre: %s%n  Apellido: %s%n  Ciudad: %s%n  Pais: %s%n  Edad: %s%n "
				+ " Equipo: %s%n  Deporte: %s%n ", nombre, apellido, ciudadProcedencia, pais, edad, equipo,
				deporteX);
		return texto;
	}
/**
 * Devuelve el formato Pseudo-CSV de salida del Jugador en pantalla
 * @param separador
 * @return 
 */
	public String toStringCSV(String separador) {
		StringBuffer texto = new StringBuffer();

		texto.append(String.format("%s%s", nombre, separador));
		texto.append(String.format("%s%s", apellido, separador));
		texto.append(String.format("%s%s", ciudadProcedencia, separador));
		texto.append(String.format("%s%s", pais, separador));
		texto.append(String.format("%s%s", edad, separador));
		texto.append(String.format("%s%s", equipo, separador));
		texto.append(String.format("%s%s", deporteX, separador));

		return texto.toString();
	}

}
