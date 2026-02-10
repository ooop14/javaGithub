package d260210_02;

import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class PacketServer3 {

    public static void main(String[] args) {
        System.out.println("### 서버 프로그램 실행 ###");

        try (ServerSocket server = new ServerSocket(1234)) {

            Socket socket = server.accept();
            System.out.println("클라이언트 접속 완료!");

            boolean loginSuccess = false;

            while (true) {
                byte[] data = new byte[1024];
                int len = socket.getInputStream().read(data);

                if (len == -1) {
                    System.out.println("클라이언트 연결 종료");
                    break;
                }

                int protocolType = data[0];

                switch (protocolType) {

                    // 로그인 패킷 처리
                    case Packet.LOGIN:
                        String id = new String(data, 1, 20, StandardCharsets.UTF_8).trim();
                        String pw = new String(data, 21, 20, StandardCharsets.UTF_8).trim();

                        System.out.println("로그인 요청: " + id + " / " + pw);

                        if (id.equals("admin") && pw.equals("1234")) {
                            loginSuccess = true;
                            System.out.println("로그인 성공!");
                        } else {
                            loginSuccess = false;
                            System.out.println("로그인 실패!");
                        }

                        // 로그인 결과 패킷 만들기
                        byte[] loginStatePacket = new byte[1024];
                        loginStatePacket[0] = (byte) Packet.LOGIN_STATE;

                        String result = loginSuccess ? "SUCCESS" : "FAIL";
                        byte[] resultBytes = result.getBytes(StandardCharsets.UTF_8);

                        System.arraycopy(resultBytes, 0, loginStatePacket, 1, resultBytes.length);

                        socket.getOutputStream().write(loginStatePacket);
                        socket.getOutputStream().flush();

                        break;

                    // 메시지 패킷 처리
                    case Packet.MESSAGE:

                        if (!loginSuccess) {
                            System.out.println("로그인 안한 사용자의 메시지 요청 -> 차단");
                            break;
                        }

                        String msg = new String(data, 1, len - 1, StandardCharsets.UTF_8).trim();
                        System.out.println("메시지 수신: " + msg);

                        break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
