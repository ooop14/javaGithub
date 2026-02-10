package d260206_01;

import java.io.BufferedWriter;
import java.util.Scanner;

public class Send extends Thread{
	BufferedWriter bw;
	
	
public Send(BufferedWriter bw) {
		this.bw = bw;
}

@Override
public void run() {
	while(true) {
		try {
			System.out.print("보낼 메시지 입력:");
			String msg=new Scanner(System.in).nextLine();
			bw.write(msg+"\r\n");
			bw.flush();
			sleep(100);
		}catch (Exception e) {}
	}
}
}
