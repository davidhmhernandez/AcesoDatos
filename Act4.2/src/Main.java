import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main {

	private static Scanner sc;
	static FileWriter fw;
	static BufferedWriter bf;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		instanciarFichero();

	}
	
	/**
	 * Metodo que Instancia el Fichero
	 */
	
	private static void instanciarFichero() {
		String ruta = "fichero.txt";
		File f = new File(ruta);

		try {
			fw = new FileWriter(f);
			bf = new BufferedWriter(fw);
			System.out.println("Introduzca un Numero");
			sc = new Scanner(System.in);
			int m= sc.nextInt();
			calcularFibonacci(m);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Metodo que Calcula la serie Fibonacci y la escribe en el Fichero
	 * @param m
	 */

	public static void calcularFibonacci(int m){
		int acumulador = 1;
		int acumulador2 = 0;
		for (int i = 0; i < m; i++) {
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
