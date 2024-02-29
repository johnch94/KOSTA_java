package p0226.ArrayListProduct.Order;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 숙제 :
 * 주문, 내 주문목록, 주문최소(결제안한것만), 주문번호로 검색,
 * 결제(pay가 false 인 것 true로 변경)
 *
 * dao, service, menu(run_c)
 */
public class OrderService {
  private OrderDao dao;
  public OrderService(){
    dao = new OrderDao();
  }

  // 상품목록 보여줌. 주문할 상품번호, 수량 입력.
  public void addOrder(int prodNum, int amount, int price, Scanner sc){
    System.out.println("1.즉시결제  2.장바구니"); // 즉시결제 pay가 true, 장바구니 pay가 false
    int type = sc.nextInt();
    boolean pay = false;
    if(type==1){
      pay = true;
    }
    // int prodNum, int amount, int price, boolean pay
    dao.prodOrder(new Order(prodNum, amount, price, pay));
  }

  // 주문목록 출력
  public void printOrderList(){
    ArrayList<Order> list = dao.getOrder();
    for(Order o : list){
      System.out.println(o);
    }
  }

  // 주문 취소, 결제한것은 취소 안됨.
  // 장바구니 목록 보여주고, 취소할 주문 번호 입력 받아서 선택한 order 객체를 삭제
  public void delOrder(Scanner sc){
    System.out.println("=== 주문 취소 ===");
    ArrayList<Order> list = dao.selectByPay(false);
    for(Order o : list){
      System.out.println(o);
    }
    System.out.print("취소할 주문 번호 : ");
    int num = sc.nextInt();
    int i;
    for(i=0; i<list.size(); i++){
      Order o = list.get(i);
      if(o.getNum() == num){
        dao.orderdelete(i);
        System.out.println("삭제된 주문정보");
        System.out.println(o);
      }
    }
    if(i==list.size()){
      System.out.println("없는 주문 번호");
    }
  }

  // 결제
  // 장바구니 목록 보여주고, 결제할 주문 번호 입력 받아서 선택한 order 객체 pay를 true 로
  public void editPay(Scanner sc){
    System.out.println("=== 결제 ===");
    ArrayList<Order> list = dao.selectByPay(false);
    for(Order o : list){
      System.out.println(o);
    }
    System.out.print("결제할 주문 번호 : ");
    int num = sc.nextInt();
    Order o = dao.selectByNum(num);
    if (o == null) {
      System.out.println("없는 주문 번호.");
    }else {
      if(o.isPay()){
        System.out.println("이미 결제한 주문.");
      }else {
        System.out.println("결제되닞 않은 주문은 결제 취소 불가");
      }
    }
  }

  // 출고대상 검색
  public ArrayList<Order> selectByOut(boolean flag){
    ArrayList<Order> list2 = selectByOut(true);
    ArrayList<Order> list3 = new ArrayList<>();
    for(Order o : list2){ // 결제 완료된 주문 목록에서 출고가 안된 주문검색
      list3.add(o);
    }
    return list3;
  }

}
