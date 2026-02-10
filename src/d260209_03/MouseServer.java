package d260209_03;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MouseServer {

	public static void main(String[] args) {
		System.out.println("####마우스 좌표 확인 서버프로그램 시작####");
		try(ServerSocket server=new ServerSocket(1234)){
			System.out.println("접속대기중");
			Socket socket=server.accept();
			ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
			System.out.println(ois);
			while(true) {				
				Point p=(Point)ois.readObject();
				System.out.println("x:"+p.x +",y:"+ p.y);
				//x,y좌표를 이용해서 프레임(800,600)을 만들고 클라이언트에서 움직이는 방향으로 선을 그으세요.!!
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}