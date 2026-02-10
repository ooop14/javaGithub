package d260210_01;

//어노테이션 추가
@FunctionalInterface
public interface AddTask {
public void add(int a,int b);//두수를 입력받는 함수, 리턴이 없는 함수
//public void callname(String name);	//functioninterface는 2개의 함수를 가질 수 없음
}
