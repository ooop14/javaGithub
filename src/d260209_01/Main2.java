package d260209_01;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class Main2 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//Map<K, V> map
		//K - key, V - value
		//arp -a
		/*
		 * Map<String, Socket> map = new HashMap<String, Socket>();
		 * map.put("172.16.15.31", new Socket("172.16.15.31",8888));
		 * map.put("172.16.15.32", new Socket("172.16.15.32",8888));
		 * map.put("172.16.15.34", new Socket("172.16.15.34",8888));
		 * map.put("172.16.15.42", new Socket("172.16.15.42",8888));
		 * System.out.println(map);
		 */
		
		
		Map<String, Socket> map2 = new HashMap<String, Socket>();
		map2.put("acom", new Socket("172.16.15.31",8080));
		map2.put("bcom", new Socket("172.16.15.32",8080));
		map2.put("ccom", new Socket("172.16.15.34",8080));
		map2.put("dcom", new Socket("172.16.15.42",8080));
	
		System.out.println(map2.get("ccom").getRemoteSocketAddress());
		
	}

}
