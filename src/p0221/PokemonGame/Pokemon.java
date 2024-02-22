package p0221.PokemonGame;
public class Pokemon {
  protected String name;
  protected int hp;
  protected int lv = 1;
  protected int exp = 0;
  Pokemon(){}

  public Pokemon(String name, int hp, int lv, int exp) {
    this.name = name;
    this.hp = hp;
    this.lv = lv;
    this.exp = exp;
  }

  public void Eating(){
    System.out.println("\'" + name +  "' 가 밥을 먹습니다.");
  }
  public void Sleeping(){
    System.out.println("\'" + name +  "' 가 잠을 잡니다.");
  }
  public boolean Training(){
    System.out.println("\'" + name +  "' 가 훈련을 합니다.");
    return true;
  }
  public boolean Playing(){
    System.out.println("\'" + name +  "' 와 놉니다.");
    return true;
  }
  public void lvCheck(){
    System.out.println("\'" + name +  "' 의 레벨 확인");
  }
  public void statusCheck(){
    System.out.println("\'" + name + "' 의 상태 확인");
    System.out.println("hp  : " + hp);
    System.out.println("exp : " + exp);
    System.out.println("lv  : " + lv);
  }
}
