package d260206_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import d260206_01.Recv;
import d260206_01.Send;

//클라이언트는 메시지를 보내고 받기(별도의 수신, 송신 쓰레드 작성)
public class MultiChatClient {

	public static void main(String[] args) {
		System.out.println("####클라이언트 프로그램####");
		try(Socket socket=new Socket("172.16.15.97", 1234)){
			System.out.println("서버에 접속했습니다.");
(new Send(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())))).start();//송신쓰레드
(new Recv(new BufferedReader(new InputStreamReader(socket.getInputStream())))).start();//수신쓰레드
			while(true) {Thread.sleep(100);}
		}catch (Exception e) {
			System.out.println("서버와 접속이 되지 않습니다.");
			System.exit(0);
		}
	}

}
