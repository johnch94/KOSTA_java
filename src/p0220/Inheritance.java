package p0220;
class Parent{
  String name;
  int age;

  Parent() {
    System.out.println("parent 생성자");
  }
  void parentMethod() {
    System.out.println("parentMethod 생성자");
    System.out.println("name : " + name);
    System.out.println("age : " + age);
  }
}
class Child extends Parent {
  String hobby;

  Child(){
    System.out.println("Child 생성자");
  }
  void childMethod(){
    System.out.println("childMethod 생성자");
    System.out.println("name : " + name);
    System.out.println("age : " + age);
    System.out.println("hobby : " + hobby);
  }
}
public class Inheritance {
  public static void main(String[] args) {
    Parent p = new Parent();
    Child c = new Child();

    p.age = 34;
    p.name = "parent";

    c.age = 1;
    c.name = "child";
    c.hobby = "eat";

    p.parentMethod();
    c.parentMethod();
    c.childMethod();
  }
}
