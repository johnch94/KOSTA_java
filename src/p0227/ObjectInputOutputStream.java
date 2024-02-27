package p0227;

import java.io.*;

/**
 * ObjectInputStream / ObjectOutputStream
 * 이 스트림을 읽고 쓰기의 대상 객체는 직렬화 처리 되어야 한다.
 */
class Person{
  private String name;
  private int age;
  public Person(){}
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }
  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}

public class ObjectInputOutputStream {
  public static void main(String[] args) {
    Person p1 = new Person("ju",18);

    try {
      ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("src/p0227/files/d.dat"));
      oo.writeObject(p1);
      oo.close();

      ObjectInputStream oi = new ObjectInputStream(new FileInputStream("src/p0227/files/d.dat"));
      Person p2 = (Person) oi.readObject();
      System.out.println(p2);
      oi.close();
    } catch (FileNotFoundException e){
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
