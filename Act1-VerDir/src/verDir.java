import java.io.File;
import java.util.Scanner;


public class verDir {
	
	static File f;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		buscarDirectorio();
		listarDirectorio();

	}
	
	/**
	 * Este Método lista los archivos de un directorio 
	 * y los muestra por consola
	 */

	private static void listarDirectorio() {
		
        /** Si la carpeta no existe lanzamos una Excepción*/
        try {
            String[] archivos = f.list();
            for (int i = 0; i < archivos.length; i++) {
                System.out.println(archivos[i]);
            }
        }
        catch (Exception e){
            System.out.println("La Carpeta No Existe");
        }	
		
	}
	/** Este método sirve para decirle al programa que directorio 
	 * queremos que liste
	 */

	private static void buscarDirectorio() {
		System.out.println("Indique la Ruta.");
        Scanner reader = new Scanner(System.in);
        String sTexto = reader.next();
        f = new File(sTexto);
		
	}

}
