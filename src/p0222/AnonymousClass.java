package p0222;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnonymousClass {
  public static void main(String[] args) {
    Frame f = new Frame(); // window 창 띄우기
    f.setLayout(new BorderLayout());
    Button b = new Button("button");
    // addActionListner(리스너객체) : 뷰 객체에 리스너를 연결하는 메서드
    b.addActionListener(new ActionListener() {
      // 핸들러
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("button click");
      }
    });
    f.add(b);
    f.setSize(300, 300);
    f.setVisible(true);
  }
}
