package d260210_02;

import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class PacketClient {

	public static void main(String[] args) {
		System.out.println("### 클라이언트 프로그램###");
		try (Socket socket = new Socket("172.16.15.91",1234)){
			System.out.println("connect: "+socket.isConnected());
			socket.setKeepAlive(true);
			
			Runtime.getRuntime().addShutdownHook(new Thread(() -> {
				System.out.println("클라이언트 프로그램 종료 감지!");
				System.exit(0);
			}));
			
			//파일을 송수신할 떄 socket이 끊어진 상태를 어떻게 확인할 것인가?(******)
			//InputStream, OutputStream이 동작할 떄 확인 가능
			//만약 스트림이 없을 경우 어떻게 확인하는가?
			while (true) {
				//연결 된 상태에서 유지되는 상태가 아니므로 false
				//System.out.println("keepAlive: "+socket.getKeepAlive());
				//System.out.println("connect: "+socket.isConnected());
				//System.out.println("close: "+socket.isClosed());
				
				//패킷을 이용하여 데이터를 보내는 방법 
				Packet packet = new Packet();
				packet.setProtocolType(Packet.LOGIN);
				packet.setId("admin");
				packet.setPassword("1234");
				//설정한 값을 바이트코드로 만들고 Packet안에  byte[] packet;자동으로 변환
				byte[] data = new byte[1024];
				data[0] = (byte)packet.getProtocolType();
				//packet.getId().getBytes();
				byte[] id = packet.getId().getBytes(StandardCharsets.UTF_8);
				//System.arraycopy(src, srcPos, dest, destPos, length); => 보내려는 data에 2번위치에 id를 바이트로 복사 /고정 크기 20
				System.arraycopy(id, 0, data, 1, packet.getId().length());
				//패스워드 문자를 바이트로 만들고 data 바이트에 복사하는 작업
				byte[] pass = packet.getPassword().getBytes(StandardCharsets.UTF_8);
				System.arraycopy(pass, 0, data, 20+1, packet.getPassword().length());
				
				//위의 코드를 Packet의 내부 함수로 작성하여 byte[] packet;에 자동 입력되도록 만들어야 한다.
				//data 바이트 크기만큼 전체를 보낼 떄
				//socket.getOutputStream().write(data);
				
				//data의 크기만큼 바이트를 보낼 떄
				/*
				int cnt = 0;
				for (byte b:data) {
					if(b!=0) cnt++;
				}
				
				byte[] data2 = Arrays.copyOf(data, cnt);
 				socket.getOutputStream().write(data,0,data2.length);
 				*/
				//protocoltype : 1byte, id : 20byte, password:20byte
				socket.getOutputStream().write(data,0,41);
 				socket.getOutputStream().flush();
 				System.out.println("데이터 전송");
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
