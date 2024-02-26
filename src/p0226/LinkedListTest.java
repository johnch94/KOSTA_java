package p0226;

/**
 * Linked List 만들기
 */
class Node{
  Object data; // data 저장
  Node next; // 다음 노드 주소
}
class MyLinkedList{
  private Node head, tail;

  public void addNode(Object data){
    Node n = new Node();
    n.data = data;
    if(head==null){
      head = n;
      tail = n;
    }else {
      tail.next = n;
      tail = n;
    }
  }
  public void printAll(){
    Node cur = head;
    if(head==null){
      System.out.println("노드가 하나도 없음");
    } else {
      while (cur != null) {
        System.out.println(cur.data);
        cur = cur.next;
      }
    }
  }
}
public class LinkedListTest {
  public static void main(String[] args) {
    MyLinkedList list = new MyLinkedList();
    list.addNode(1);
    list.addNode(2);
    list.addNode(3);
    list.printAll();
  }
}
