package p0222.PokemonGame;

public class Ggobuk extends Pokemon {
  public Ggobuk(){
    hp = 50;
    lv = 1;
    name = "꼬북이";
    System.out.println("꼬북이를 얻었습니다.");
  }

  @Override
  public void Eating(){
    System.out.println("밥먹기");
    hp += 10;
  }
  @Override
  public void Sleeping(){
    System.out.println("잠자기");
    hp += 8;
  }
  @Override
  public boolean Training(){
    System.out.println("훈련하기");
    hp -= 10;
    if(hp>0){
      exp += 10;
      lvCheck();
    }
    return hp>0; // false : 죽음
  }
  @Override
  public boolean Playing(){
    System.out.println("놀기");
    hp -= 3;
    if(hp>0){
      exp += 1;
      lvCheck();
    }
    return hp>0;
  }
  @Override
  public void lvCheck(){ //꼬북이는 exp 50마다 레벨 1 증가
    super.lvCheck();
    if(exp>50){
      lv++;
      exp -= 50;
      System.out.println("\'" + name + "' 가 레벨업 했습니다.");
    }
  }
  public void WaterCannon(){
    System.out.println("물대포");
  }
}
