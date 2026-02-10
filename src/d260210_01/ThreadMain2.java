package d260210_01;

//join함수는 실행된 쓰레드가 끝나기까지 기다리는 함수
public class ThreadMain2 {
	//변수 하나를 사용하기 위해서 별도의 클래스 파일을 만들고 클래스 파일안의 함수를 이용하여 변수를 제어
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(()->{
			try {
				Thread.sleep(1000);
				System.out.println("작업 스레드 끝");
			} catch (Exception e) {
				//System.out.println("작업 스레드 끝");
			}
		});
		
		t.start();
		//t.join();
		System.out.println("main함수 끝");
	}
	
}
