package p0214;

public class for문2 {
  public static void main(String[] args) {
    for(int i=0; i<2; i++){
      for(int j=0; j<3; j++){
        System.out.print("#");
      }
      System.out.println();
    }

    //구구단 2단부터 9단까지 세로
    for(int i=2;i<10;i++){
      System.out.println(i+" 단 ");
      for(int j=1; j<10; j++){
        System.out.println(j*i +" ");
      }
      System.out.println();
    }
    System.out.println();
    //구구단 2단부터 9단까지 가로
    for(int i=2;i<10;i++){
      System.out.print(i + " 단 => ");
      for(int j=1; j<10; j++){
        System.out.print(j*i + " ");
      }
      System.out.println();
    }

  }
}
