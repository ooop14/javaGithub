package d260206_03;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

//Main화면
public class MyFrame extends Frame{
//frame구성 시 화면에 대한 부품을 맴버 변수로 나열
	//Panel panel;
	Label idlb;
	Label namelb;
	TextField idtf;
	TextField nametf;
	Button button;
	Button cancelbtn;
	
	EventProc event;
	
	public MyFrame() {
		//설정(프레임)
		setTitle("Chating");
		setBounds(0,0,200,400);
		setLayout(new FlowLayout());
		setVisible(true);
		
		//부품생성(프레임에 들어갈 부품)
		idlb=new Label("아이디:");
		namelb=new Label("이름:");
		idtf=new TextField(20);
		nametf=new TextField(20);
		button =new Button("전송");
		cancelbtn =new Button("취소");
		
		//프레임에 부품 넣기(배치)
		add(idlb);
		add(idtf);
		add(namelb);
		add(nametf);
		add(button);
		add(cancelbtn);
		
		//동작이 발생할 때 처리(리스너등록 or 이벤트처리)
		event=new EventProc(); //이벤트 처리는 이 객체에서 처리하겠다.
		addWindowListener(event); //frame버튼처리(어디서)
		button.addActionListener(event); //버튼을 눌렀을 때 처리
		cancelbtn.addActionListener(event);
	}
}
