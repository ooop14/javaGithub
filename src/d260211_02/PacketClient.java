package d260211_02;

import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class PacketClient {
	public static void main(String[] args) {
		System.out.println("####클라이언 프로그램#####");
		try(Socket socket=new Socket("172.16.15.97",1234)){
				
			//데이터를 보낼 떄 : 문자열 -> 바이트
				Packet packet=new Packet();
				packet.setProtocolType(Packet.MESSAGE);
				packet.setMessage("welcome to hello world");
				socket.getOutputStream().write(packet.getPacket());
				socket.getOutputStream().flush();
				System.out.println("데이터 전송");
				Thread.sleep(1000);
			
		}catch (Exception e) {System.out.println(e.getMessage());}

	}
}