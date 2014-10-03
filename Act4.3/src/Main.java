import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {
	private static Scanner sc;

	static BufferedWriter bf;
	static String ruta = "Fichero1.txt";
	static File f = new File(ruta);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (f.exists()) {
			try {
				calcularFibonacci(f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			instanciarFichero();
		}

	}
	
	/**
	 * Metodo que Instancia el Fichero
	 */

	private static void instanciarFichero() {
		try {
			FileWriter fw = new FileWriter(f);
			bf = new BufferedWriter(fw);
			
			calcularFibonacci(f);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * Metodo que hace la serie Fibonachi y la escribe en el fichero
	 * @param f
	 * @throws IOException
	 */

	public static void calcularFibonacci(File f) throws IOException {
		System.out.println("Introduzca un Numero");
		sc = new Scanner(System.in);
		int m = sc.nextInt();
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(f, true), "UTF8"));

		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int acumulador = 1;
		int acumulador2 = 0;
		for (int i = 0; i < m; i++) {
			int total = acumulador + acumulador2;
			acumulador2 = acumulador;
			acumulador = total;
			String acu = Integer.toString(acumulador2);
			out.write(acu);
			
		}
		out.newLine();
		out.close();
	}

}
