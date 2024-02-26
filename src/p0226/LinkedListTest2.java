package p0226;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LinkedListTest2 {
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>(); // queue 로 사용됨

    list.add(1);
    list.add(2);
    list.add(3);
    for (int i : list){
      System.out.println(i);
    }

    while(list.size() > 0){
      System.out.println(list.poll()); // poll(): queue 에서 데이터 추출
      System.out.println("List size : " + list.size());
    }

    System.out.println("===============================");
    Stack<Integer> st = new Stack<>(); // stack 구조를 사용함
    st.add(1);
    st.add(2);
    st.add(3);
    while (st.size()>0){
      System.out.println(st.pop());
      System.out.println("Stack size : " + st.size());
    }

  }
}
