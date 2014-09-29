import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class ActJUni22 {

	@Test
	public void existeFichero() {
		String fichero = "prueba";
		File f = new File(fichero);
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(true, Main.existeFichero(fichero));
		assertEquals(false, Main.existeFichero("Davidddd"));
		f.delete();
	}

	@Test
	public void datosFichero() {
		String fichero2 = "prueba2";
		File f2 = new File(fichero2);

		try {
			f2.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] datos = Main.datosFichero(fichero2);
		assertEquals(6, datos.length);
		assertEquals(f2.getName(), datos[0]);
		assertEquals(f2.getAbsolutePath(), datos[1]);
		
		assertEquals("True", datos[2]);
		assertEquals("True", datos[3]);
		int tamano = (int) f2.length();
		String tamano2 = Integer.toString(tamano);
		assertEquals(tamano2, datos[4]);
		assertEquals(f2.getParent(), datos[5]);

		f2.delete();

	}
	@Test
	public void ruta(){
		String fichero = "prueba3";
		File f = new File(fichero);
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(f.getAbsolutePath(), Main.ruta(true, fichero));
		assertEquals(null, Main.ruta(true,"Davidddd"));
		f.delete();
	}
	
	@Test
	public void imprimirContenido(){
		String fichero = "prueba3";
		File f = new File(fichero);
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		assertArrayEquals(f.list(), Main.imprimirContenidoDirectorio(fichero));
		assertArrayEquals(null, Main.imprimirContenidoDirectorio("UUUU"));
		f.delete();
	}
	
	@Test
	public void imprimirContenidoExtension(){
		String fichero = "prueba3";
		String extension =".txt";
		File f = new File(fichero+extension);
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		assertEquals("prueba3.txt", Main.imprimirContenidoDirectorioExtension(fichero,extension));
		assertEquals("", Main.imprimirContenidoDirectorioExtension("UUUU",".txt"));
		f.delete();
	}
	@Test
	public void crearDirectorio(){
		String fichero = "prueba4";
		
		File f = new File(fichero);
		f.mkdir();
		
		assertEquals("prueba4", Main.creaDirectorio(fichero));
		assertEquals("", Main.creaDirectorio("UUUU"));
		f.delete();
	}
	@Test
	public void crearArchivoVacio(){
		String fichero = "prueba5";
		
		File f = new File(fichero);
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals("prueba5", Main.touch(fichero));
		assertEquals("", Main.touch("UUUU"));
		f.delete();
	}

}
