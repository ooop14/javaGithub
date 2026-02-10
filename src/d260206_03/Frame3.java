package d260206_03;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Frame3 {

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
		f.add(new TextField(20));
		f.add(new Button("전송"));
		f.revalidate(); f.repaint();
		//챗팅프로그램에서 메시지창에 값을 입력하고 enter키를 누르면 전송되는 코드도 같이 구현(key event사용)
		//귀속말 기능 -> 홍길동>hello
		//파일을 업로드하는 기능
		
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

}
