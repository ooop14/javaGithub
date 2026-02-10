package d260210;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//마우스를 움직일 때 그림 그리기
//마우스를 클릭할 떄 만 선을 그리는 것이므로 마우스가 클릭 될 떄 최초 좌푯가 만들어지고
//클릭된 상태는 (드래그) 현재의 x,y좌표를 구해 선을 그리고 현재좌표를 이전좌표에 저장하는 구조
//해당코드를 이용하여 서버,클라이언트를 적용하여 원격에서 선을 그리는 코드를 작성하시오
public class DrawMain2 {

	public static void main(String[] args) {
		MouseFrame2 f=new MouseFrame2();
		f.addMouseMotionListener(f);
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}
//움직일때 : MouseMotionListener
//마우스가 동작할 떄 (클릭) : MouseListener
class MouseFrame2 extends Frame implements MouseMotionListener,MouseListener{
	private int prex=-1;
	private int prey=-1;
	private int x;
	private int y;
	
public MouseFrame2() {
	setBounds(0, 0,1000, 1000);
	setVisible(true);
}
	
//처음에 호출되고 repaint() 호출시 호출됨
@Override
	public void paint(Graphics g) {
	System.out.println("paint함수 호출");
		g.drawLine(prex, prey, x, y);
		prex=x;
		prey=y;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		prex = e.getX();
		prey = e.getY();
		System.out.println("prex:" + prex + "prey:" + prey);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		System.out.println("x:" + x + "y:" + y);
		Graphics g = getGraphics();
		g.drawLine(prex, prey, x, y);
		
		prex = x;
		prey = y;
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}