package d260210_02;

import java.io.Serializable;

public class Packet implements Serializable{
	
	private static final long serialVersionUID = -5553933373853292692L;
	//어떤 패킷? 채팅 프로그램에서 이용할 패킷을 만들예쩡
	//로그인, 메시지 보내기 기능
	//로그인과 메시지에서 사용할 멤버변수를 정의
	final static int LOGIN = 1;
	final static int MESSAGE = 2;
	final static int LOGIN_STATE = 3;
	
	//어떤 종류의 프로토콜인가를 정의
	protected int protocolType; //로그인인지 메시지인지 확인하는 요소
	private byte[] packet; //보낼 데이터를 바이트로 전송
	
	//임시적으로 데이터를 담을 공간, 2개 타입의 변수를 모두 정의
	String id;
	String password;
	String message;
	String result;
	
	//get set함수 정의
	public int getProtocolType() {
		return protocolType;
	}
	public void setProtocolType(int protocolType) {
		this.protocolType = protocolType;
	}
	public byte[] getPacket() {
		return packet;
	}
	public void setPacket(byte[] packet) {
		this.packet = packet;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	
}
