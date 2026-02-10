package d260209Client.copy;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicReference;

public class Frame4 {
	
	static AtomicReference<Socket> socketRef = new AtomicReference<>();
	
	public static void main(String[] args) {
		Frame f=new Frame();
		f.setTitle("Chating");
		f.setBounds(0,0,600,300);
		f.setLayout(new FlowLayout());
		f.setVisible(true);
		TextArea ta=new TextArea(10,20);
		String msg="kim:hello\r\nhong:hello\r\nkim:hello2\r\nhong:hello2\r\n";
		ta.setText(msg);
		ta.setEditable(false);
		f.add(ta);
		f.add(new Label("메시지입력:"));
		TextField tmsg=new TextField(20);
		f.add(tmsg);
		f.add(new Button("전송"));
		f.revalidate(); f.repaint();
		//챗팅프로그램에서 메시지창에 값을 입력하고 enter키를 누르면 전송되는 코드도 같이 구현(key event사용)
		//귀속말 기능 -> 홍길동>hello
		//파일을 업로드하는 기능
		
		//리스너 등록
		//리스너를 등록할 때 무엇에 대한 리스너등록인지 구분해야함.
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//메시지 보내기전에 소켓을 연결하는 작업을 생성자에서 처리
		//콘솔상에서는 Send, Recv객체가 무한반복으로 처리중이지만
		//프레임에서는 무한반복하면 안됨.
		Socket socket = null;
		try{
			socket = new Socket("172.16.15.91", 1234);
			socketRef.set(socket); 
			System.out.println("서버에 접속했습니다.");
//(new Send(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())))).start();//송신쓰레드
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//수신하는 쓰레드는 무한 반복(br은 수신하기 위해 inputStream이 필요, 수신된 데이터를 textarea에 표시)
			//tmsg는 텍스트필드의 문자열을 ""로 만들기 위해 필요하므로 3개의 객체를 전달
			(new Recv(br,ta)).start();//수신쓰레드			
		}catch (Exception e) {
			System.out.println("서버와 접속이 되지 않습니다.");
			System.exit(0);
		}
		
		//tmsg의 값이 엔터키일 때 메시지를 전송하세요.
		tmsg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()==e.VK_ENTER) {
					System.out.println("텍스트 박스에서 엔터키를 눌렀습니다.");
					//메시지를 보내기 위해서는 tmsg의 값을 가지고 와서
					String sendmsg=tmsg.getText();
					//메시지값을 소켓으로 send 시키고
					BufferedWriter bw = null;
					try {
						bw = new BufferedWriter(new OutputStreamWriter(socketRef.get().getOutputStream()));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					//전달된 메시지(sendmessage)를 bw를 이용하여 보내고 tmsg를 "" 깨끗하게 처리한다. 
					new Send(bw,sendmsg,tmsg).start();;
					
					//수신된 값을 textArea 텍스트 상자에 입력(누적해야함/줄바꿈/자동으로 스크롤 내리방법)
					//ta.setText(ta.getText()+sendmsg+"\r\n");
					//ta.setCaretPosition(ta.getText().length());
					//tmsg의 값을 빈값을 초기화
					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					tmsg.setText("");
					
				}
			}
		});

	}

		
}
