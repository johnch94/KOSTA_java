package p0221;
class Car{
  protected String name;
  public void horn(){
    System.out.println("빵빵~");
  }
}
class Firetruck extends Car{
  public Firetruck(){
    name = "소방차";
  }
  @Override
  public void horn(){
    System.out.println("소방차가지나간다");
    System.out.println("siren~");
  }
}
class Ambulance extends Car{
  public Ambulance(){
    name = "구급차";
  }
  @Override
  public void horn(){
    System.out.println("앰뷸란스 지나간다");
    System.out.println("삐뽀삐뽀");
  }
}
class Police extends Car{
  public Police(){
    name = "경찰차";
  }
  @Override
  public void horn(){
    System.out.println("경찰차다");
    System.out.println("웨에에ㅔㅇㅇ");
  }
}
class Action{
  public void act(Car c){
    c.horn();
  }
}
public class UpcastingTest {
  public static void main(String[] args) {
//    Car f = new Firetruck();
//    f.horn();
//    Car a = new Ambulance();
//    a.horn();
//    Car p = new Police();
//    p.horn();

    Car[] cars = {new Firetruck(), new Ambulance(), new Police()};
    for(int i=0; i<cars.length; i++){
      cars[i].horn();
      if(cars[i] instanceof Firetruck){
        System.out.println("소방차");
      } else if (cars[i] instanceof Ambulance) {
        System.out.println("앰뷸란스");
      } else if (cars[i] instanceof Police) {
        System.out.println("경찰차");
      }
    }

    Action a = new Action();
    a.act(new Firetruck());
    a.act(new Ambulance());
    a.act(new Police());
  }
}
