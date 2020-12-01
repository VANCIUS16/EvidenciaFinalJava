/*
 Autor: Marc Nadal
 Lenguaje: Java
 Actividad: Evidencia
 Fecha: 1.10.2020
 */
package clinica.clases;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class Main {

	private static final String DB_USR = "./src/test/resources/clincia/archivos/usr.txt";
	public static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream(DB_USR));
		Doctores doc = new Doctores();
		Paciente p = new Paciente();
		Cita c = new Cita();
		int x=0;
		int contDoc=0, contPer = 0, contCita = 0;
		String usr="", pw="";// usr = admin, pw = admin
		
		do {
			String USR = (String) prop.get("Admin_Usr");
			String PW =  (String) prop.get("Admin_pw");
			
			System.out.println("Ingrese su Usuario: \nUsr: ");
			usr = teclado.readLine();
			
			if(usr.equals(USR.toString())){
				System.out.println("Ingrese su contraseña: \nUsr: ");
				pw = teclado.readLine();
				
				if(pw.equals(PW.toString())){
					System.out.println("1. Menu Doctores\n2. Menu Pacientes\n3. Menu Citas\n4. Conciliar Citas");
					x = Integer.parseInt(teclado.readLine());
					try {
						if(x==1) {
							contDoc = contDoc +1;
							doc.Agregar(contDoc);
						}
						if(x==2) {
							contPer = contPer +1;
							p.Agregar(contPer);
						}
						if(x==3){
							contCita = contCita +1;
							c.Agendar(contCita);
						}
						if(x==4) {
							c.Juntar();
						}				
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
			}else {
				System.out.println("Credenciales Incorrectas");
			}
			System.out.print("Desea repetir el Programa? \n Si: 1 No: 2: ");
			x = Integer.parseInt(teclado.readLine());
		}while(x==1);
		System.out.println("Fin del programa");
	}
}