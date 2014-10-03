import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Main {

	private static String[] futbolistas = new String[10];
	private static File nombrefichero2;
	private static Scanner teclado;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		futbolistas[0] = "Ronaldo";
		futbolistas[1] = "Isco";
		futbolistas[2] = "Bale";
		futbolistas[3] = "Casillas";
		futbolistas[4] = "Sergio Ramos";
		futbolistas[5] = "Kroos";
		futbolistas[6] = "James";
		futbolistas[7] = "Modric";
		futbolistas[8] = "Navas";
		futbolistas[9] = "Carvajal";

		declaracion();

	}
	
	/**
	 * Metodo en el cual le decimos donde crearemos el Archivo
	 */

	private static void declaracion() {
		// Indicamos donde esta el archivo
		System.out.println("Introduzca la ruta.");
		teclado = new Scanner(System.in);
		String nombrefichero = teclado.next();
		nombrefichero2 = new File(nombrefichero);
		escribirFutbolistas();
	}
	
	/**
	 * Metodo que Escribe los Futbolistas en el Archivo
	 */

	private static void escribirFutbolistas() {
		Writer output = null;
		try {
			output = new BufferedWriter(new FileWriter(nombrefichero2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			for (int i = 0; i < futbolistas.length; i++) {
				output.write(futbolistas[i] + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
