package d260209Client.copy;

import java.awt.TextField;
import java.io.BufferedWriter;
import java.util.Scanner;

public class Send extends Thread{
	BufferedWriter bw;
	String msg;
	TextField tmsg;
	
public Send(BufferedWriter bw,String msg,TextField tmsg) {
		this.bw = bw;
		this.msg=msg;
		this.tmsg=tmsg;
}

@Override
public void run() {
		try {
			bw.write(msg+"\r\n");
			bw.flush();
			tmsg.setText("");
			sleep(100);
		}catch (Exception e) {}	
}
}
