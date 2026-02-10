package d260206;

public class Main3 {

	public static void main(String[] args) {
		//Runnable로 구현된 클래스를 Thread객체에 넣어서 처리
		Thread tc1=new Thread(new ThreadClass3("first", 10));
		Thread tc2=new Thread(new ThreadClass3("second", 10));
		Thread tc3=new Thread(new ThreadClass3("third", 10));
		tc1.start();
		tc2.start();
		tc3.start();		
		//언제쓰레드를 사용하는가?
		/*
		 파일업로드하면서 챗팅 송신, 수신(Q.쓰레드를 몇개 돌아가는 것일까요? 3개, 파입업로드, 송신, 수신 작업단위)
		 1:1챗팅을 쓰레드로 구현
		 다대챗팅을 쓰레드로 구현
		 */
	}

}

//쓰레드 클래스를 만드는 방법2
//Thread 클래스를 상속하는 대신에 Runnable 인터페이스 run함수를 구현
//아직은 Thread로 구현되지 않은 상태임
class ThreadClass3 implements Runnable{
	private String name;//인스턴스의 이름
	private int end; //반복횟수
	
	public ThreadClass3(String name, int end) {
		this.name=name;
		this.end=end;
	}
	@Override
	public void run() {
		for(int i=0;i<end;i++) {
			System.out.println(name+":"+i);
		}
	}		
}




