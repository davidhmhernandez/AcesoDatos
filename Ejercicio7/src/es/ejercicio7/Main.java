package es.ejercicio7;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	/**
	 * @author David Hern�ndez
	 * @param args
	 */

	// Inserci�n de los datos del empleado
	static void CrearElemento(String datoLibro, String valor, Element raiz,
			Document document) {
		// Para crear el nodo hijo (<id>, <nombre>, <dep> y <salario>),se
		// escribe
		Element elem = document.createElement(datoLibro);

		// Para a�adir su valor se usa el m�todo createTextNode(String)
		Text text = document.createTextNode(valor);

		// A continuaci�n se a�ade el nodo hijo a la ra�z(empleado) y su
		// texto o valor al nodo hijo

		raiz.appendChild(elem); // pegamos el elemento hijo a la ra�z
		elem.appendChild(text); // pegamos el valor

	}

	public static void main(String[] args) {
		File fichero = new File("./resources/librosl.csv");
		// declara el fichero de acceso aleatorio
		try {
			BufferedReader streamIn = new BufferedReader(
					new FileReader(fichero));
			// Variables para leer los Datos
			int id, autor, editorial, anio, stock;

			String titulo;
			String linea = null;

			// crearemos una instancia de DocumentBuilderFactory para construir
			// el
			// parser
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			try {
				// Necesita encerrarse entre try-catch porque puede producirse
				// una
				// excepci�n ParserConfigurationException
				DocumentBuilder builder = factory.newDocumentBuilder();
				DOMImplementation implementation = builder
						.getDOMImplementation();

				// Creamos un documento vac�o de nombre document con el nodo
				// ra�z
				// de nombre Empleados
				Document document = implementation.createDocument(null,
						"Empleados", null);

				// asignamos la versi�n de nuestro XML
				document.setXmlVersion("1.0");
				while ((linea = streamIn.readLine()) != null) {
					try {

						StringTokenizer st = new StringTokenizer(linea, ";");
						id = Integer.parseInt(st.nextToken());
						titulo = st.nextToken();
						autor = Integer.parseInt(st.nextToken());
						editorial = Integer.parseInt(st.nextToken());
						anio = Integer.parseInt(st.nextToken());
						stock = Integer.parseInt(st.nextToken());
						if (id > 0) {
							// Creamos el nodo <empleado> al documento
							Element raiz = document.createElement("empleado");
							// lo "pegamos" a la ra�z del documento
							document.getDocumentElement().appendChild(raiz);

							// Despu�s a�adiremos los hijos de ese nodo
							// (ra�z), mediante
							// la funci�n CrearElemento()
							CrearElemento("ID", Integer.toString(id), raiz,
									document);// A�adir ID
							CrearElemento("Titulo", titulo.trim(), raiz,
									document);// A�adir
												// Tirulo
							CrearElemento("Autor", Integer.toString(autor),
									raiz, document);// A�adir Autor
							CrearElemento("Editorial",
									Integer.toString(editorial), raiz, document); // A�adir
																					// Editorial
							CrearElemento("A�o", Integer.toString(anio), raiz,
									document);// A�adir A�o
							CrearElemento("Stock", Integer.toString(stock),
									raiz, document); // A�adir Stock

						}
					} catch (NumberFormatException nfe) {
						// TODO Auto-generated catch block
						System.out.println(nfe.getMessage());
					}
				}
				// Creamos la fuente XML a partir del documento
				Source source = new DOMSource(document);

				// Creamos el resultado en el fichero Empleados.xml
				Result result = new StreamResult(new java.io.File(
						"./resources/libros.xml"));

				// Obtenemos un TransformerFactory
				Transformer transformer = TransformerFactory.newInstance()
						.newTransformer();

				// Le damos formato y realizamos la transformaci�n del
				// documento a
				// fichero
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.setOutputProperty(OutputKeys.METHOD, "xml");
				transformer.setOutputProperty(
						"{http://xml.apache.org/xslt}indent-amount", "4");
				transformer.transform(source, result);

				// Mostramos el documento por pantalla especificando
				// el canal de salida el System.out
				Result console = new StreamResult(System.out);
				transformer.transform(source, console);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerFactoryConfigurationError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} finally {
				if (streamIn != null)
					streamIn.close(); // cerramos el fichero
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}
