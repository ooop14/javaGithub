package d260206;

public class Main2 {

	public static void main(String[] args) {
		//thread 클래스가 아니므로 순차적으로 실행 
		/*
		GeneratorClass gc1=new GeneratorClass("first", 10);
		GeneratorClass gc2=new GeneratorClass("second", 10);
		GeneratorClass gc3=new GeneratorClass("third", 10);
		gc1.start();
		gc2.start();
		gc3.start();
		*/
		
		//thread 클래스이므로 순차적으로 실행 안됨 
		
		ThreadClass2 tc1=new ThreadClass2("first", 10);
		ThreadClass2 tc2=new ThreadClass2("second", 10);
		ThreadClass2 tc3=new ThreadClass2("third", 10);
		tc1.start();
		tc2.start();
		tc3.start();
		
		
	}

}

//이름을 입력하고 반복횟수를 입력해서 객체를 생성하면 반복횟수만큼 해당 인스턴스가 출력됨.
class GeneratorClass{
	private String name;//인스턴스의 이름
	private int end; //반복횟수
	
	public GeneratorClass(String name, int end) {
		this.name=name;
		this.end=end;
	}
	
	public void start() {
		run();
	}
	
	public void run() {
		for(int i=0;i<end;i++) {
			System.out.println(name+":"+i);
		}
	}	
}

class ThreadClass2 extends Thread{
	private String name;//인스턴스의 이름
	private int end; //반복횟수
	
	public ThreadClass2(String name, int end) {
		this.name=name;
		this.end=end;
	}
	
	public void run() {
		for(int i=0;i<end;i++) {
			System.out.println(name+":"+i);
		}
	}	
}




