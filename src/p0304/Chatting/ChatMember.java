package p0304.Chatting;

// 유저 한명 담당 쓰레드
// 자기가 담당한 클라이언트가 보내는 메시지 받아서
// 전체 사용자에게 보냄
// 생성자에게 소켓받아옴
// 소켓 input, output 스트림 생성

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

// 무한루프 돌면서
public class ChatMember extends Thread{
  private Socket socket; // 담당하는 클라이언트 한명과 통신할 소켓
  private ChatServer room; // 채팅방
  private PrintWriter pw; // 소켓 출력 스트림
  private String id; // 채팅하는 사람의 id

  public ChatMember(Socket socket, ChatServer room) {
    this.socket = socket;
    this.room = room;
    InetAddress addr = socket.getInetAddress(); // getInetAddress() : 연결된 원격 컴퓨터의 주소
    id = addr.getHostAddress(); // ip를 String 타입으로 반환
  }

  @Override
  public void run() {
    System.out.println("클라이언트 접속");
    room.addMember(this); // 현재 객체를 채팅방에 추가
    try {
      // 소켓에서 데이터 읽을 수 있는 스트림 생성
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      // 소켓 출력 스트림 생성
      PrintWriter pw = new PrintWriter(socket.getOutputStream());
      String str = "[" + id +"] 님이 입장했습니다.";
      room.sendAllMsg(str);

      while (true){
        // 클라이언트 메시지 한줄 읽음. 읽을 데이터가 있을 때 까지 대기
        str = in.readLine();
        System.out.println("클라이언트가 보낸 메시지 : " + str);
        if(str.startsWith("/stop")){
          sendMsg(str);
          str = "[" + id +"] 님이 퇴장했습니다.";
          room.delMember(this);
          room.sendAllMsg(str);
          break;
        }
        room.sendAllMsg(str);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // 이 쓰레드가 담당하는 클라이언트 한명에게 msg 전송
  public void sendMsg(String msg){
    pw.println(msg);
    pw.flush();
  }
}
