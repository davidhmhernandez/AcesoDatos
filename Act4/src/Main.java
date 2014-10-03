import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	static String ruta = "fichero.txt";
	static File f = new File(ruta);
	static FileWriter fw;
	static BufferedWriter bf;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		instaciarFichero();

	}
	
	/**
	 * metodo que crea un nuevo fichero y escribe en el
	 */

	private static void instaciarFichero() {
		

		try {
		 fw = new FileWriter(f);
		bf = new BufferedWriter(fw);
			calcularFibonacci();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que calcula la serie Fibonacci
	 * 
	 */

	private static void calcularFibonacci()  {
		int acumulador = 1;
		int acumulador2 = 0;
		for (int i = 0; i < 5; i++) {
			int total = acumulador + acumulador2;
			acumulador2 = acumulador;
			acumulador = total;
			String acu = Integer.toString(acumulador2);
			try {
				bf.write(acu);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bf.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		try {
			bf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
