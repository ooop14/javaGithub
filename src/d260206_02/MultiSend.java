package d260206_02;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class MultiSend extends Thread{
	List<Socket> socketlist;
	String msg;
	Socket socket;
	
	//필드생성자만 있고 기본생성자가 없을 경우 기본생성자는 사용할 수 없음
	public MultiSend(List<Socket> socketlist, String msg, Socket socket) {
		this.socketlist = socketlist;
		this.msg = msg;
		this.socket = socket;
	}


	@Override
	public void run() {
		//메시지를 전체소켓에 전달하고 나의 소켓은 메시지를 전달하지 않음
		try {
			for(Socket s:socketlist) {
				if(s!=socket) {
				try {
					BufferedWriter bw
					=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
					bw.write(msg+"\r\n");
					bw.flush();
					sleep(100);
				}catch (Exception e) {}
				}
			}
		}catch (Exception e) {}
	}
}
