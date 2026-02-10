package d260206;
//일반적인 프로그램은 순서에 의해서 프로그램이 실행 됨.
//main함수는 하나의 쓰레드(작업)이다.
//main함수는 쓰레드이지만 run함수에 구현되어 있지 않고 start함수도 호출되지 않는다.
public class Main1 {

	public static void main(String[] args) {
		//쓰레드로 구현한 클래스가 맨 마지막에 있으면 main을 실행한 후 Thread Class가 실행되므로 순차적으로 보이지만
		//앞쪽에 위치하면 작업은 백그라운드에 돌아가고 main과 함께 실행되는 구조
		new ThreadClass().start();
		
		for(int i=0;i<100;i++) {
			System.out.println("main:"+i);
		}
		new GenClass().start();
		
	}
}
//아래의 클래스는 thread를 구현하기 위한 모든 함수가 존재하지만 쓰레드로 구현된 클래스가 아니다.
class GenClass{
	public void start() {
		run();
	}
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("일반적인 클래스실행함수(gen):"+i);
		}
	}
}

//쓰레드 클래스 생성
//쓰레드를 만들기 위해서는 Thread를 상속하는 방법이 있음(방법1)
//thread클래스를 구현할 때 run만 구현하고 시작은 start로 한다.
class ThreadClass extends Thread{
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("thread class:"+i);
		}
	}
}



