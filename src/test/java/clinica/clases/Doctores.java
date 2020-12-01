package clinica.clases;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.util.Properties;

public class Doctores {
	private static final String DB_DOC = "./src/test/resources/clincia/archivos/doctores.txt";
	private int cont;
	
	//Método que agrega a los doctores nuevos a la BD
	public void Agregar(int cont2) throws FileNotFoundException, IOException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		Properties prop = new Properties();
		prop.load(new FileInputStream(DB_DOC));
		String Nombre, ApellidoP, Especialidad;
		int f=0;
		int cont =0;
		this.cont = cont2;
		
		System.out.print("Ingrese el Nombre: ");
		Nombre = teclado.readLine();
		
		System.out.print("Ingrese el Apellido Paterno: ");
		ApellidoP = teclado.readLine();
		
		System.out.print("Ingrese la Especialidad: ");
		Especialidad = teclado.readLine();
		
		cont =+1;
		prop.setProperty((cont+"_Doctor__Nombre"), Nombre.toString());
		prop.setProperty((cont+"_Doctor__ApellidoP"), ApellidoP.toString());
		prop.setProperty((cont+"_Doctor__Especialidad"), Especialidad.toString());
		
		prop.store(new FileOutputStream(DB_DOC), null);
		
		System.out.println(prop.get(cont+"_Doctor__Nombre"));
		System.out.println(prop.get(cont+"_Doctor__ApellidoP"));
		System.out.println(prop.get(cont+"_Doctor__Especialidad"));
	}
}