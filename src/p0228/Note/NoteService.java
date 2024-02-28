package p0228.Note;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class NoteService {
  private String path = "src/p0227/files/memo/"; // 메모 파일들이 저장될 디렉토리 경로
  private File dir;

  public NoteService(){ // 디렉토리 없으면 생성
    dir = new File(path);
    if(!dir.exists()){
      dir.mkdir();
    }
  }

//  public void readNote(Scanner sc) { // 내가 작성한 코드
//    File dir = new File(path);
//    System.out.println("=== 파일 목록 ===");
//    String[] files = dir.list();
//    if (files.length == 0) {
//      System.out.println("파일 없음.");
//    } else {
//      for (String fn : files) {
//        System.out.println(fn);
//      }
//      System.out.println("=================");
//    }
//    System.out.print("읽을 파일 입력 : ");
//    String f = sc.next();
//    String pf = path + f;
//    File rf = new File(pf);
//    if (rf.exists()) {
//      try {
//        System.out.println(Files.readString(Paths.get(pf)));
//      } catch (IOException e) {
//        e.printStackTrace();
//      }
//    } else {
//      System.out.println("없는 파일명 입니다.");
//    }
//  }

  /**
   * memofiles 디렉토리의 파일 목록을 출력하고 사용자가 선택한 파일명을 반환
   */
  public String fileList(Scanner sc){
    String[] files = dir.list(); // list() : 파일목록
    System.out.println("메모 목록");
    for(int i = 0; i < files.length; i++){
      System.out.println(i + ". " + files[i]);
    }
    System.out.println("원하는 파일 번호 입력");
    int idx = sc.nextInt();
    if(idx<0 || idx>files.length){ // 입력 필터
      System.out.println("!!! wrong num !!!");
      return null;
    }
    return files[idx];
  }

//  public void writeNote(Scanner sc) throws IOException {
//    System.out.print("작업할 파일명 : ");
//    String work = sc.next();
//    String pf = path + work;
//    File wf = new File(pf);
//    if (wf.exists()) {
//      System.out.println("동일한 파일명이 있습니다.");
//      System.out.println("1.다시 입력  2.이어쓰기  3.덮어쓰기");
//      int m = sc.nextInt();
//      switch (m) {
//        case 1:
//          System.out.println("다시 입력하기");
//          writeNote(sc);
//          break;
//        case 2:
//          System.out.println("이어쓰기. (작업종료 : /stop)");
//          FileWriter fw = new FileWriter(pf, true);
//          while (true) {
//            String txt = sc.next();
//            fw.write(txt);
//            if (txt.equals("/stop")) {
//              fw.close();
//              break;
//            }
//          }
//          break;
//        case 3:
//          System.out.println("덮어쓰기. (작업종료 : /stop)");
//          FileWriter fw2 = new FileWriter(pf);
//          while (true) {
//            String txt = sc.next();
//            fw2.write(txt);
//            if (txt.equals("/stop")) {
//              fw2.close();
//              break;
//            }
//            break;
//          }
//      }
//    }else{
//      FileWriter fw3 = new FileWriter(pf);
//      while (true) {
//        String txt = sc.next();
//        fw3.write(txt);
//        if (txt.equals("/stop")) {
//          fw3.close();
//          break;
//        }
//        break;
//      }
//    }
//  }

  public void fileRead(Scanner sc){
    System.out.println("=== 메모 읽기 ===");
    String fname = fileList(sc);
    if(fname == null){
      System.out.println("없는 파일");
    }else {
      try {
        FileReader fr = new FileReader(path+fname);
        int ch;
        while ((ch=fr.read())!=-1){
          System.out.print((char)ch);
        }
        fr.close();
        System.out.println();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public String[] inputFileName(Scanner sc){
    String[] names = new String[2];
    String[] files = dir.list();
    int m;
    String fname;
    boolean flag;
    names[1] = "n"; // n:새파일, a:이어쓰기, t:덮어쓰기
    do {
      flag = false;
      System.out.println("파일명 : ");
      fname = sc.next();

      for (String s : files) {
        if (fname.equals(s)) {
          System.out.println("동일한 이름이 있음\n" +
              "1.재입력  2.이어쓰기  3.덮어쓰기");
          m = sc.nextInt();
          if(m==2){
            names[1] = "a";
          }else if(m==3){
            names[1] = "t";
          }else{
            flag = true;
          }
          break;
        }
      }
    }while (flag);
    names[0] = fname;
    return names;
  }

  public void fileWriter(Scanner sc){
    System.out.println("=== 메모 쓰기 ===");
    String[] arr = inputFileName(sc); // arr[0]: 파일명, arr[1]: 쓰기모드
    boolean flag = false; // 쓰기모드. true : 이어쓰기
    if(arr[1].equals("a")){
      flag = true;
    }
    try {
      FileWriter fw = new FileWriter(path+arr[0], flag);
      System.out.println("파일 내용을 입력하시오. (/stop = 정지)");
      while (true){
        String str = sc.nextLine();
        if(str.startsWith("/stop")){
          break;
        }
        fw.write(str + "\n");
      }
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void fileDel(Scanner sc){
    System.out.println("=== 메모 삭제 ===");
    String fname = fileList(sc);
    if(fname == null){
      System.out.println("삭제 취소");
    } else {
      File delf = new File(path+fname);
      delf.delete();
    }
  }
}