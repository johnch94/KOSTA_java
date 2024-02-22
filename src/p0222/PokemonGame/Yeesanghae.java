package p0222.PokemonGame;

public class Yeesanghae extends Pokemon {
  public Yeesanghae(){
    hp = 40;
    lv = 1;
    name = "이상해씨";
    System.out.println("이상해씨를 얻었습니다.");
  }

  @Override
  public void Eating(){
    System.out.println("밥먹기");
    hp += 7;
  }
  @Override
  public void Sleeping(){
    System.out.println("잠자기");
    hp += 7;
  }
  @Override
  public boolean Training(){
    System.out.println("훈련하기");
    hp -= 10;
    if(hp>0){
      exp += 20;
      lvCheck();
    }
    return hp>0; // false : 죽음
  }
  @Override
  public boolean Playing(){
    System.out.println("놀기");
    hp -= 3;
    if(hp>0){
      exp += 5;
      lvCheck();
    }
    return hp>0;
  }
  @Override
  public void lvCheck(){ //이상해씨는 exp 10마다 레벨 1 증가
    super.lvCheck();
    if(exp>10){
      lv++;
      exp -= 10;
      System.out.println("\'" + name + "' 가 레벨업 했습니다.");
    }
  }
  public void Solarbeam(){
    System.out.println("솔라빔");
  }
}
