import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

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
		String ruta = "fichero.txt";
		File f = new File(ruta);

		try {
			FileWriter fw = new FileWriter(f);
			BufferedWriter bf = new BufferedWriter(fw);
			calcularFibonacci(bf);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que calcula la serie Fibonacci
	 * 
	 * @param bf
	 * @throws IOException
	 */

	private static void calcularFibonacci(BufferedWriter bf) throws IOException {
		int acumulador = 1;
		int acumulador2 = 0;
		for (int i = 0; i < 5; i++) {
			int total = acumulador + acumulador2;
			acumulador2 = acumulador;
			acumulador = total;
			String acu = Integer.toString(acumulador2);
			escribirFichero(bf, acu);

		}
		bf.close();
	}

	/**
	 * Metodo que escribe en el fichero
	 * @param bf
	 * @param acu
	 * @throws IOException
	 */
	
	private static void escribirFichero(BufferedWriter bf, String acu)
			throws IOException {
		bf.write(acu);
		bf.newLine();
	}

}
