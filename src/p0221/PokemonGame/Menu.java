package p0221.PokemonGame;

import java.util.Scanner;

public class Menu {
  private Pokemon p;

  public void select(Scanner sc){
    System.out.println("==============================");
    System.out.println("포켓몬을 선택하세요.");
    System.out.println("1. 피카츄(기본)");
    System.out.println("2. 이상해씨");
    System.out.println("3. 꼬북이");
    System.out.println("===============================");
    int x = sc.nextInt();

    switch (x){
      case 1:
        p = new Pikachu();
        break;
      case 2:
        p = new Yeesanghae();
        break;
      case 3:
        p = new Ggobuk();
        break;
      default:
        p = new Pikachu();
        break;
    }
  }

  public void run(Scanner sc){
    boolean flag = true;
    int m = 0;
    while (flag){
      System.out.println("1. 밥먹기 || 2. 잠자기 || 3. 트레이닝 ||" +
          " 4. 놀기 || 5. 상태확인 || 6.종료 || 7. 특수공격기");
      m = sc.nextInt();
      switch (m){
        case 1:
          p.Eating();
          break;
        case 2:
          p.Sleeping();
          break;
        case 3:
          flag = p.Training();
          break;
        case 4:
          flag = p.Playing();
          break;
        case 5:
          p.statusCheck();
          break;
        case 6:
          flag = false;
          break;
        case 7:
          if(p instanceof Pikachu){
//            Pikachu pika = (Pikachu) p;
//            pika.Irontail();
            ((Pikachu) p).Irontail();;
          } else if (p instanceof Yeesanghae) {
//            Yeesanghae yee = (Yeesanghae) p;
//            yee.Solarbeam();
            ((Yeesanghae) p).Solarbeam();
          } else if (p instanceof Ggobuk) {
//            Ggobuk ggo = (Ggobuk) p;
//            ggo.WaterCannon();
            ((Ggobuk) p).WaterCannon();
          }
          break;
      }
    }
    if(p.hp<=0){
      System.out.println("\'"+ p.name+ "' 가 쓰러짐");
    }
    System.out.println("게임 종료...");
  }
}
