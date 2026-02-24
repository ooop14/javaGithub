package d260211;

//작업의 단위를 객체로 생각하라
//작업은 함수를 실행해서 처리를 하지만 객체가 없으면 함수도 존재하지 않음.
//작업을 실행했을 때 작업과 함꼐 동반되는 동반되는 작업(리스너)
public class ListenerMain {
	public static void main(String[] args) {
		/*
		MyWork mywork = new MyWork();
		mywork.work();
		*/
		//위의 코드 실행하면 나의 작업만 실행이 됨
		//추가적으로 나의 작업 실행이 된 후 다른 작업을 추가하고 싶은 경우 리스너를 등록하여 처리
		MyWork mywork = new MyWork();
		mywork.addMyListener(new MyListener() {
			
			@Override
			public void onEvent() {
				System.out.println("마이작업 후 추가적인 작업 등록 실행!!");				
			}
		});
		mywork.work();
	}

}
