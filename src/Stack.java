import javax.management.ListenerNotFoundException;
import java.util.EmptyStackException;
import java.util.List;



public class Stack {

    private ListNode top;
    private int length;

    private static class ListNode {    //  Nr 1
        private int data;  // generic
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
      //      this.next = null;
        }

    }

    public void push(int data) {
        ListNode temp = new ListNode(data);
        temp.next = top; // temp will be inserted from front
        top = temp; // temp is the fist element "top"
        length++; // adding the new value to the list

    }

    public int pop() {

        if (isEmpty()) {
            throw new EmptyStackException();
        }

        int result = top.data;
        top = top.next;//assignin the next value to the new top/the previous value will be deleted which is the previous top
        length--; //deleting the previous value
        return result; //

    }

    public Stack() {
        top = null;
        length = 0;
    }

    public int length() {

        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int peek() {  // prints the last (current top) node in the list

        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return top.data;
    }


    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(15);
        stack.push(20);

        System.out.println(stack.peek());
        stack.pop();  // 20 will be removed
        System.out.println(stack.pop()); // 15 is to be removed now
    }





}
