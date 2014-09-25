import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	private static Scanner rutaF;

	public static void main(String[] args) {
		
		// * Declaramos el Archivo
		try {
			System.out.println("Introduzca Ruta del Fichero");
			rutaF = new Scanner(System.in);
			String path = rutaF.next();
			System.out.println(readTextFile(path));
			
		} catch (FileNotFoundException e) {
			System.out.println("");
		}
		;
	}


	private static String readTextFile(String path)
			throws FileNotFoundException {
		FileReader fichero = null;
		String s = null;

		try {
			System.out.println("Leyendo " + path);
			fichero = new FileReader(path); // Creamos el Flujo de Entrada
			int i;

			while ((i = fichero.read()) != -1) { // Se lee Todo 1 a 1
				s += (char) i;
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("El Fichero No Existe.");
		} catch (IOException ioe) {
			System.out
					.println("El Archivo está protegido contra sobreescritura.");
		}
		try {
			fichero.close();
		} catch (IOException e) {
		}
		return s;
	}
}
