package d260206_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//1대1챗팅은 작업 단위가 송신, 수신을 하는 작업이 2개 존재하면 된다.
//서버와 클라이언트 연결과정까지는 동일하고 연결 후에 송신쓰레드, 수신쓰레드가 동작하면 된다.
//main함수도 쓰레드이므로 송신 또는 수신중에 하나는 main함수에서 구현해도 되지만 별도로 작성할 것임.
public class OneAndOneChatServer {

	public static void main(String[] args) {
		System.out.println("####서버프로그램 시작####");
		try(ServerSocket server=new ServerSocket(1234)){
			Socket socket=server.accept();
			System.out.println(socket.getRemoteSocketAddress()+"접속");
			System.out.println("챗팅시작!!");

			InputStream in=socket.getInputStream();
			OutputStream out=socket.getOutputStream();
			
			BufferedReader br=new BufferedReader(new InputStreamReader(in));
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(out));
			
			//아래의 코드는 송신과 수신을 가지고 있는 코드이다.
			//아래의 코드를 분리하여 송신쓰레드 클래스, 수신쓰레드 클래스로 만든다.
			//주의할 사항 : 송신코드 37줄부터 41줄까지, 수신코드는 43줄부터 43줄까지인데
			//이 두 구분은 while에서 돌아가고 있으므로 해당줄에 각각 while문을 사용해야한다.
			/* while(true) {
				//-----------송신코드----------------
				System.out.print("보낼 메시지 입력:");
				String msg=new Scanner(System.in).nextLine();
				bw.write(msg+"\r\n");
				bw.flush();
				Thread.sleep(100);
				//----------수신코드----------------				
				String recvmsg=br.readLine();
				System.out.println("수신메시지:"+recvmsg);
				//------------------------------
			}
			 */
			(new Send(bw)).start();//송신쓰레드
			(new Recv(br)).start();//수신쓰레드
			while(true) {Thread.sleep(100);}
			//main이 종료되는 지점이지만 쓰레드가 동작중이면 main은 끝나지 않는 상태를 유지
		}catch (Exception e) {
			System.out.println("서버소켓 미생성!!");
			System.exit(0);
		}
		
	}

}
