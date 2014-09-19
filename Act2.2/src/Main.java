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
		//datosFicheros(sTexto);
		for(int i=0;i<6;i++){
			System.out.println(datosFicheros(sTexto).toString());
		}
			

	}

	public static String[] datosFicheros(String sTexto2) {
		crearFichero(sTexto2);
		String array[] = new String[6];
		array[0]=f.getName();
		array[1]=f.getAbsolutePath();
		if(f.canRead()){
			array[2]="True";
		}else array[2]="False";
		
		if(f.canWrite()){
			array[3]="True";
		}else array[3]="False";
		
		int tamano=(int) f.length();		
		array[4]=Integer.toString(tamano);
		
		array[5]=f.getParent();

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
