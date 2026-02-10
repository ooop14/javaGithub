package d260209_03;


import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ProtocolMain {

	public static void main(String[] args) throws IOException {
		//프로토콜은 약속 / 규약
		//데이터를 전송할 떄 정해진 크기에 맞게 데이터 전송하는 목적
		//x,y좌표의 값을 전송하기 위한 방법
		int x = 100;
		int y = 200;
		Socket socket = new Socket("localhost",1111);
		OutputStream out = socket.getOutputStream();
		out.write(x);
		out.write(y);
		out.flush();
		//위의 문제는 한번에 데이터를 받을 수 없는 문제가 발생한다.
		Point p = new Point(100,200);
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(p);
		oos.flush();
		
	}

}
