package d260211_02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class PacketServer {
//데이터를 수신할 떄 : 바이트 배열로 데이터가 입력(사람이 알아 볼 수 없는 형태) -> 문자열, 숫자등으로 변환(String,int)
//데이터를 보낼 떄 : 문자열, 숫자등으로 입력 -> 바이트로 변환
	public static void main(String[] args) {
		System.out.println("#######서버 프로그램#######");
		try(ServerSocket server=new ServerSocket(1234)){
			
			Socket socket=server.accept();
			System.out.println("클라이언트가 접속함");

				//패킷받기(바이트 배열을 패캣안에 넣은 후 자동으로 패킷배열을 분리하는 함수 작성)
				//데이터를 수신할 떄 바이트 -> 문자
				Packet packet=new Packet();
				byte[] data=new byte[2*1028];
				int len=socket.getInputStream().read(data);
				System.out.println("전달받은 데이터의 길이: "+len);
				packet.setPacket(data);
				
				switch(data[0]) {
				case Packet.LOGIN: 					
					if(packet.getId().equals("admin") && packet.getPassword().equals("1234")) {
						System.out.println("로그인성공");
					}else {
						System.out.println("로그인실패");
					}
					break;
				case Packet.MESSAGE: 
					System.out.println(packet.getMessage());
					break;
					
				}
				
				Thread.sleep(1000);
			//}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}