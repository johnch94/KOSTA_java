package p0304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// 클라이언트 1명을 담당.
// 담당 클라이언트가 보낸 메시지를 되돌려보냄
class EchoThread extends Thread {
  private Socket socket;

  public EchoThread(Socket socket){
    this.socket = socket;
  }
  @Override
  public void run(){
    System.out.println("클라이언트 접속");
    try {
      // 소켓에서 데이터 읽을 수 있는 스트림 생성
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      // 소켓 출력 스트림 생성
      PrintWriter pw = new PrintWriter(socket.getOutputStream());

      while (true){
        // 클라이언트 메시지 한줄 읽음. 읽을 데이터가 있을 때 까지 대기
        String str = in.readLine();
        System.out.println("클라이언트가 보낸 메시지 : " + str);
        if(str.startsWith("/stop")){
          break;
        }
        // 소켓에 출력. 상대방에 메시지 전송
        pw.println(str);
        // 버퍼에 있는 데이터를 강제 출력하여 비움
        pw.flush();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
public class EchoTcpServer {
  public static void main(String[] args) {
    try {
      // 서버 소켓 오픈
      ServerSocket ss = new ServerSocket(4444);

      System.out.println("서버 시작");
      while (true){
        // 클라이언트 접속 대기. 접속 수락 => socket 반환
        Socket socket = ss.accept(); // socket : 클라이언트와 통신하는 소켓
        EchoThread th = new EchoThread(socket);
        th.start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
