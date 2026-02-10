package d260206_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class OneAndOneChatClient {

	public static void main(String[] args) {
		System.out.println("####클라이언트 프로그램####");
		try(Socket socket=new Socket("172.16.15.97", 1234)){
			System.out.println("서버에 접속했습니다.");
			InputStream in=socket.getInputStream();
			OutputStream out=socket.getOutputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(in));
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(out));
			
			//서버와 메시지를 교환
			/*
			while(true) {
				//수신된 메시지 확인하기
				String recvmsg=br.readLine();
				System.out.println("수신메시지:"+recvmsg);
				
				//서버가 메시지 보내기
				System.out.print("보낼 메시지 입력:");
				String msg=new Scanner(System.in).nextLine(); //챗팅 뛰워쓰기 가능하므로 nextLine사용
				bw.write(msg+"\r\n"); //문자열로 보내기
				bw.flush();
				Thread.sleep(100);
			}
			*/
			
			(new Send(bw)).start();//송신쓰레드
			(new Recv(br)).start();//수신쓰레드
			while(true) {Thread.sleep(100);}
		}catch (Exception e) {
			System.out.println("서버와 접속이 되지 않습니다.");
			System.exit(0);
		}

	}

}
