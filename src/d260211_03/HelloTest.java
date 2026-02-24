package d260211_03;
public class HelloTest {

	public boolean isPri(int a){
	  boolean isP=true ;
	  int b=(int)Math.sqrt(a); //50이면 2부터 7까지 
	  for(int i=2;i<=b;i++){
		if(a%i==0){      //(50,2) (50,3) (50,4) .....
			isP=false;
			break;       //for탈출
		}else isP=true;
	  }
	  return isP;
	 }
}