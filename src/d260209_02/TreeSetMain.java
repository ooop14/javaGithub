package d260209_02;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetMain {

	public static void main(String[] args) {
		//treeset은 나뭇가지이며 중복이 되지 않는다.
		//순차적으로 자동정렬이 된다.
		Set<Integer> set = new TreeSet<Integer>();
		set.add(5);
		set.add(1);
		set.add(3);
		set.add(2);
		set.add(4);
		System.out.println(set);
		
		Set<String> set2 = new TreeSet<String>();
		set2.add("c");
		set2.add("e");
		set2.add("a");
		set2.add("b");
		System.out.println(set2);
		System.out.println(set2.size());

	}

}
