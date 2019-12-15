import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ServidorTCP4 {	
	
	public static void main(String[] args) throws Exception {

		Scanner teclat = new Scanner(System.in);
		int numPort = 60000;
		ServerSocket servidor = new ServerSocket(numPort);
		int comptaClients = 0;
		int limit;
		Fil fil;
		Thread thread;

		//demanar l�mit
		System.out.println("Quants clients puc atendre? ");
		limit = teclat.nextInt();
		
		//servir� als clients mentre el nombre de clients no superi el l�mit entrat per par�metre
		while (comptaClients < limit) {			
			try {
				System.out.println("Esperant connexi�... ");
				Socket clientConnectat = servidor.accept();
				//comptador de clients connectats
				comptaClients++;
				fil = new Fil(servidor, clientConnectat);
				thread = new Thread(fil);			
				thread.start();	
				//comptaClients--;
			}catch(SocketException s){
				System.out.println("ERROR en la connexi�");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		servidor.close();
		teclat.close();
			
	}

}
