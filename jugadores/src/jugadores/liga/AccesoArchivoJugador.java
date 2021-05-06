package jugadores.liga;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AccesoArchivoJugador {
/**
 * Escribe en el archivo indicado.
 * @param rutaArchivo Ruta donde se encuentra el archivo
 * @param texto Texto que se escribe en el archivo
 */
	public static void escribir(String rutaArchivo, ArrayList<String> texto) {
		File refArchivo = new File(rutaArchivo);
		try {
			FileWriter fs = new FileWriter(refArchivo);
			PrintWriter out = new PrintWriter(fs);
			for (int i = 0; i < texto.size(); i++) {
				out.println(texto.get(i));
			}
				out.close();
		} catch (FileNotFoundException e) {
			System.err.printf("Ruta no encontrada: %s", e.getLocalizedMessage());
		} catch (IOException e) {
			System.err.printf("Error de escritura: %s", e.getLocalizedMessage());
		}

	}
/**
 * Lee el archivo txt y lo guarda en una matriz de cadenas de texto.
 * @return copiarTexto
 */
	public static ArrayList<String> leer() {
		
		ArrayList<String> copiarTexto = new ArrayList<String>();
		File refArchivo = new File("jugadores.txt");
		File refArchivo1 = new File("jugadores.csv");
		String textoFila="";
		try {
			FileReader fr = new FileReader(refArchivo);
			FileReader fr1 = new FileReader(refArchivo1);
			BufferedReader in = new BufferedReader(fr);
			BufferedReader in1 = new BufferedReader(fr1);
			while(textoFila != null) {
				textoFila=in.readLine();
				if(textoFila != null) {
					copiarTexto.add(textoFila);
				}
			}
			in.close();
			in1.close();
		} catch (FileNotFoundException e) {
			System.err.printf("Ruta no encontrada: %s", e.getLocalizedMessage());
		} catch (IOException e) {
			System.err.printf("Error de lectura: %s", e.getLocalizedMessage());
		}
		return copiarTexto;
	}
	
}
