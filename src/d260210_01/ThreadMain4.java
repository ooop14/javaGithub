package d260210_01;

import java.util.Iterator;

//synchronized 에서 쓰레드를 대기(wait)하고 다시 시작하는(notify) 코드
public class ThreadMain4 {
	
	public static void main(String[] args) throws InterruptedException {
		//아래의 코드를 실행하면 waitWork()함수가 실행된 후 doWork()함수가 실행되는 구조
		//synchronized가 있을 경우와 없을 경우의 값을 확인
		Work work = new Work();
		new Thread(()->work.doWork()).start();
		
		work.waitWork();
	}
	
}
//work는 현재는 쓰레드를 상속받은 객체가 아니다.
class Work{
	boolean done = false;
	
	//작업 하는 함수
	public synchronized void doWork() {
		System.out.println("dowork실행!");
		System.out.println("작업시작");
		try {Thread.sleep(1000);}catch(Exception e) {}
		done = true;
		notify();//작업을 계속 진행, 대기상태의 쓰레드를 깨워주는 역할 wait은 쓰레드를 대기 상태로 진입
		System.out.println("작업종료");
	}
	//작업을 멈추는 함수
	public synchronized void waitWork() {
		System.out.println("waitwork실행!");
		while(!done) {
			try {wait();} catch (Exception e) {}
		}
		System.out.println("메인스레드 계속 진행");
	}
}
