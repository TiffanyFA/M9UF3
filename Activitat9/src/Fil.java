import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Fil implements Runnable {
	ServerSocket servidor;
	String cadena = "";
	Socket clientConnectat;
	static int comptaClients = 0;

	public Fil(ServerSocket servidor, Socket clientConnectat) {
		this.servidor = servidor;
		this.clientConnectat = clientConnectat;
	}

	@Override
	public void run() {
		
		try {
			comptaClients++;
			//mostra per pantalla el número de client 
			System.out.println("Client " + comptaClients + " connectat... ");
	
			// FLUX DE SORTIDA AL CLIENT
			PrintWriter fsortida = new PrintWriter(
					clientConnectat.getOutputStream(), true);
	
			// FLUX D'ENTRADA DEL CLIENT
			BufferedReader fentrada = new BufferedReader(new InputStreamReader(
					clientConnectat.getInputStream()));
			
			//Envia missatge amb el número de client
			fsortida.println("Connexió amb client: " + comptaClients);
			while (((cadena = fentrada.readLine()) != null) && (!(cadena.equals("*")))) {	
				fsortida.println(cadena);
				System.out.println("Rebent: " + cadena);					
			}			
	
			// TANCAR STREAMS I SOCKETS
			System.out.println("Tancant connexió... ");
			fentrada.close();
			fsortida.close();		
			clientConnectat.close();
		}catch(SocketException s){
			System.out.println("ERROR en la connexió");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
