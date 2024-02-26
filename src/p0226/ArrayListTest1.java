package p0226;

import java.util.ArrayList;
import java.util.Calendar;

public class ArrayListTest1 {
  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    list.add("aaa");
    list.add(1);
    list.add(new ArrayListTest1());
    list.add(Calendar.getInstance());

    for(Object o : list){
      System.out.println(o);
    }
  }
}
