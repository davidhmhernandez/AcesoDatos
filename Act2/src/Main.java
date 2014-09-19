import java.io.File;

public class Main {
	public static File d = new File("NuevoDir");
	public static File f1 = new File(d, "Fichero1.txt");
	public static File f2 = new File(d, "Fichero2.txt");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		d.mkdir();// * Creamos el Directorio */
		crearFichero();
		renombrarFichero();
		crearFichero3();
		borrarFichero();
	}
	
	/**
	 * Método que crea el fichero Nº3
	 */

	private static void crearFichero3() {
		File f3 = new File(d, "Fichero3.txt"); // *Creamos el Fichero 3 */
		try {
			if (f3.createNewFile()) {
				System.out.println("El Archivo 3 se ha creado Correctamente.");
			} else {
				System.out.println("No se ha creado el Archivo 3.");
			}
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
	
	/**
	 * Método que crea los ficheros Nº1 y Nº2
	 */

	private static void crearFichero() {
		try {
			if (f1.createNewFile()) { // *Creamos el Fichero 1 */
				System.out.println("El Archivo 1 se ha creado Correctamente.");
			} else {
				System.out.println("No se ha creado el Archivo 1.");
			}
			if (f2.createNewFile()) {
				System.out.println("El Archivo 2 se ha creado Correctamente.");
			} else {
				System.out.println("No se ha creado el Archivo 2.");
			}
		} catch (Exception e) {
			System.out.println("Error.");
		}
	}
	
	/**
	 * Método que renombra el Fichero
	 */

	private static void renombrarFichero() {
		if (f1.renameTo(new File(d, "Fichero1Nuevo.txt"))) { // *Renombramos el
																// Fichero 1*/
			System.out.println("Se ha renombrado el Archivo 1 Correctamente.");
		} else {
			System.out.println("Error.No se pudo renombrar el archivo 1.");
		}
	}
	
	/**
	 * Método que borra el fichero Nº 2
	 */

	private static void borrarFichero() {
		if (f2.delete()) { // * Borramos el Fichero 2 */
			System.out.println("Se ha Borrado el Archivo 2 Correctamente.");
		} else {
			System.out.println("Error.No se pudo borrar el archivo 2.");
		}
	}

}
