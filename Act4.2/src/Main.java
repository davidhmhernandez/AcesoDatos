import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main {

	private static Scanner sc;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		instanciarFichero();

	}
	
	private static void instanciarFichero() {
		String ruta = "fichero.txt";
		File f = new File(ruta);

		try {
			FileWriter fw = new FileWriter(f);
			BufferedWriter bf = new BufferedWriter(fw);
			System.out.println("Introduzca un Numero");
			sc = new Scanner(System.in);
			int m= sc.nextInt();
			calcularFibonacci(m,bf);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void calcularFibonacci(int m, BufferedWriter bf) throws IOException{
		int acumulador = 1;
		int acumulador2 = 0;
		for (int i = 0; i < m; i++) {
			int total = acumulador + acumulador2;
			acumulador2 = acumulador;
			acumulador = total;
			String acu = Integer.toString(acumulador2);
			bf.write(acu);
			bf.newLine();

		}
		bf.close();
	}



}
