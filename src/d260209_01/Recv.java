package d260209_01;

import java.awt.Button;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Map;

public class Recv extends Thread{
	private Map<String, Socket> map;
	private String key;
	private Button btn;
	
	public Recv(Map<String, Socket> map, String key,Button btn) {
		this.map=map;
		this.key=key;
		this.btn=btn;
	}
	
	@Override
	public void run() {
		//클라이언트의 소켓을 확인하고 제거하는 역할
		//수신은 무한 반복, 별도의 소켓에서 소켓이 끊어지면 해당 쓰레드는 자동종료되게 처리
		//두 가지 상황에서 소켓이 종료됨(1)퇴실버튼을 눌렀을 때 2)소켓이 끊어 졌을 때)
		while(true) {
			try {
				BufferedReader in
				=new BufferedReader(
						new InputStreamReader(map.get(key).getInputStream()));
				String data=in.readLine();
				System.out.println(data);
				if(data.equals("퇴실")) {
					map.remove(key);
					//System.out.println(map.size());
					btn.setBackground(Color.RED);
					break;
				}
			}
			catch (Exception e) {
				System.out.println("소켓 오류");
				map.remove(key);
				System.out.println(map.size()); //소켓오류시 맵의 갯수
				break;
			}
		}
		//System.out.println(map.size()); //소켓이 종료된 후 맵의 갯수
	}
	

}