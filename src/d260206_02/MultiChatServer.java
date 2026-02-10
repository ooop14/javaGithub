package d260206_02;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

//설명:
//1대1 챗팅에서는 송신, 수신에 관한 쓰레드를 생성
//다중 챗팅은 하나의 서버에서 여러개의 클라이언트가 접속하는 구조이며
//서버 입장에서는 여러 클라이언트의 접속을 처리할 쓰레드가 필요하다.
//접속된 정보를 리스트로 관리하여 1명의 클라이언트가 메시지를 보내오면
//접속된 정보 리스트를 이용하여 접속되어 있는 모든 클라이언트에게 메시지를 보내야 한다.
//서버에서 쓰레드로 만들어야 할 것은 클라이언트가 접속하는 것을 기다리는 쓰레드, 송신, 수신
//main함수가 놀고 있는 상태가 아닌 서버접속을 처리하고 소켓을 관리하는 역할(쓰레드)
//수신은 클라이언트가 보내오는 메시지 받기
//송신은 클라이언트가 보내오는 메시지를 처리(여러명에게 메시지 보내기)
//결론:클라이언트가 보내오는 메시지를 받은 후 송신처리

public class MultiChatServer {
	
	
	public static void main(String[] args) {
		//접속한 클라이언트의 소켓을 저장하는 공간
		List<Socket> socketlist=new ArrayList<Socket>();
		
		System.out.println("####서버프로그램 시작####");
		try(ServerSocket server=new ServerSocket(1234)){
			while(true) {
			//접속에 대한 정보 처리
			System.out.println("접속대기중");
			Socket socket=server.accept();
			socketlist.add(socket); //접속한 클라이언트의 소켓을 누적저장
			System.out.println(socket.getRemoteSocketAddress()+" 접속");
			System.out.println("접속인원:"+socketlist.size());
			//같은 ip주소로 클라이언트 프로그램을 여러번 실행하면 포트번호가 다르므로
			//여러개의 socket이 누적되어 있는 문제가 발생을 함.
			//이를 해결하기 위해서 ip주소를 확인하고 1개의 프로그램만 실행되도록 처리
			//서버에서도 가능하지만 클라이언트에서 싱글톤방법을 이용하여 처리
			//접속한 객체에 대해 송신? 수신? 쓰레드를 생성
			//수신 후에 송신을 바로 처리(수신쓰레드만 필요)
			(new MultiRecv(socket,socketlist)).start();
			//실행 후 문제점 확인
			//소켓이 끊어 졌을 때 처리
			}
			
		}catch (Exception e) {}

	}

}
