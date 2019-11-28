import java.net.*;

public class Exemple1URL {
	
	public static void main (String[] args) {
		URL url;
		int port = Integer.parseInt(args[1]);
		
		//Diferents constructors segons les dades d'entrada
		try {
			
			System.out.println("Constructor simple per a un URL: ");
//			url = new URL("http://docs.oracle.com/");
			url = new URL(args[0]);
			Visualitzar (url);
			
			System.out.println("Altra constructor simple per a un URL: ");
//			url = new URL("http://localhost/moodle/");
			url = new URL(args[0]);
			Visualitzar (url);
			
			System.out.println("Constructor per a protocol + URL + directori: ");
//			url = new URL("http", "doc.oracle.com", "/javase/7");
			String direccio = args[0];
			String protocol = direccio.substring(0,4);
			direccio = direccio.substring(7, direccio.length() - 1);
			url = new URL(protocol, direccio, "/javase/7");
			Visualitzar (url);
			
			System.out.println("Constructor per a protocol + URL + port + directori: ");
//			url = new URL("http", "doc.oracle.com", 80, "/javase/7");
			url = new URL(protocol, direccio, port, "/javase/7");
			Visualitzar (url);
			
			System.out.println("Constructor per a un objecte URL i un directori: ");
//			URL urlBase = new URL("http://docs.oracle.com/");
			URL urlBase = new URL(args[0]);
			url = new URL(urlBase, "/javase/7/docs/api/java/net/URL.html");
			Visualitzar (url);
			
		} catch (MalformedURLException e) { System.out.println(e); }
		
	}
	//MÈTODE PER MOSTRAR LES DADES CORRESPONENTS	
	private static void Visualitzar(URL url) {
		
		System.out.println("\tURL complerta: "+url.toString());
		System.out.println("\tgetProtocol: "+url.getProtocol());
		System.out.println("\tgetHost: "+url.getHost());
		System.out.println("\tgetPort: "+url.getPort());
		System.out.println("\tgetFile: "+url.getFile());
		System.out.println("\tgetUserInfo: "+url.getUserInfo());
		System.out.println("\tgetPath: "+url.getPath());
		System.out.println("\tgetAuthority: "+url.getAuthority());
		System.out.println("\tgetQuery: "+url.getQuery());
		System.out.println("=====================================================");
	}

}