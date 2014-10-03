import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class main {
	private static String[] futbolistas = new String[10];
	private static File nombrefichero2;
	private static Scanner teclado;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
	 * Metodo donde Declaramos el Archivo con extension .csv
	 */

	private static void declaracion() {
		// Indicamos donde esta el archivo
		System.out.println("Introduzca Nombre del Archivo");
		teclado = new Scanner(System.in);
		String nombrefichero = teclado.next();
		nombrefichero2 = new File(nombrefichero+".csv");
		escribirFutbolistas();
	}
	
	/**
	 * Metodo que escribe el nombre de los Futbolistas separados por coma y punto
	 */

	private static void escribirFutbolistas() {
		FileWriter fw=null;
		try {
			fw = new FileWriter(nombrefichero2);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedWriter bf = new BufferedWriter(fw);
		
		try {
			for (int i = 0; i < futbolistas.length; i++) {
				bf.write(futbolistas[i]+"."+",");
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
