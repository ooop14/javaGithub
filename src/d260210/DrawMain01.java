package d260210;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//마우스를 움직일 때 그림 그리기
public class DrawMain01 {

	public static void main(String[] args) {
		MouseFrame3 f=new MouseFrame3();
		f.addMouseMotionListener(f);
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}
class MouseFrame3 extends Frame implements MouseMotionListener{
	private int prex=-1;
	private int prey=-1;
	private int x;
	private int y;
	
public MouseFrame3() {
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
public void mouseMoved(MouseEvent e) {
	System.out.println(e.getX()+","+e.getY());
	x=e.getX(); y=e.getY();
	//repaint();
	//그래픽 객체를 얻은 후에 paint함수를 호출하지 않고 그려주는 방법
	//repaint()함수는 화면을 새로고침하는 역할을 하므로 이전 그림이 다 지워짐.
	Graphics g=getGraphics();
	g.drawLine(prex, prey, x, y);
	prex=x;
	prey=y;
	
}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}