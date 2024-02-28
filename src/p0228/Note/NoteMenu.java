package p0228.Note;

import java.io.IOException;
import java.util.Scanner;

public class NoteMenu {
  private NoteService service;

  NoteMenu(){
    service = new NoteService();
  }
  public void run(Scanner sc){

    boolean flag = true;

    while (flag) {
      System.out.println("1.read  2.write  3.delete  4.exit");
      int m = sc.nextInt();
      switch (m) {
       case 1:
         System.out.println("파일 읽기");
//         service.readNote(sc);
         service.fileRead(sc);
         break;
       case 2:
         System.out.println("파일 쓰기");
         service.fileWriter(sc);
//         try {
//           service.writeNote(sc);
//         } catch (IOException e) {
//           throw new RuntimeException(e);
//         }
         break;
       case 3:
         System.out.println("파일 삭제");
         service.fileDel(sc);
         break;
       case 4:
         System.out.println("종료");
         flag = false;
         break;
     }
   }
  }
}
