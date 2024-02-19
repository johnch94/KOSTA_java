package p0214;

public class Switch문 {
  public static void main(String[] args) {

    int a = 2;
    switch (a){
      case 1:
        System.out.println("a는 1");
        break;
      case 2:
        System.out.println("a는 2");
        break;
      case 3:
        System.out.println("a는 3");
        break;
      default:
        System.out.println("a는 1-3 범위에 있지 않다");
        break;
    }

    String str = "ccc";
    switch (str){
      case "aaa":
        System.out.println("a는 1");
        break;
      case "bbb":
        System.out.println("a는 2");
        break;
      case "ccc":
        System.out.println("a는 3");
        break;
      default:
        System.out.println("a는 1-3 범위에 있지 않다");
        break;
    }

  }
}
