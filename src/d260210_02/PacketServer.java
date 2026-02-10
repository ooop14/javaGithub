package d260210_02;import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class PacketServer {

	public static void main(String[] args) {
		System.out.println("### 서버 프로그램 ###");
		try (ServerSocket server = new ServerSocket(1234)){
			Socket socket = server.accept();
			System.out.println("클라이언트가 접속");
			System.out.println("connect: "+ socket.isConnected());
			
			socket.setKeepAlive(true);
			
			//강제로 종료될 떄 (한번만)
			Runtime.getRuntime().addShutdownHook(new Thread(() -> {
				System.out.println("서버 프로그램 종료 감지!");
				System.exit(0);
			}));
			
			//1:1이라고 가정할 경우 아래에 코드 위치(데이터 수신)
			while (true) {
			//클라이언트에서 프로그램을 종료 시켰을 떄 현재 상태를 확인하는 방법
				//처음 연결시 만 true
				//System.out.println("keyalive" + socket.getKeepAlive());
				//System.out.println("connect: "+socket.isConnected());
				//System.out.println("close: "+socket.isClosed());

				//데이터를 스트림으로 전송하고 try catch로 오류를 확인하여 처리하는 방식
				/*
				 * try { socket.setOOBInline(true); socket.sendUrgentData(0xFF);
				 * System.out.println("소캣 살아있음"); } catch (Exception e) {
				 * System.out.println("소캣 죽었음"); }
				 */
				
				//패킷 받기
				byte[] data = new byte[2*1028];
				int len = socket.getInputStream().read(data);
				System.out.println("전달받은 데이터의 길이: " + len);
				System.out.println(new String(data).trim());
				System.out.println(Arrays.toString(data));
				
				switch(data[0]) {
				case Packet.LOGIN:
					String id = new String(data,1,20,StandardCharsets.UTF_8).trim();
					String password = new String(data,21,40,StandardCharsets.UTF_8).trim();
					if (id.equals("admin")&&password.equals("1234")) {
						System.out.println("로그인 성공");
					}else {
						System.out.println("로그인 실패");
					}
					break;
				case Packet.MESSAGE:
					String message = new String(data,1,len);
					System.out.println(message);
					break;
				}
				
				Thread.sleep(1000);
			}
		} 
		catch (Exception e) {	}

	}

}
