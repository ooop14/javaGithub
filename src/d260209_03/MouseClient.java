package d260209_03;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicReference;

public class MouseClient {
	//static AtomicReference<Socket> socketRef = new AtomicReference<>();
	static Socket socket;
	static ObjectOutputStream oos;
//프레임을 만들고 현재의 좌표 x,y를 구해서 서버에 소켓으로 x,y를 묶은 값인 Point를 보내고
//서버에서 보낸 Point객체를 받은 후 x,y값을 화면에 출력하는 코드를 작성하시오.
	public static void main(String[] args) {
		//프레임 만들고 설정
		Frame f=new Frame();
		f.setBounds(0,0,800,600);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
		f.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				//System.out.print("x:"+e.getX()+",");
				//System.out.println("y:"+e.getY());
				//프레임의 x,y값을 구하기
				Point p=new Point();				
				//Point객체에 x,y값 담기
				p.x=e.getX();
				p.y=e.getY();
				//Point객체를 소켓으로 보내기
				//소켓의 outputstream을 이용하여 객체 p를 전송하는 쓰레드 생성
				
				new Thread(() -> {
					try {						
						/*
						아래의 코드는 jsp에서 문자열을 쓰기 위해 자주 사용하는 객체
				        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				        out.println(x + "," + y);
				        */
						
						//ObjectOutputStream oos	=new ObjectOutputStream(socketRef.get().getOutputStream());
						System.out.println(p.x);
						System.out.println(p.y);
						oos.writeObject(p);
						oos.flush();
						Thread.sleep(100);
						
				    } catch (Exception ee) {
				    	System.out.println("클라이언트 프로그램 보내기 오류!");
				        //ee.printStackTrace();
				    }
                }).start();
				
			}
		});
		
		//Socket socket=null;
		//서버에 접속
		//try(Socket socket=new Socket("172.16.15.97","1234")){
		try {
		//Socket socket=new Socket("172.16.15.97",1234);
			socket=new Socket("172.16.15.91",1234);
			oos=new ObjectOutputStream(socket.getOutputStream());
			//socketRef.set(socket);
			//클라이언트에서는 보내기만 하고 수신받을 필요가 없는 경우
			//while 반복문은 필요없음
			
			/*
			 * while(true) { Thread.sleep(100); }
			 */
			
			//try()안에 socket이 있으면 자동관리 대상이므로 socket close되므로 try()는 부적합
			//try내부에서 Socket이 존재하면 프레임 리스너에서 사용이 불가함
		}catch (Exception e) {
			System.out.println("클라이언트 프로그램 반복처리 부분!");
			//e.getStackTrace();
		}
		
		

	}

}