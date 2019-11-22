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
		
		System.out.println("\tM�tode getByName(): "+dir);
		
		try {
			dir2 = InetAddress.getLocalHost();
			System.out.println("\tM�tode getLocalHost(): "+dir2);
		} catch (UnknownHostException e) {e.printStackTrace();}
		
		//FEM SERVIR TOTS ELS M�TODES DE LA CLASSE
		System.out.println("\tM�tode getHostName(): "+dir.getHostName());
		System.out.println("\tM�tode getHostAddress(): "+dir.getHostAddress());
		System.out.println("\tM�tode toString(): "+dir.toString());
		System.out.println("\tM�tode getCanonicalHostName(): "+dir.getCanonicalHostName());
		System.out.println("\tM�tode getAddress(): "+dir.getAddress());
		System.out.println("\tM�tode hashCode(): "+dir.hashCode());
		System.out.println("\tM�tode isAnyLocalAddress(): "+dir.isAnyLocalAddress());
		System.out.println("\tM�tode getLoopbackAddress(): "+dir.getLoopbackAddress());
		System.out.println("\tM�tode isLinkLocalAddress(): "+dir.isLinkLocalAddress());
		System.out.println("\tM�tode isLoopbackAddress(): "+dir.isLoopbackAddress());
		System.out.println("\tM�tode isMCGlobal(): "+dir.isMCGlobal());
		System.out.println("\tM�tode isMCLinkLocal(): "+dir.isMCLinkLocal());
		System.out.println("\tM�tode isMCNodeLocal(): "+dir.isMCNodeLocal());
		System.out.println("\tM�tode isMCOrgLocal(): "+dir.isMCOrgLocal());
		System.out.println("\tM�tode isMCSiteLocal(): "+dir.isMCSiteLocal());
		System.out.println("\tM�tode isMulticastAddress(): "+dir.isMulticastAddress());
		System.out.println("\tM�tode isSiteLocalAddress(): "+dir.isSiteLocalAddress());
		//System.out.println("\tM�tode getByAddress(): "+dir.getByAddress(null));
		System.out.println("\tM�tode getLocalHost(): "+dir.getLocalHost());		
	}

}
