package d260206_03;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

//Main화면
public class MyFrame2 extends Frame{
//frame구성 시 화면에 대한 부품을 맴버 변수로 나열
	private Panel panelA;
	private Label pa_idlb;
	private Label pa_namelb;
	private TextField pa_idtf;
	private TextField pa_nametf;
	private Button pa_button;
	private Button pa_cancelbtn;
	
	private Panel panelB;
	private Label pb_idlb;
	private Label pb_namelb;
	private Button pb_button;
	
	private EventProc event;
	
	public MyFrame2() {
		//설정(프레임)
		setTitle("Chating");
		setBounds(0,0,600,300);
		setLayout(new FlowLayout());
		setVisible(true);
		
		//부품생성(프레임에 들어갈 부품)
		panelA=new Panel(new FlowLayout());
		pa_idlb=new Label("아이디:");
		pa_namelb=new Label("이름:");
		pa_idtf=new TextField(20);
		pa_nametf=new TextField(20);
		pa_button =new Button("전송");
		pa_cancelbtn =new Button("취소");
		
		panelB=new Panel(new FlowLayout());
		pb_idlb=new Label("아이디:1");
		pb_namelb=new Label("이름:홍길동");
		pb_button =new Button("HOME");
		
		//프레임에 부품 넣기(배치)
		panelA.add(pa_idlb);
		panelA.add(pa_idtf);
		panelA.add(pa_namelb);
		panelA.add(pa_nametf);
		panelA.add(pa_button);
		panelA.add(pa_cancelbtn);
		
		panelB.add(pb_idlb);
		panelB.add(pb_namelb);
		panelB.add(pb_button);
		
		//사용할 판넬을 프레임에 추가
		add(panelA);
		
		//동작이 발생할 때 처리(리스너등록 or 이벤트처리)
		event=new EventProc(this); //이벤트 처리는 이 객체에서 처리하겠다.
		addWindowListener(event); //frame버튼처리(어디서)
		pa_button.addActionListener(event); //버튼을 눌렀을 때 처리
		pa_cancelbtn.addActionListener(event);
		pb_button.addActionListener(event);
	}

	public Panel getPanelA() {
		return panelA;
	}

	public Panel getPanelB() {
		return panelB;
	}

	
	
}
