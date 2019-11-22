import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
	
	public static void main (String[] args) {
		String nomMaquina = args[0];
		
		InetAddress dir = null;
		System.out.println("=====================================================");
		System.out.println("SORTIDA PER A LOCALHOST");
		
		try {
			//LOCALHOST
			dir = InetAddress.getByName(nomMaquina);
			provaTots(dir);
			
			//URL www.google.com
			System.out.println("=====================================================");
			System.out.println("SORTIDA PER A URL");
			dir = InetAddress.getByName(nomMaquina);
			provaTots(dir);
			
			//Array tipus InetAddress amb totes les adreces IP de google.com
			System.out.println("\tAdreces IP per a: "+dir.getHostName());
			InetAddress[] adreces = InetAddress.getAllByName(dir.getHostName());
			for (int i=0; i<adreces.length; i++)
				System.out.println("\t\t"+adreces[i].toString());
			System.out.println("=====================================================");
			
		} catch (UnknownHostException e1) {e1.printStackTrace();}
		
	}
	
	private static void provaTots(InetAddress dir) throws UnknownHostException {
		
		InetAddress dir2;
		
		System.out.println("\tMètode getByName(): "+dir);
		
		try {
			dir2 = InetAddress.getLocalHost();
			System.out.println("\tMètode getLocalHost(): "+dir2);
		} catch (UnknownHostException e) {e.printStackTrace();}
		
		//FEM SERVIR TOTS ELS MÊTODES DE LA CLASSE
		System.out.println("\tMètode getHostName(): "+dir.getHostName());
		System.out.println("\tMètode getHostAddress(): "+dir.getHostAddress());
		System.out.println("\tMètode toString(): "+dir.toString());
		System.out.println("\tMètode getCanonicalHostName(): "+dir.getCanonicalHostName());
		System.out.println("\tMètode getAddress(): "+dir.getAddress());
		System.out.println("\tMètode hashCode(): "+dir.hashCode());
		System.out.println("\tMètode isAnyLocalAddress(): "+dir.isAnyLocalAddress());
		System.out.println("\tMètode getLoopbackAddress(): "+dir.getLoopbackAddress());
		System.out.println("\tMètode isLinkLocalAddress(): "+dir.isLinkLocalAddress());
		System.out.println("\tMètode isLoopbackAddress(): "+dir.isLoopbackAddress());
		System.out.println("\tMètode isMCGlobal(): "+dir.isMCGlobal());
		System.out.println("\tMètode isMCLinkLocal(): "+dir.isMCLinkLocal());
		System.out.println("\tMètode isMCNodeLocal(): "+dir.isMCNodeLocal());
		System.out.println("\tMètode isMCOrgLocal(): "+dir.isMCOrgLocal());
		System.out.println("\tMètode isMCSiteLocal(): "+dir.isMCSiteLocal());
		System.out.println("\tMètode isMulticastAddress(): "+dir.isMulticastAddress());
		System.out.println("\tMètode isSiteLocalAddress(): "+dir.isSiteLocalAddress());
		//System.out.println("\tMètode getByAddress(): "+dir.getByAddress(null));
		System.out.println("\tMètode getLocalHost(): "+dir.getLocalHost());		
	}

}
