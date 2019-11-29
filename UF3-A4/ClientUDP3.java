import java.net.*;
import java.io.*;

public class ClientUDP3 {
	
	public static void main (String[] args) throws Exception {
		
		//FLUX PER A ENTRADA EST�NDARD
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//Socket client
		DatagramSocket clientSocket = new DatagramSocket();
		byte[] enviats = new byte[1024];
		byte[] rebuts = new byte[1024];
		
		//DADES DEL SERVIDOR al qual s'envia el missatge
		InetAddress IPServidor = InetAddress.getLocalHost();
		int port = 9800;
		
		//Bucle per anar introdu�nt missatges fins que la resposta tardi m�s de 5 segons
		while(clientSocket.getSoTimeout() <= 5000) {
			//INTRODUIR DADES PEL TECLAT
			System.out.print("Introdueix missatge: ");
			String cadena = in.readLine();
			enviats = cadena.getBytes();
			
			//ENVIANT DATAGRAMA AL SERVIDOR
			System.out.println("Enviant "+enviats.length+"bytes al servidor.");
			DatagramPacket enviament = new DatagramPacket(enviats, enviats.length, IPServidor, port);
			clientSocket.send(enviament);
			
			//REBENT DATAGRAMA DEL SERVIDOR
			DatagramPacket rebut = new DatagramPacket(rebuts, rebuts.length);
			System.out.println("Esperant datagrama...");
			//espera de les dades, m�xim 5 segons
			clientSocket.setSoTimeout(5000);
			try {
				clientSocket.receive(rebut);
			}catch (Exception e) {
				System.out.println("ERROR: Ha tardat m�s de 5 segons en respondre");
			}
			String majuscula = new String(rebut.getData());
			
			//ACONSEGUINT INFORMACI� DEL DATAGRAMA
			InetAddress IPOrigen = rebut.getAddress();
			int portOrigen = rebut.getPort();
			System.out.println("\tProcedent de: "+IPOrigen+":"+portOrigen);
			System.out.println("\tDades: "+majuscula.trim());
		}
		
		//Tanca el socket
		clientSocket.close();
		
	}

}