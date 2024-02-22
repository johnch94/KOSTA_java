package p0221.PokemonGame;

public class Pikachu extends Pokemon{
  public Pikachu(){
    hp = 30;
    lv = 1;
    name = "피카츄";
    System.out.println("피카츄를 얻었습니다.");
  }

  @Override
  public void Eating(){
    super.Eating();
    hp += 5;
  }
  @Override
  public void Sleeping(){
    super.Sleeping();
    hp += 5;
  }
  @Override
  public boolean Training(){
    super.Training();
    hp -= 10;
    if(hp>0){
      exp += 15;
      lvCheck();
    }
    return hp>0; // false : 죽음
  }
  @Override
  public boolean Playing(){
    super.Playing();
    hp -= 3;
    if(hp>0){
      exp += 3;
      lvCheck();
    }
    return hp>0;
  }
  @Override
  public void lvCheck(){ //피카츄는 exp 20마다 레벨 1 증가
    super.lvCheck();
    if(exp>20){
      lv++;
      exp -= 20;
      System.out.println("\'" + name + "' 가 레벨업 했습니다.");
    }
  }
  public void Irontail(){
    System.out.println("아이언 테일");
  }
}
