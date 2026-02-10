package d260210_02;

import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PacketClient3 {

    public static void main(String[] args) {
        System.out.println("### 클라이언트 프로그램 실행 ###");

        try (Socket socket = new Socket("172.16.15.91", 1234);Scanner sc = new Scanner(System.in)) {

            boolean loginSuccess = false;

            while (!loginSuccess) {

                System.out.print("ID 입력: ");
                String id = sc.nextLine();

                System.out.print("PW 입력: ");
                String pw = sc.nextLine();

                // 로그인 패킷 생성
                Packet packet = new Packet();
                packet.setProtocolType(Packet.LOGIN);
                packet.setId(id);
                packet.setPassword(pw);

                byte[] data = new byte[1024];
                data[0] = (byte) packet.getProtocolType();

                byte[] idBytes = packet.getId().getBytes(StandardCharsets.UTF_8);
                byte[] pwBytes = packet.getPassword().getBytes(StandardCharsets.UTF_8);

                System.arraycopy(idBytes, 0, data, 1, Math.min(idBytes.length, 20));
                System.arraycopy(pwBytes, 0, data, 21, Math.min(pwBytes.length, 20));

                // 서버로 전송
                socket.getOutputStream().write(data);
                socket.getOutputStream().flush();

                // 로그인 결과 패킷 받기
                byte[] recv = new byte[1024];
                int len = socket.getInputStream().read(recv);

                if (len == -1) {
                    System.out.println("서버 연결 종료됨");
                    break;
                }

                if (recv[0] == Packet.LOGIN_STATE) {
                    String result = new String(recv, 1, len - 1, StandardCharsets.UTF_8).trim();

                    if (result.equals("SUCCESS")) {
                        System.out.println("로그인 성공!");
                        loginSuccess = true;
                    } else {
                        System.out.println("로그인 실패! 다시 입력하세요.");
                    }
                }
            }

            // 로그인 성공 후 메시지 보내기
            while (loginSuccess) {
                System.out.print("메시지 입력(exit 입력시 종료): ");
                String msg = sc.nextLine();

                if (msg.equalsIgnoreCase("exit")) {
                    System.out.println("클라이언트 종료");
                    break;
                }

                Packet packet = new Packet();
                packet.setProtocolType(Packet.MESSAGE);
                packet.setMessage(msg);

                byte[] data = new byte[1024];
                data[0] = (byte) packet.getProtocolType();

                byte[] msgBytes = packet.getMessage().getBytes(StandardCharsets.UTF_8);
                System.arraycopy(msgBytes, 0, data, 1, msgBytes.length);

                socket.getOutputStream().write(data);
                socket.getOutputStream().flush();

                System.out.println("메시지 전송 완료!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
