package d260210_01;

import java.util.Iterator;

public class ThreadMain3 {
	//변수 하나를 사용하기 위해서 별도의 클래스 파일을 만들고 클래스 파일안의 함수를 이용하여 변수를 제어
	public static void main(String[] args) throws InterruptedException {
		
		//c2객체의 cnt변수는 add함수를 사용하면서 쓰레드가 변수를 공유하고 있는 형태
		//한번씩 사용하기를 원할 경우 자원을 나누어서 한번씩 사용해야 함
		//synchronized 자원을 공유하기 위함
		Counter2 c2 = new Counter2();
		Thread t1 = new Thread(()->c2.add());
		Thread t2 = new Thread(()->c2.add());
		//하나의 객체로 2개의 작업중
		
		t1.start();
		t2.start();
		
		//join함수 = 너끝날떄까지 나 잠깐 멈춘다.(main함수에서 사용)
		t1.join();
		t2.join();
	}
	
}

class Counter2{
	int cnt = 0;
	public synchronized void add() {
		for(int i=0;i<10;i++) {
		cnt++;
		System.out.println(cnt);
		}
		
	}
	public int getCnt() {
		return cnt;
	}
}
