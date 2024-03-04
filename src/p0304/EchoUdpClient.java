package p0304;

import java.io.IOException;
import java.net.*;

public class EchoUdpClient {
  public static void main(String[] args) {
    try {
      // udp용 소켓 생성
      DatagramSocket socket = new DatagramSocket();

      // 전송할 데이터
      byte[] buf = "hello udp".getBytes();

      // getByName("호스트네임") : 호스트네임 주소로 변환해서 반환
      InetAddress addr= InetAddress.getByName("localhost");

      DatagramPacket dp = new DatagramPacket(buf, buf.length, addr, 1234);

      socket.send(dp);

      // 수신용 데이터그램 패킷 생성
      byte[] buf2 = new byte[256];
      DatagramPacket dp2 = new DatagramPacket(buf2, buf2.length);

      socket.receive(dp2);

      byte[] data = dp2.getData();
      String str = new String(data);
      System.out.println(str);

      socket.close();

    } catch (SocketException e) {
      e.printStackTrace();
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
