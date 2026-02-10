package d260209Client.copy;

import java.awt.TextArea;
import java.awt.TextField;
import java.io.BufferedReader;
import java.net.Socket;
import java.util.Map;

public class Recv extends Thread{
	
	BufferedReader br;
	TextArea ta;
	TextField tmsg;
	
	public Recv(BufferedReader br, TextArea ta) {
		this.br=br;
		this.ta=ta;
	}

	@Override
	public void run() {
		while(true) {
			try {
			String recvmsg=br.readLine();
			System.out.println("수신메시지:"+recvmsg);
			ta.setText(ta.getText()+recvmsg+"\r\n");
			ta.setCaretPosition(ta.getText().length());
			sleep(100);
			}catch (Exception e) { }
		}
	}
}
