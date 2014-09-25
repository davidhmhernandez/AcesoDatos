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
	public void datosFichero2() {
		String[] datos = Main.datosFichero("supercalifragilistico");

		assertEquals(6, datos.length);
		assertEquals("supercalifragilistico", datos[0]);
		assertEquals("", datos[1]);
		assertEquals("False", datos[2]);
		assertEquals("False", datos[3]);
		assertEquals(0, datos[4]);
		assertEquals("", datos[5]);
	}

}
