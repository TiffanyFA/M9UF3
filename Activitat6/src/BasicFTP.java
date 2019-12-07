import java.io.*;
import java.util.Scanner;

import org.apache.commons.net.ftp.*;

public class BasicFTP {
	
	public static void main (String[] args) {
		
		Scanner teclat = new Scanner (System.in);
		
		//Servidor FTP
		FTPClient client = new FTPClient();
		String ServerFTP; // = "ftp.urv.es" / publico.jccm.es
		System.out.println("En quin ServerFTP vols connectar?");
		ServerFTP = teclat.next();
		System.out.println("Ens connectem al servidor: "+ServerFTP);
		
		//Usuari FTP
		String usuari; //= "anonymous"
		String contrasenya; //= "guest" / "null"
		System.out.println("Introdueix usuari:");
		usuari = teclat.next();
		System.out.println("Introdueix contrasenya (null en cas de voler deixar en blanc):");
		contrasenya = teclat.next();
		if (contrasenya.equalsIgnoreCase("null")) {
			contrasenya = "";
		}
		
		try {
			
			client.connect(ServerFTP);
			boolean login = client.login(usuari, contrasenya);
			
			if (login)
				
				System.out.println("Login correcte... ");
				
			else {
				
				System.out.println("Login incorrecte... ");
				client.disconnect();
				System.exit(1);
				
			}
			
			System.out.println("Directori actual: "+client.printWorkingDirectory());
			FTPFile[] files = client.listFiles();
			System.out.println("Fitxers al directori actual: "+files.length);
			
			//Array par a visualitzar el tipus de fitxer
			String tipus[] = {"Fitxer", "Directori", "Enllaç simbolic"};
			
			for (int i=0; i<files.length; i++) {
				
				System.out.println("\t"+files[i].getName()+"=>"+tipus[files[i].getType()]);
				
			}
			
			boolean logout = client.logout();
				
			if (logout)
				
				System.out.println("Logout del servidor FTP... ");
			
			else
				
				System.out.println("Error en fer un logout... ");
			
			client.disconnect();
			System.out.println("Desconnectat... ");
			teclat.close();
			
		}catch (IOException ioe) {
			
			ioe.printStackTrace();
			
		}		
		
	}

}
