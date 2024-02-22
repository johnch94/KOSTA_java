package p0221;

import java.util.Scanner;

class Item{
  String name;
  int price;
}
class Tv extends Item{
  public Tv(){
    name = "tv";
    price = 100;
  }
}
class Audio extends Item{
  public Audio(){
    name = "Audio";
    price = 200;
  }
}
class Computer extends Item{
  public Computer(){
    name = "Computer";
    price = 300;
  }
}
class Buyer {
  int point = 0;
  int money = 1000;

  public  void buy(Item p){
    if(money >= p.price){
      System.out.println(p.name + " 구매");
      money -= p.price;
      point += p.price;
      System.out.println("잔액 : " + money + "/" + "포인트 : " + point);
    }else {
      System.out.println("잔액 부족.");
    }
  }
}
public class ProductMain {
  public static void main(String[] args) {
    Buyer b = new Buyer();
    Item i[] = {new Tv(), new Audio(), new Computer()};
    boolean flag = true;
    Scanner sc = new Scanner(System.in);

    while (flag){
      System.out.println("구매할 상품을 고르시오.");
      System.out.println("1.Tv 2.Audio 3.Computer");

      int a = sc.nextInt();
      switch (a){
        case 1:
          b.buy(i[a-1]);
          break;
        case 2:
          b.buy(i[a-1]);
          break;
        case 3:
          b.buy(i[a-1]);
          break;
        default:
          System.out.println("없는 상품");
          break;
      }

      if(b.money==0){
        System.out.println("돈이 없습니다.");
        break;
      }
    }
  }
}
