package d260210_01;

public class ThreadMain1 {
	//변수 하나를 사용하기 위해서 별도의 클래스 파일을 만들고 클래스 파일안의 함수를 이용하여 변수를 제어
	public static void main(String[] args) throws InterruptedException {
		//2개의 객체를 만들고 add함수를 이용하여 동작시킨다고 가정할 떄
		/*
		Counter c1 = new Counter();
		Counter c2 = new Counter();
		c1.add();
		c2.add();
		System.out.println("c1:"+c1.getCnt());
		System.out.println("c2:"+c2.getCnt());
		*/

		//위의 코드는 순차적으로 실행되는 코드(동기화)
		
		//위의 코드를 비동기화 시키기 위한 코드(비순차적)
		Counter c = new Counter();
		Thread t1 = new Thread(()->c.add());
		Thread t2 = new Thread(()->c.add());
		//하나의 객체로 2개의 작업중
		
		t1.start();
		t2.start();
		
		//join함수 = 너끝날떄까지 나 잠깐 멈춘다.(main함수에서 사용)
		t1.join();
		t2.join();
	}
	
}

class Counter{
	int cnt = 0;
	public void add() {
		for(int i=0;i<10;i++) {
		cnt++;
		System.out.println(cnt);
		}
	}
	public int getCnt() {
		return cnt;
	}
}
