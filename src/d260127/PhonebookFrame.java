package d260127;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PhonebookFrame extends Frame{
	PhonebookManager pm=new PhonebookManager();
	//메인메뉴 부품
	Button menuInsertbtn;
	Button menuAllprintbtn;
	Button menuViewbtn;
	Button menuUpdatebtn;
	Button menuDeletebtn;
	
	//입력 부품
	Label insertNamelb;
	Label insertHplb;
	Label insertEmaillb;
	TextField insertNametf;
	TextField insertHptf;
	TextField insertEmailtf;
	Button insertInsertbtn;
	
	//전체출력 부품
	java.awt.List listBox;
	Label viewIdlb, viewNamelb, viewHplb, viewEmaillb;
	
	//찾기부품
	Label updateNamelb;
	TextField updateSearchNametf;
	Button updateSearchbtn;
	java.awt.List updateSearchListBox;
	
	//수정부품
	Label updateNamelb2;
	TextField updateNametf;
	Button updatebtn;
	java.awt.List updateListBox;
	java.awt.List updateSearchListBox2;
	
	
	
	//삭제 부품
	
	
	public PhonebookFrame() {
		setTitle("전화번호부 프로그램");
		setBounds(0,0,400,700);
		setLayout(new FlowLayout());
		setVisible(true);
		//윈도우 닫기 이벤트 처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//메인 메뉴 부품 만들기
		menuInsertbtn=new Button("전화번호부 입력");
		menuAllprintbtn=new Button("전화번호부 전체출력");
		menuViewbtn=new Button("전화번호부 찾기");
		menuUpdatebtn=new Button("전화번호부 수정");
		menuDeletebtn=new Button("전화번호부 삭제");
		menuInsertbtn.setPreferredSize(new Dimension(300, 50));
		menuAllprintbtn.setPreferredSize(new Dimension(300, 50));
		menuViewbtn.setPreferredSize(new Dimension(300, 50));
		menuUpdatebtn.setPreferredSize(new Dimension(300, 50));
		menuDeletebtn.setPreferredSize(new Dimension(300, 50));
		//부품을 추가하기
		add(menuInsertbtn);
		add(menuAllprintbtn);
		add(menuViewbtn);
		add(menuUpdatebtn);
		add(menuDeletebtn);
		
		//insert기능에 부품을 만들고 add
		insertNamelb=new Label("이름:");
		insertHplb=new Label("전화번호:");
		insertEmaillb=new Label("이메일:");
		insertNametf=new TextField();
		insertHptf=new TextField();
		insertEmailtf=new TextField();
		insertInsertbtn=new Button("전화번호부 입력");
		
		insertNamelb.setVisible(false);
		insertHplb.setVisible(false);
		insertEmaillb.setVisible(false);
		insertNametf.setVisible(false);
		insertHptf.setVisible(false);
		insertEmailtf.setVisible(false);
		insertInsertbtn.setVisible(false);
		
		add(insertNamelb);
		add(insertNametf);
		add(insertHplb);
		add(insertHptf);
		add(insertEmaillb);
		add(insertEmailtf);
		add(insertInsertbtn);
		
		insertNamelb.setPreferredSize(new Dimension(100,50));
		insertNamelb.setAlignment(Label.RIGHT);
		insertNametf.setColumns(30);
		insertHplb.setPreferredSize(new Dimension(100,50));
		insertHptf.setColumns(30);
		insertEmaillb.setPreferredSize(new Dimension(100,50));
		insertEmailtf.setColumns(30);
		insertInsertbtn.setPreferredSize(new Dimension(300, 50));
		
		//추가한 부품을 처리하기 위한 버튼 이벤트 추가
		menuInsertbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible();
				insertNamelb.setVisible(true);
				insertNametf.setVisible(true);
				insertHplb.setVisible(true);
				insertHptf.setVisible(true);
				insertEmaillb.setVisible(true);
				insertEmailtf.setVisible(true);
				insertInsertbtn.setVisible(true);
				//화면을 새로 그리기 위해서는 2개의 함수가 동시 호출
				revalidate();
				repaint();
				//insertbtn을 눌렀을 때 이벤트처리
				insertInsertbtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						//System.out.println(nametf.getText());
						//System.out.println(hptf.getText());
						//System.out.println(emailtf.getText());
						pm.insert(insertNametf.getText(),
								insertHptf.getText(),
								insertEmailtf.getText());
						System.out.println(pm.getList());
						insertNametf.setText("");
						insertHptf.setText("");
						insertEmailtf.setText("");
						insertNametf.setFocusable(true);
					}
				});
			}
		});
		
		//전체출력 부품 생성 및 설정
		listBox=new List(10); //리스트행을 10개 나타내겠다는 의미
		listBox.setPreferredSize(new Dimension(600, 0)); //리스트박스 사이즈 너비 500
		Panel panel=new Panel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.add(listBox);
		add(panel);
		listBox.setVisible(false);
	
		//전체리스트 보기
		menuAllprintbtn.addActionListener
		(new ButtonFunc(this,pm.getList()));
	
		//전체리스트에서 레이블설정
		viewIdlb=new Label("아이디:"); 
		viewIdlb.setBackground(Color.ORANGE);
		viewIdlb.setPreferredSize(new Dimension(200, 30));
		viewIdlb.setVisible(false);
		add(viewIdlb);
		
		viewNamelb=new Label("이름:");
		viewNamelb.setBackground(Color.YELLOW);
		viewNamelb.setPreferredSize(new Dimension(200, 30));
		viewNamelb.setVisible(false);
		add(viewNamelb);
		
		viewHplb=new Label("전화번호:");
		viewHplb.setBackground(Color.cyan);
		viewHplb.setPreferredSize(new Dimension(200, 30));
		viewHplb.setVisible(false);
		add(viewHplb);
		
		viewEmaillb=new Label("이메일:");
		viewEmaillb.setBackground(Color.LIGHT_GRAY);
		viewEmaillb.setPreferredSize(new Dimension(200, 30));
		viewEmaillb.setVisible(false);
		add(viewEmaillb);
		//전체리스트에서 하나의 아이템을 선택했을 때 상세보기
		//1)리스트를 클리할 때
		//2)리스트의 정보를 가지고 온 후 분리
		//3)분리된 데이터를 레이블에 표시(레이블을 생성/설정/추가)
		listBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println("test....");
				setVisible();
				listBox.setVisible(true);
				viewIdlb.setVisible(true);
				viewNamelb.setVisible(true);
				viewHplb.setVisible(true);
				viewEmaillb.setVisible(true);
				//아래의 데이터는 프레임에서 ListBox내용이므로 Email메일 확인 불가
				//String[] datas=listBox.getSelectedItem().split(" ");
				//System.out.println(datas);
				//listBox에서 id를 구하고
				//전체 리스트 정보에서 id와 비교하여 같은 아이디를 출력하시오.
				//Phonebook p=pm.getList().get((int) e.getItem());
				int id=Integer.parseInt(listBox.getSelectedItem().split(" ")[0]);
				for(Phonebook p:pm.getList()) {
					if(p.getId()==id && listBox.getSelectedIndex()!=0) {
						System.out.println(p);		
						viewIdlb.setText("아이디:"+ p.getId());
						viewNamelb.setText("이름:"+ p.getName());
						viewHplb.setText("전화번호:"+ p.getHp());
						viewEmaillb.setText("이메일:"+ p.getEmail());
					}
				}
				
				
				
				
				revalidate(); repaint();
				
			}
		});
		
		//찾기
		updateNamelb=new Label("찾을 이름:");
		updateSearchNametf=new TextField(20);
		updateSearchbtn=new Button("찾기");
		
		updateNamelb.setVisible(false);
		updateSearchNametf.setVisible(false);
		updateSearchbtn.setVisible(false);
			
		add(updateNamelb);
		add(updateSearchNametf);
		add(updateSearchbtn);
		
		updateSearchListBox=new List();
		updateSearchListBox.setVisible(false);
		add(updateSearchListBox);
		
		//찾기메뉴선택버튼
		menuViewbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible();
				updateNamelb.setVisible(true);
				updateSearchNametf.setVisible(true);
				updateSearchbtn.setVisible(true);
				revalidate(); repaint();
			}
		});
		//찾기 버튼 실행
		updateSearchbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible();
				updateNamelb.setVisible(true);
				updateSearchNametf.setVisible(true);
				updateSearchbtn.setVisible(true);
				updateSearchListBox.setVisible(true);
				
				String search=updateSearchNametf.getText();
				Phonebook p=pm.selectByName(search);
				if(p!=null) {
					updateSearchListBox.add(p.getId() + " " +p.getName());
				}
				revalidate(); repaint();
			}
		});
		
		//검색한 리스트 박스를 클릭할 때
		updateSearchListBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				setVisible();
				updateNamelb.setVisible(true);
				updateSearchNametf.setVisible(true);
				updateSearchbtn.setVisible(true);
				updateSearchListBox.setVisible(true);
				
				int id=Integer.parseInt(listBox.getSelectedItem().split(" ")[0]);
				for(Phonebook p:pm.getList()) {
					if(p.getId()==id && listBox.getSelectedIndex()!=0) {
						System.out.println(p);		
						viewIdlb.setText("아이디:"+ p.getId());
						viewNamelb.setText("이름:"+ p.getName());
						viewHplb.setText("전화번호:"+ p.getHp());
						viewEmaillb.setText("이메일:"+ p.getEmail());
					}
				}	
				revalidate(); repaint();			
			}
		});
		
		//수정
		updateNamelb2 = new Label("수정할 분의 성함");
		updateNametf = new TextField(20);
		updatebtn = new Button("찾기");
		updateSearchListBox2 = new List();
		
		updateNamelb2.setVisible(false);
		updateNametf.setVisible(false);
		updatebtn.setVisible(false);
		updateSearchListBox2.setVisible(false);
		
		add(updateNamelb2);
		add(updateNametf);
		add(updatebtn);
		add(updateSearchListBox2);
		
		//수정 메뉴 클릭시
		menuUpdatebtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible();
				updateNamelb2.setVisible(true);
				updateNametf.setVisible(true);
				updatebtn.setVisible(true);
				
				revalidate(); repaint();
			}
		});
		
		
		//찾기 버튼 클릭시
		updatebtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible();
				updateNamelb2.setVisible(true);
				updateNametf.setVisible(true);
				updatebtn.setVisible(true);
				updateSearchListBox2.setVisible(true);
				
				String search=updateNametf.getText();
				Phonebook p=pm.selectByName(search);
				if(p!=null) {
					updateSearchListBox2.add(p.getId() + " " +p.getName());
				}
				revalidate(); repaint();
			}
		});
		
		
		
		
	}
	
	
	
	public java.awt.List getListBox() {
		return listBox;
	}

	public void setListBox(java.awt.List listBox) {
		this.listBox = listBox;
	}
	
	public void setVisible() {
		insertNamelb.setVisible(false);
		insertHplb.setVisible(false);
		insertEmaillb.setVisible(false);
		insertNametf.setVisible(false);
		insertHptf.setVisible(false);
		insertEmailtf.setVisible(false);
		insertInsertbtn.setVisible(false);
		
		listBox.setVisible(false);
		
		viewIdlb.setVisible(false);
		viewNamelb.setVisible(false);
		viewHplb.setVisible(false);
		viewEmaillb.setVisible(false);
		
		updateNamelb.setVisible(false);
		updateSearchNametf.setVisible(false);
		updateSearchbtn.setVisible(false);
		updateSearchListBox.setVisible(false);
		
		updateNamelb2.setVisible(false);
		updateNametf.setVisible(false);
		updatebtn.setVisible(false);
		updateSearchListBox2.setVisible(false);

		
		
	}
	
}
