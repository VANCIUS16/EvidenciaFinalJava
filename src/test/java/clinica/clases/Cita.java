package clinica.clases;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.AsynchronousByteChannel;
import java.util.Properties;

public class Cita {
	private int cont, contDoc, contPer, contCita;
	
	public void Agendar(int cont2) throws FileNotFoundException, IOException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String DB_C = "./src/test/resources/clincia/archivos/cita.txt";
		Properties prop = new Properties();
		prop.load(new FileInputStream(DB_C));
		String Fecha, Hora, Motivo;
		int f=0;
		int cont =0;
		this.cont = cont2;
		
		System.out.println("Formato: dd-mm-yyyy");
		System.out.print("Ingrese Fecha: ");
		Fecha = teclado.readLine();
		
		System.out.println("Formato 24hrs: 15:00");
		System.out.print("Ingrese la Hora: ");
		Hora = teclado.readLine();
		
		System.out.println("Motivo de la cita: ");
		Motivo = teclado.readLine();
		cont =+1;
		
		String cadena = Integer.toString(cont);
		prop.setProperty((cont+"_Cita"), cadena);
		prop.setProperty((cont+"_Cita_Fecha"), Fecha.toString());
		prop.setProperty((cont+"_Cita_Hora"), Hora.toString() + " hrs");
		prop.setProperty((cont+"_Cita_Motivo"), Motivo.toString());
		
		prop.store(new FileOutputStream(DB_C), null);
		
		System.out.println(prop.get(cont+"_Cita_Fecha"));
		System.out.println(prop.get(cont+"_Cita_Hora"));
		System.out.println(prop.get(cont+"_Cita_Motivo"));
	}
	
	public void Juntar() throws FileNotFoundException, IOException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		
		String DB_DOC = "./src/test/resources/clincia/archivos/doctores.txt";
		String DB_P = "./src/test/resources/clincia/archivos/cliente.txt";
		String DB_C = "./src/test/resources/clincia/archivos/cita.txt";
		String DB_D = "./src/test/resources/clincia/archivos/datos.txt";

		Properties propD = new Properties();
		Properties propP = new Properties();
		Properties propC = new Properties();
		Properties propDatos = new Properties();
	
		propD.load(new FileInputStream(DB_DOC));
		propP.load(new FileInputStream(DB_P));
		propC.load(new FileInputStream(DB_C));
		
		System.out.println("Ingrese los IDs que desea asociar");
		
		System.out.print("ID de Doctores: ");
		contDoc = Integer.parseInt(teclado.readLine());
		
		System.out.print("ID de Pacientes: ");
		contPer = Integer.parseInt(teclado.readLine());
		
		System.out.print("ID de Cita: ");
		contCita = Integer.parseInt(teclado.readLine());	
		
		String nombreD = (String) propD.get(contDoc+"_Doctor__Nombre");
		String nombreP = (String) propP.get(contPer+"_Paciente_Nombre");
		String cita    = (String) propC.get(contCita+"_Cita");
		
		propD.setProperty((contDoc+"relacion"), nombreD + ", " + nombreP + ", "+ cita);
		
		propD.store(new FileOutputStream(DB_D), null);
		
		System.out.println("Relación guardada exitosamente");
	}
}