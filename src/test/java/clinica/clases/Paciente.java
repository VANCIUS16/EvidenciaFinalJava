package clinica.clases;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class Paciente {
	private static final String DB_P = "./src/test/resources/clincia/archivos/cliente.txt";
	private int cont;
	
	public void Agregar(int cont2) throws FileNotFoundException, IOException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		Properties prop = new Properties();
		prop.load(new FileInputStream(DB_P));
		String Nombre, ApellidoP;
		int f=0;
		int cont =0;
		this.cont = cont2;
		
		System.out.print("Ingrese el Nombre: ");
		Nombre = teclado.readLine();
		
		System.out.print("Ingrese el Apellido Paterno: ");
		ApellidoP = teclado.readLine();
		
		cont =+1;
		prop.setProperty((cont+"_Paciente_Nombre"), Nombre.toString());
		prop.setProperty((cont+"_Paciente_ApellidoP"), ApellidoP.toString());
		
		prop.store(new FileOutputStream(DB_P), null);
		
		System.out.println(prop.get(cont+"_Paciente_Nombre"));
		System.out.println(prop.get(cont+"_Paciente_ApellidoP"));
	}
}