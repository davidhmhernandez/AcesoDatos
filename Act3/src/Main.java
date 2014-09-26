import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	private static Scanner rutaF;

	public static void main(String[] args) {

		try {
			System.out.println("Introduzca Ruta del Fichero");
			rutaF = new Scanner(System.in);
			String path = rutaF.next();
			System.out.println(readTextFile(path));
			System.out.println("Introduzca Nº de Caracteres");
			rutaF = new Scanner(System.in);
			int numero = rutaF.nextInt();
			readTextFile(path, numero);
		} catch (FileNotFoundException e) {
			System.out.println("");
		}
		;
	}

	private static void readTextFile(String path, int numero) {
		try {
			FileReader fichero = new FileReader(path);

			int i;
			int contador = -1;
			while ((i = fichero.read()) != -1) { 
				System.out.print((char) i);
				contador++;
				if (contador % numero == 0) {
					rutaF.nextLine();
				}
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("El Fichero No Existe.");
		} catch (IOException ioe) {
			System.out
					.println("El Archivo está protegido contra sobreescritura.");
		}
	}

	private static String readTextFile(String path)
			throws FileNotFoundException {
		FileReader fichero = null;
		String s = null;

		try {
			System.out.println("Leyendo " + path);
			fichero = new FileReader(path);
			int i;

			while ((i = fichero.read()) != -1) {
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
