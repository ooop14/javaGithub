package d260210_01;

import java.util.Iterator;

//synchronized 에서 쓰레드를 대기(wait)하고 다시 시작하는(notify) 코드
public class ThreadMain5 {
	
	public static void main(String[] args) throws InterruptedException {
		//일반적으로 객체 생성시
		Work2 work1 = new Work2();
		//work2를 runable로 구현하고 싶은 경우
		//아래와 같이 구현이 되지 않은 경우 익명 함수로 구현할 함수를 재정의 한다.
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
			}
		};
		//아래와 같이 일반 객체에 runable을 구현할 방법은 없으며
		//익명 또는 람다식을 이용하여 일반객체를 사용하게끔 구성해야 한다.
		//Runnable r2 = new Work4() {}
		//익명으로 구현
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				Work2 work2 = new Work2();
			}
		};
		
		//람다로 구현
		//() -> {} 함수형태
		Runnable r3 = () ->{
			Work2 work3 = new Work2();
		};
		
		//자주 사용하는 예시
		new Thread();
		new Thread().start();//thread가 정의되어 있지 않음
		new Thread(()->System.out.println("함수 1개 실행!!")).start();
		new Thread(()->{
			System.out.println("함수 2개 이상 실행");
			System.out.println("함수 2개 이상 실행");
		}).start();
		//aws에서 람다함수를 이용하여 서버리스 프로그램 작성
		
		//만약 람다함수에 입력값을 입력받고 싶은 경우
		//아래와 같이 정의 되지 않은 코드를 사용할 경우 입력값으로는 사용이 불가
		/*int a=10;int b=20;
		new Thread((a,b)->{System.out.println(a+b);}).start();*/
		//위와 같이 사용하려면 정의 되어 있어야 함
		//인터페이스를 만들어 사용
		AddTask task = (x,y) -> System.out.println(x + y); //구현되지 않은 함수를 구현하는 코드
		new Thread(() -> task.add(10,20)).start(); // 위에서 구현한 코드를 사용하는 함수
		
		
		
	}
}



class Work2 implements Runnable{
	@Override
	public void run() {
		
	}
}