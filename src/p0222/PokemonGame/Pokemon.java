package p0222.PokemonGame;

/**
 * 추상 메서드를 활용해 pokemon을 재정의 하기
 * 포켓몬 캐릭터들을 공통점을 정의하여 상속 하는게 목적
 */
public abstract class Pokemon {
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

  public abstract void Eating();
  public abstract void Sleeping();
  public abstract boolean Training();
  public abstract boolean Playing();
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
