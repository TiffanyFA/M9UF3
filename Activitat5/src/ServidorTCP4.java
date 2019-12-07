import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ServidorTCP4 {
	public static void main(String[] args) throws Exception {

		Scanner teclat = new Scanner(System.in);
		int numPort = 60000;
		ServerSocket servidor = new ServerSocket(numPort);
		String cadena = "";
		int comptaClients = 0;
		int limit;

		//demanar l�mit
		System.out.println("Quants clients puc atendre? ");
		limit = teclat.nextInt();
		
		//servir� als clients mentre el nombre de clients no superi el l�mit entrat per par�metre
		while (comptaClients < limit) {
			try{
				System.out.println("Esperant connexi�... ");
				Socket clientConnectat = servidor.accept();
				//comptador de clients connectats
				comptaClients++;
				//mostra per pantalla el n�mero de client 
				System.out.println("Client " + comptaClients + " connectat... ");
	
				// FLUX DE SORTIDA AL CLIENT
				PrintWriter fsortida = new PrintWriter(
						clientConnectat.getOutputStream(), true);
	
				// FLUX D'ENTRADA DEL CLIENT
				BufferedReader fentrada = new BufferedReader(new InputStreamReader(
						clientConnectat.getInputStream()));
				
				//Envia missatge amb el n�mero de client
				fsortida.println("Connexi� amb client: " + comptaClients);
				while ((cadena = fentrada.readLine()) != null) {
	
					fsortida.println(cadena);
					System.out.println("Rebent: " + cadena);
					if (cadena.equals("*"))
						break;
	
				}			
	
				// TANCAR STREAMS I SOCKETS
				System.out.println("Tancant connexi�... ");
				fentrada.close();
				fsortida.close();		
				clientConnectat.close();
				//descomptaria clients desconnectats
				//comptaClients--;
			}catch(SocketException s){
				System.out.println("ERROR en la connexi�");
				//comptaClients--;
			}
		}
			servidor.close();
			teclat.close();
	}

}
