package LeetCodeSolutions;

public class tempCodeRunner {

  public static void main(String[] args) {
    tempCodeRunner codeRunner = new tempCodeRunner();
    codeRunner.addTwoNumbers(new ListNode(1,2,3),new ListNode(1,2,3));
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    return l1;
  }

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
