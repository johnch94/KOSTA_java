package p0304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoTcpClient {
  public static void main(String[] args) {
    // 소켓 생성
    try {
      Socket socket = new Socket("localhost",4444);

      // 소켓에서 데이터 읽을 수 있는 스트림 생성
      // socket.getInputStrema() : 소켓에서 바이트값 읽는 스트림 반환
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      // 소켓 출력 스트림 생성
      // socket.getOutputStream() : 소켓에 바이트 출력하는 스트림 반환
      PrintWriter pw = new PrintWriter(socket.getOutputStream());

      String str = "hello tcp";
      // 메시지 서버로 전송
      pw.println(str);
      pw.flush();

      str = in.readLine();
      System.out.println("서버 에코 메시지 : " + str);

      socket.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
