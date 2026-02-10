package d260209Server.copy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;
import java.util.Objects;

public class MultiRecv extends Thread{
Socket socket;
List<Socket> socketlist;

public MultiRecv(Socket socket,List<Socket> socketlist) {
	this.socket=socket;
	this.socketlist=socketlist;
}
	@Override
public void run() {
		//수신 후에 송신처리
		while(true) {
			try {
				BufferedReader br
				=new BufferedReader(	new InputStreamReader(
								socket.getInputStream()));
				
				String recvmsg=br.readLine();								
				System.out.println("수신메시지:"+recvmsg);
				//수신된 메시지와 리스트를 전달하여 메시지 보내기 쓰레드 작업
				//(new MultiSend(socketlist,recvmsg)).start(); //나의 소켓을 확인할 수 없음
				//소켓리스트로 메시지를 보내는데 나의 소켓은 보내지 마라
				(new MultiSend(socketlist,recvmsg,socket)).start();
				}catch (Exception e) { 
					//msg가 null일경우 오류발생 이때 소켓을 close하고 리스트에서 제거
					try {
						socket.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					socketlist.remove(socketlist.indexOf(socket));
					System.out.println("1명이 챗팅방을 나갔습니다.");
					System.out.println("현재접속자 수:"+socketlist.size());
					break;					
				}
		}
}
}
