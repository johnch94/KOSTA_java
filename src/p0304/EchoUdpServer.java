package p0304;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class EchoUdpServer {
  public static void main(String[] args) {
    try {
      // udp용 소켓 생성
      DatagramSocket socket = new DatagramSocket(1234);
      System.out.println("서버 시작");

      byte[] buf = new byte[256];
      DatagramPacket dp = new DatagramPacket(buf, buf.length); // 빈 패킷 생성

      // 패킷 수신
      socket.receive(dp); // 상대방이 보낸 패킷 수신
      String data = new String(dp.getData());
      System.out.println("클라이언트 전송 data : " + data);

      InetAddress addr = dp.getAddress(); // DatagramPacket을 전송한 쪽이 주소 반환
      int port = dp.getPort(); // DatagramPacket을 전송한 쪽 포트번호 반환

      // 클라이언트로 전송할 데이터
      byte[] buf2 = ("Server Echo msg : " + data).getBytes();
      // 전송할 패킷 생성
      DatagramPacket dp2 = new DatagramPacket(buf2, buf.length); // 빈 패킷 생성



    } catch (SocketException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
