package d260209_03;

import java.io.Serializable;

//반드시 확인사항: 네트워크상에 객체를 보낼떄는 직렬화를 반드시 구현
public class Point implements Serializable{
	//직렬 전송시 반드시 필요
	private static final long serialVersionUID = 1;
	
	int x;
	int y;
	
	public Point() {
		
	}
	
	public Point(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
