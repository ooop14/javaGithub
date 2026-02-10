package d260206_01;

import java.io.BufferedReader;

public class Recv extends Thread{
	
	BufferedReader br;
		
	public Recv(BufferedReader br) {
		this.br = br;
	}

	@Override
	public void run() {
		while(true) {
			try {
			String recvmsg=br.readLine();
			System.out.println("수신메시지:"+recvmsg);
			}catch (Exception e) { }
		}
	}
}
