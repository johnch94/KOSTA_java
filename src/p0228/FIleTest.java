package p0228;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FIleTest {
  public static void main(String[] args) {
    File f = new File("src/p0227/files/alphabet");
    System.out.println("=== src/p0227/files/alphabet ===");
    System.out.println("파일 존재 여부 : " + f.exists());
    System.out.println("파일명 확인    : " + f.getName());
    System.out.println("파일 절대 경로 : " + f.getAbsolutePath());
    System.out.println("파일 크기      : " + f.length());
    System.out.println("파일 읽기 가능 여부 : " + f.canRead());
    System.out.println("파일 쓰기 가능 여부 : " + f.canWrite());
    System.out.println("파일 실행 가능 여부 : " + f.canExecute());
    System.out.println("파일 숨김 여부 : " + f.isHidden());
    System.out.println("디렉토리 인가? : " + f.isDirectory());
    System.out.println("파일인가?      : " + f.isFile());

    System.out.println("=== src/p0227/files ===");
    File dir = new File("src/p0227/files");
    System.out.println("파일 존재 여부 : " + dir.exists());
    System.out.println("디렉토리 인가? : " + dir.isDirectory());
    System.out.println("파일인가?      : " + dir.isFile());

    System.out.println("====== 파일목록 =======");
    String[] files = dir.list(); // 디렉토리에 있는 파일 목록을 배열로 가져옴
    for(String fn : files){
      System.out.println(fn);
    }
    System.out.println("=======================");

    File dir2 = new File("src/p0227/files/memo");
    if(!dir2.exists()){ // 존재하지 않으면
      dir2.mkdir(); // 디렉토리 생성
      System.out.println("memo 디렉토리가 생성되었습니다.");
    }

    File f2 = new File("src/p0227/files/memo/a.txt");
    try {
      if(!f2.exists()) {
        f2.createNewFile(); // 새 파일 생성
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      FileWriter fw = new FileWriter("src/p0227/files/memo/a.txt",true); // true 이어쓰기, false 새로쓰기, (default:false)
      fw.write("가나다라\n");
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    if(f2.exists()){
      f2.delete(); // 파일 삭제
    }
  }
}
