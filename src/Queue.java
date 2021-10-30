import java.util.NoSuchElementException;

public class Queue {  //FIFO, WE USE rear TO INSERT AND front to remove

    private  ListNode front;
    private ListNode rear;
    private int length;

    public Queue(){
        this.front = null;
        this.rear = null;
        this.length = 0;
    }


    private static class ListNode {    //  Nr 1
        private int data;  // generic
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public int length() {

        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void enqueue(int data) {
        ListNode temp = new ListNode(data);

        if(isEmpty()){
            front = temp; // if the lust was empty then temp will be the front which is the first element in list
        } else {
            rear.next = temp; //rear is now pointing to the newly inserted value that is to be the next last
            // rear was the previous last node and now temp is the last node
        }
        rear = temp; // temp is currently the rear which is the last node in the list
        length++; // adding the new value to the list

    }

    public void print(){
        if(isEmpty()){
            return;
        }

        ListNode current = front;
        while( current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }

        System.out.println("null");  //null will be the last element anyway followed by a new line


    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        ///////////////// insterting elemnts in to Queue /////////////////

        queue.enqueue(10);
        queue.enqueue(30);
        queue.enqueue(13);

        queue.print();

///////////////// removing elemnts in Queue /////////////////
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.print();

    }

    public int dequeue(){  //method that remove elements from queue

        if(isEmpty()) {
            throw new NoSuchElementException("Queue is already Empty!");
        }

        int result = front.data;  // this the first element in the list
        front = front.next;  // front is now the second element in the list

        if(front == null) {  // when list is not empty front is null if rear is the only element in the list
            rear = null;  // thats how we remove rear that the last and only element in the list
        }
        length--; // we are decrementing the length of the list
        return result; // we will returnn the element to be deleted
    }

    public int first(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is Empty1!");

        }

        return front.data;  // return the first element that is front
    }

    public int last(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is Empty1!");

        }

        return rear.data; // return the last element that is rear
    }



}




