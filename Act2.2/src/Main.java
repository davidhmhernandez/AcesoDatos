import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static File f;
	static String sTexto;
	static String extension;
	static String nombre;
	static String nombreNue;
	static String nombreArchivo;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		introducirRuta();

		System.out.println("¿Existe el Fichero?");
		existeFichero(sTexto);

		System.out.println("");
		System.out.println("Datos");
		datosFicheros(sTexto);

		System.out.println("");
		System.out.println("Ruta");
		System.out.println(ruta(absoluta(sTexto)));

		System.out.println("");
		System.out.println("Archivos");
		System.out.println(imprimirContenidoDirectorio(sTexto));

		System.out.println("");
		System.out.println("Introduzca Extension");
		Scanner ext = new Scanner(System.in);
		extension = ext.next();
		System.out.println("Archivos con Extension" + " " + extension);
		System.out.println(imprimirContenidoDirectorioExtension(sTexto,
				extension));

		System.out.println("");
		System.out.println("Crear Directorio");
		System.out.println("Introduzca Nombre de la Nueva Carpeta");
		Scanner nom = new Scanner(System.in);
		nombre = nom.next();
		if(creaDirectorio(sTexto, nombre)){
			System.out.println("Creado Correctamente");
		}else System.out.println(" NO Creado");
		
		
		System.out.println("");
		System.out.println("Renombrar Directorio");
		System.out.println("Introduzca Nuevo Nombre");
		Scanner nomNue = new Scanner(System.in);
		nombreNue = nomNue.next();
		if(renombrarFichero(sTexto, nombreNue)){
			System.out.println("Renombrado Correctamente");
		}else System.out.println(" NO Renombrado");
		
		System.out.println("");
		System.out.println("Crear Archivo Vacio");
		System.out.println("Introduzca Nuevo Nombre");
		Scanner nomA = new Scanner(System.in);
		nombreArchivo = nomA.next();
		if(touch(sTexto, nombreNue)){
			System.out.println("Creado Correctamente");
		}else System.out.println(" NO Creado");

	}

	private static boolean touch(String sTexto9, String nombreArchivo) {
		crearFichero(sTexto9);
		if(f.exists()){
			File f2 = new File(sTexto9,nombreArchivo);
			
			return true;
		}
		return false;
	}

	private static boolean renombrarFichero(String sTexto8, String nombreNue2) {
		crearFichero(sTexto8);
		if(f.exists()){
			File f2 = new File(sTexto8,nombreNue2);
			f.renameTo(f2);
			return true;
		}
		return false;
	}

	private static boolean creaDirectorio(String sTexto6, String sTexto7) {
		crearFichero(sTexto6);
		if (f.exists()) {
			File directorio = new File(sTexto6,sTexto7);
			directorio.mkdir();
			return true;
		} else {
			return false;
		}
	}

	private static ArrayList<String> imprimirContenidoDirectorioExtension(
			String sTexto5, String extension2) {
		crearFichero(sTexto5);
		ArrayList<String> lista = new ArrayList<>();
		if (f.exists()) {
			String[] ficheros = f.list();
			for (int i = 0; i < ficheros.length; i++) {
				String fichero = ficheros[i];
				if (fichero.indexOf(extension2) != -1) {
					lista.add(fichero);
				}
			}

		}
		return lista;

	}

	private static String imprimirContenidoDirectorio(String sTexto4) {
		crearFichero(sTexto4);
		String s = null;
		String[] archivos = f.list();

		for (int j = 0; j < archivos.length; j++) {
			s += archivos[j];
			s += "\n";
		}

		return s;
	}

	private static String ruta(boolean absoluta) {
		if (absoluta) {
			return f.getAbsolutePath();
		} else
			return f.getPath();

	}

	private static boolean absoluta(String sTexto3) {
		crearFichero(sTexto3);
		if (!f.getAbsolutePath().equalsIgnoreCase(" ")) {
			return true;
		} else
			return false;

	}

	public static String[] datosFicheros(String sTexto2) {
		crearFichero(sTexto2);
		String array[] = new String[6];
		array[0] = f.getName();
		array[1] = f.getAbsolutePath();
		if (f.canRead()) {
			array[2] = "True";
		} else
			array[2] = "False";

		if (f.canWrite()) {
			array[3] = "True";
		} else
			array[3] = "False";

		int tamano = (int) f.length();
		array[4] = Integer.toString(tamano);

		array[5] = f.getParent();

		for (int i = 0; i < 6; i++) {
			System.out.println(array[i]);

		}

		return array;

	}

	public static boolean existeFichero(String fichero) {
		crearFichero(fichero);
		if (f.exists()) {
			System.out.println("Existe");
			return true;
		} else
			System.out.println("NO existe");
		return false;
	}

	public static void crearFichero(String fichero) {
		f = new File(fichero);
	}

	public static String introducirRuta() {
		System.out.println("Indique la Ruta.");
		Scanner reader = new Scanner(System.in);
		sTexto = reader.next();
		return sTexto;
	}

}
