package d260209_02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListMain {

	public static void main(String[] args) {
		//ArrayList,LinkedList,Vector
		//중복이 가능
		List<String> arraylist = new ArrayList<String>();
		arraylist.add("apple");
		arraylist.add("orange");
		arraylist.add("apple");
		arraylist.add("orange");
		System.out.println(arraylist);
		
		arraylist.set(0, "mangoapple");
		System.out.println(arraylist.get(0));
		
		//전체출력 -> foreach, for, iterator 가능
		//삭제 
		//arraylist.remove(0);
		
		List<String> linklist = new LinkedList<String>();
		linklist.add("apple");
		linklist.add("dpple");
		linklist.add("bpple");
		linklist.add("cpple");
		
		System.out.println(linklist);
		//arraylist와 차이점은 arraylist는 순차적으로 입력
		//linklist는 앞과 뒤에 추가
		linklist.addFirst("zeroapple");
		linklist.addLast("lastapple");
		System.out.println(linklist);
		
		//Vector : 방향(크기를 자동으로 조절)
		Vector v = new Vector<String>();
		String[] s = {"기획자","설계자","개발자"};
		//v.add(s);
		v.addElement(s[0]);
		v.addElement(s[1]);
		v.addElement(s[2]);
		
		if (v.contains("개발자")) {
			int i = v.indexOf("개발자");
			System.out.println(v.get(i));
		}
		v.addElement(s[0]);
		v.addElement(s[1]);
		v.addElement(s[2]);
		
		v.addElement(s[0]);
		v.addElement(s[1]);
		v.addElement(s[2]);
		
		v.addElement(s[0]);
		v.addElement(s[0]);//11개 입력 -> vector는 10개가 기본 사이즈이고 
		//11개가 입력 될 떄 사이즈는 20개로 늘어난다.
		
		System.out.println(v.capacity());
	}

}
