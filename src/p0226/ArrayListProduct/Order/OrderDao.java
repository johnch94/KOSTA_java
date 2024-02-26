package p0226.ArrayListProduct.Order;

import java.util.ArrayList;

/**
 * 숙제 :
 * 주문, 내 주문목록, 주문최소(결제안한것만), 주문번호로 검색,
 * 결제(pay가 false 인 것 true로 변경)
 *
 * dao, service, menu(run_c)
 */
public class OrderDao {
  private ArrayList<Order> order;

  OrderDao(){
    order = new ArrayList<>();
  }

  // 주문
  public void prodOrder(Order o){
    order.add(o);
  }

  // 내 주문목록 getter
  public ArrayList<Order> getOrder() {
    return order;
  }

  // 주문취소 (결제안한것만)
  public void orderCancle(){
    for(Order o : order){
      if(!o.isPay()){
        order.remove(o);
      }
    }
  }

  // 주문번호로 검색
  public Order orderSelect(int num){
    for(Order o : order){
      if(o.getNum()==num){
        return o;
      }
    }
    return -1;
  }

  // 결제
  public boolean orderPayment(){
    for(Order o : order){
      if(!o.isPay()){
        order.remove(o);
      }
    }
}
