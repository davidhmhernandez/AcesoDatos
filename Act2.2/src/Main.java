import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static Scanner rutaF;
	static String op = null;;
	static boolean absoluta = false;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("Introduzca Ruta del Fichero");
		rutaF = new Scanner(System.in);
		String fichero = rutaF.next();

		if (existeFichero(fichero)) {
			System.out.println("El Fichero Existe");
		} else
			System.out.println("No existe el Fichero");

		System.out.println("Introduzca Ruta del Fichero");
		rutaF = new Scanner(System.in);
		String ficheroDatos = rutaF.next();
		datosFichero(ficheroDatos);

		System.out.println("");
		System.out.println("Ruta");
		System.out.println("Introduzca Ruta del Fichero");
		rutaF = new Scanner(System.in);
		String rutaA = rutaF.next();
		System.out.println("¿Que Ruta Desea Obtener? R-Relavita A-Absoluta");
		Scanner opcion = new Scanner(System.in);
		op = opcion.next();
		if (op.equalsIgnoreCase("R")) {
			absoluta = false;
			System.out.println(ruta(absoluta, rutaA));
		} else {
			absoluta = true;
			System.out.println(ruta(absoluta, rutaA));

		}

		System.out.println("");
		System.out.println("Contenido del Directorio");
		System.out.println("Introduzca Ruta del Directorio");
		rutaF = new Scanner(System.in);
		String rutaD = rutaF.next();
		System.out.println(imprimirContenidoDirectorio(rutaD));

		System.out.println("");
		System.out.println("Contenido del Directorio Por Extension");
		System.out.println("Introduzca Ruta del Directorio");
		rutaF = new Scanner(System.in);
		String rutaDir = rutaF.next();
		System.out.println("Introduzca Extension");
		rutaF = new Scanner(System.in);
		String rutaEx = rutaF.next();
		System.out
				.println(imprimirContenidoDirectorioExtension(rutaDir, rutaEx));

		System.out.println("");
		System.out.println("Crear Nueva Carpeta");
		System.out.println("Introduzca Ruta");
		rutaF = new Scanner(System.in);
		String rutaCN = rutaF.next();
		if (creaDirectorio(rutaCN)) {
			System.out.println("Creada Correctamente");
		} else
			System.out.println("NO CREADA");

		System.out.println("");
		System.out.println("Renombrar Fichero");
		System.out.println("Introduzca Ruta donde esta el Fichero");
		rutaF = new Scanner(System.in);
		String rutaFich = rutaF.next();
		if (renombraFichero(rutaFich)) {
			System.out.println("Renombrado Correctamente");
		} else
			System.out.println("NO Renombrado");

		System.out.println("");
		System.out.println("Crear Archivo Vacio");
		System.out.println("Introduzca Ruta donde crear el Archivo");
		rutaF = new Scanner(System.in);
		String rutaAr = rutaF.next();
		if (touch(rutaAr)) {
			System.out.println("Archivo Creado Correctamente");
		} else
			System.out.println("Archivo NO Creado");

		System.out.println("");
		System.out.println("Leer Texto");
		System.out.println(leerLinea());

		System.out.println("");
		System.out.println("Leer Archivo Buffer");
		System.out.println(leerLineaBufer());

	}

	private static String leerLineaBufer() throws IOException {
		String s = null;
		System.out.println("Introduzca el Archivo");
		rutaF = new Scanner(System.in);
		String rutaAr = rutaF.next();
		try {
			FileInputStream fis = new FileInputStream(rutaAr);
			DataInputStream dis = new DataInputStream(fis);
			BufferedReader buffer = new BufferedReader(new InputStreamReader(
					dis));
			String linea;

			while ((linea = buffer.readLine()) != null) {
				// Imprimimos la línea por pantalla
				s += linea;
				s += "\n";
			}
			dis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: " + e.getMessage());
		}
		return s;
	}

	private static String leerLinea() {
		System.out.println("Introduzca Texto");
		rutaF = new Scanner(System.in);
		String texto = rutaF.next();
		return texto;

	}

	public static boolean touch(String rutaAr) {
		File f = new File(rutaAr);
		if (f.exists()) {
			System.out.println("Introduzca Nombre del Archivo");
			rutaF = new Scanner(System.in);
			String nomAr = rutaF.next();
			File ficheroNue = new File(rutaAr, nomAr);
			try {
				ficheroNue.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else
			return false;
		return true;
	}

	public static boolean renombraFichero(String rutaFich) {
		File f = new File(rutaFich);
		if (f.exists()) {
			System.out.print("Nombre de archivo nuevo: ");
			String nombreNue = rutaF.next();
			File fNue = new File(rutaFich, nombreNue);
			f.renameTo(fNue);
		} else {
			System.out.println("El Fichero No Existe");
			return false;
		}

		return true;

	}

	public static boolean creaDirectorio(String rutaCN) {
		File fichero = new File(rutaCN);
		if (fichero.exists()) {
			System.out.println("Introduzca Nombre del Directorio Nuevo");
			rutaF = new Scanner(System.in);
			String rutaNC = rutaF.next();
			File directorio = new File(rutaCN, rutaNC);
			directorio.mkdir();
			return true;
		} else {
			return false;
		}
	}

	public static ArrayList<String> imprimirContenidoDirectorioExtension(
			String rutaDir, String rutaEx) {
		File fichero = new File(rutaDir);
		ArrayList<String> lista = new ArrayList<>();
		if (fichero.exists()) {
			String[] ficheros = fichero.list();
			for (int i = 0; i < ficheros.length; i++) {
				String fichero2 = ficheros[i];
				if (fichero2.indexOf(rutaEx) != -1) {
					lista.add(fichero2);
				}
			}
			return lista;

		}else return null;
		

	}

	public static String[] imprimirContenidoDirectorio(String rutaD) {
		File directorio = new File(rutaD);

		String[] archivos = directorio.list();
		if (directorio.exists()) {

			return archivos;

		} else
			return null;

	}

	public static String ruta(boolean absoluta, String ruta) {
		File fichero = new File(ruta);
		if (!fichero.exists()) {
			System.out.println("");
		} else {
			if (absoluta) {
				return fichero.getAbsolutePath();
			}

		}
		return null;
	}

	static String[] datosFichero(String ficheroDatos) {
		File fichero = new File(ficheroDatos);
		String array[] = new String[6];
		array[0] = fichero.getName();
		array[1] = fichero.getAbsolutePath();
		if (fichero.canRead()) {
			array[2] = "True";
		} else
			array[2] = "False";

		if (fichero.canWrite()) {
			array[3] = "True";
		} else
			array[3] = "False";

		int tamano = (int) fichero.length();
		array[4] = Integer.toString(tamano);

		array[5] = fichero.getParent();

		for (int i = 0; i < 6; i++) {
			System.out.println(array[i]);

		}

		return array;

	}

	static boolean existeFichero(String fichero) {
		File fich = new File(fichero);
		if (fich.exists()) {
			return true;
		}
		return false;
	}

}
