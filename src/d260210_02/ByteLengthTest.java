package d260210_02;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ByteLengthTest {

	public static void main(String[] args) {
		byte[] data = new byte[1024];
		System.out.println("data변수의 전체크기: "+ data.length);
		byte[] imsi = "hello".getBytes(StandardCharsets.UTF_8);
		System.out.println("imsi변수의 전체크기:" + imsi.length);
		System.arraycopy(imsi, 0, data, 0, imsi.length);
		System.out.println("data변수의 전체크기: "+ data.length);
		System.out.println(Arrays.toString(data));	//바이트로 된 데이터가 나타남
		//data변수 자체의 함수에서는 들어있는 데이터으 크기를 구할 방법은 없음
		int cnt=0;
		for (byte b:data) {
			if(b!=0) {
				cnt++;
			}
		}
		System.out.println("data 변수안에 들어 있는데이터 크기:" + cnt);
		cnt = 0;
		for (byte b:data) {
			if(b==0) {
				break;
			}
			cnt++;
		}
		System.out.println("data 변수안에 들어 있는데이터 크기:" + cnt);
		
		cnt =(int)IntStream
		.range(0, data.length)
		.filter(i -> data[i] != 0)	//데이터 값이 0이 아닐 떄 통과시킴
		.count();
		
		System.out.println("data 변수안에 들어 있는데이터 크기:" + cnt);
		
		byte[] data2 = {'a','b','c'};
		System.out.println("data2 변수:" + data2.length);
		
		byte[] data3 = new byte[1024];
		byte[] data4;
		System.arraycopy(new String("abc").getBytes(), 0, data3, 0, 3);
		System.out.println(Arrays.toString(data3));
		System.out.println("data3 변수:" + data3.length);
		
		data4 = Arrays.copyOf(data3, 3);
		System.out.println(Arrays.toString(data4));
		System.out.println("data4 변수:" + data4.length);
		
		System.out.println("hello".length());
		byte[] data5 ="hello".getBytes();
		System.out.println(data5.length);
		
		System.out.println("안녕하세요".length());
		byte[] data6 ="안녕하세요".getBytes();
		System.out.println(data6.length);
	}

}
