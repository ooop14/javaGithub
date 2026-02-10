package d260210_02;

import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class PacketClient2 {

	public static void main(String[] args) {
		System.out.println("### 클라이언트 프로그램###");
		try (Socket socket = new Socket("172.16.15.91",1234)){
			System.out.println("connect: "+socket.isConnected());
			socket.setKeepAlive(true);
			
			Runtime.getRuntime().addShutdownHook(new Thread(() -> {
				System.out.println("클라이언트 프로그램 종료 감지!");
				System.exit(0);
			}));
			
			
			while (true) {
				
				Packet packet = new Packet();
				packet.setProtocolType(Packet.MESSAGE);
				packet.setMessage("welcome to hello world");

				byte[] data = new byte[1024];
				data[0] = (byte)packet.getProtocolType();
				
				byte[] message = packet.getMessage().getBytes(StandardCharsets.UTF_8);
				System.arraycopy(message, 0, data, 1, packet.getMessage().length());
								
				socket.getOutputStream().write(data);
 				socket.getOutputStream().flush();
 				System.out.println("데이터 전송");
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
