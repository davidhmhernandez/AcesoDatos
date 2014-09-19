import java.io.File;
import java.util.Scanner;

public class Main {
	static File f;
	static String sTexto;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		introducirRuta();
		existeFichero(sTexto);
		datosFicheros(sTexto);
			

	}

	private static String[] datosFicheros(String sTexto2) {
		String array[] = new String[6];
		
		return null;
		
		
	}

	private static boolean existeFichero(String fichero) {
		f = new File(fichero);
		if (f.exists()) {
			System.out.println("Existe");
			return true;
		} else
			System.out.println("NO existe");
			return false;
	}

	private static String introducirRuta() {
		System.out.println("Indique la Ruta.");
		Scanner reader = new Scanner(System.in);
		sTexto = reader.next();
		return sTexto;
	}

}
