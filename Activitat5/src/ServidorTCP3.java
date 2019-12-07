import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ServidorTCP3 {
	public static void main(String[] args) throws Exception {

		int numPort = 60000;
		ServerSocket servidor = new ServerSocket(numPort);
		String cadena = "";
		int comptaClients = 0;

		while (comptaClients < 3) {
			try {
				System.out.println("Esperant connexió... ");
				Socket clientConnectat = servidor.accept();
				// comptador de clients connectats
				comptaClients++;
				// mostra per pantalla el número de client
				System.out
						.println("Client " + comptaClients + " connectat... ");

				// FLUX DE SORTIDA AL CLIENT
				PrintWriter fsortida = new PrintWriter(
						clientConnectat.getOutputStream(), true);

				// FLUX D'ENTRADA DEL CLIENT
				BufferedReader fentrada = new BufferedReader(
						new InputStreamReader(clientConnectat.getInputStream()));

				// Envia missatge amb el número de client
				fsortida.println("Connexió amb client: " + comptaClients);
				while ((cadena = fentrada.readLine()) != null) {

					fsortida.println(cadena);
					System.out.println("Rebent: " + cadena);
					if (cadena.equals("*"))
						break;

				}

				// TANCAR STREAMS I SOCKETS
				System.out.println("Tancant connexió... ");
				fentrada.close();
				fsortida.close();
				clientConnectat.close();				
			} catch (SocketException s) {
				System.out.println("ERROR en la connexió");				
			}
		}
		servidor.close();
	}

}
