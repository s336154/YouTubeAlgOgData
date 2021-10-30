
// From 48 to 54

import com.sun.source.tree.BreakTree;

import java.util.NoSuchElementException;

public class DoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;



    private class ListNode {
        int data;
        ListNode previous;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
            this.length = 0;
        }


    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertLast(3);
        dll.insertLast(10);
        dll.insertLast(11);


        dll.ForwardPrint();
        dll.BackwardPrint();

        dll.insertLast(11);
        dll.ForwardPrint();

        dll.insertFirst(3);
        dll.ForwardPrint();
    }

        public boolean isEmpty(){
            return length == 0;  // head is null
        }


    public  int length(){
        return length;
    }

    public void ForwardPrint() {  //

       ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp =temp.next;
        }
        System.out.println("null");

    }

    public void BackwardPrint() {  //
        if(tail == null) {
            return;
        }
        ListNode temp = tail;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp =temp.previous; //we are printing backward
        }
        System.out.println("null");

    }

    public void insertFirst(int value) {  //
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            tail= newNode;
        } else {
            head.previous = newNode;  //asigning first position to the newNode
        }
        newNode.next = head; // moving head to the second positon
        head = newNode; //  confriming that newNode is head now
        length++; // incrementing by 1
    }

    public void insertLast(int value) {  //
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
           head= newNode;
        } else {
            tail.next = newNode;//we think abt it from left to right / next is towards the right direction
            newNode.previous = tail; // moving tail to the left, one position before the tail (last)
        }
        tail = newNode; //  confriming that newNode is tail now
        length++; // incrementing by 1
    }


    public ListNode deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        ListNode temp = head;
        if (head == tail) {  //we only have one position in this list
            tail = null;
        } else {
            head.next.previous = null; //break the link from the second node(previous) and pointing to null
        }//breaking the link (2 pointers)  which are next & previous pointers

        head = head.next; //asignin first position to the second /node to the right of the current first
        temp.next = null; // we remove the link from first node to the second
        length--; // decrementing by one as we are deleting the first
        return temp; //return the to be deleted value
    }

    public ListNode deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        ListNode temp = tail;  // pointing to the last (tail)
        if (head == tail) {  //we only have one position in this list
            head = null;
        } else {
            tail.previous.next = null;//break the link from be4 last node towards the last node(next) and pointing to null
        }

        tail = tail.previous;//asignin last position to the be4 last /node to the left of the current last
        temp.previous = null; // we remove the link from last node to the before last(to be current last)
        length--; // decrementing by one as we are deleting the first
        return temp; //return the to be deleted value
    }





}
