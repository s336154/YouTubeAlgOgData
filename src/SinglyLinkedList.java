
// From video 14  ---->  41

// when there is no parameter then we use "method().data" we add ".data" to the method declaration


public class SinglyLinkedList {

    private ListNode head;


    private static class ListNode {    //  Nr 1
        private int data;  // generic
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static void main(String[] args) {
        //   SinglyLinkedList sll = new SinglyLinkedList();
        //head is instance variable
        //    sll.head =new ListNode(10);

        ListNode head = new ListNode(9);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);


        // Now we will connect them together  to form a chain
        //   sll.head.next = second; // 10 --> 1  (have typed head.next at start but didnt work

        head.next = second; // 10 --> 1
        second.next = third; // 10 --> 1 ---> 8
        third.next = fourth; //10 --> 1 --> 8 --> 11 --> null

        SinglyLinkedList sll = new SinglyLinkedList();

        System.out.println(" Antall elemeter i listen er " + sll.length());


        sll.insertFirst(12);
        sll.insertFirst(83);
        sll.insertFirst(19);
        sll.insertFirst(40);

        sll.insert(3, 1);
        sll.insert(2, 2);
        sll.insert(2, 3);
        sll.insert(1, 4);
        sll.insert(98, 5);


        sll.print();

        if (sll.search(head, 11)) {
            System.out.println("Search key found!!");
        } else {
            System.out.println("Search key not found!!");
        }
        //     sll.print();

        //      System.out.println("We are going to delete: " +sll.deleteFirst().data);  // dont forget .data

        //   System.out.println("We are going to delete: " + sll.deleteLast().data);  // dont forget .data

        //    sll.print();

        //   sll.search(3);


        ListNode resverse = sll.reversNode(head);
        sll.print();

        //////////////////////////////////////////////////////////////////////////////

        ListNode Middle = sll.MiddelNode();
        System.out.println("Middle node is : " + Middle.data);  // dont forget .data when there is no parameter

        //////////////////////////////////////////////////////////////////////////////

        ListNode NthNodeFromEnd = sll.BackwordFind(3);
        System.out.println("Nth node from the end is :" + NthNodeFromEnd.data);  // dont forget .data when there is no parameter


        //////////////////////////////////////////////////////////////////////////////

        sll.DuplicateNode();
        sll.print();

        //////////////////////////////////////////////////////////////////////////////

        sll.InsertSorted(7);
        sll.print();

        //////////////////////////////////////////////////////////////////////////////

        sll.removeNode(7);
        sll.removeNode(40);
        sll.removeNode(12);
        sll.print();
    }

    public int length() {  //  Nr 2

        if (head == null) {
            return 0;  // empty
        }

        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void print() {  //  Nr 3

        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.println("null");

    }

    public void insertFirst(int value) {  //  Nr 4
        ListNode newNode = new ListNode(value);  //creating new node
        newNode.next = head;  //connecting the two nodes /  replacing the head to the right(after) the new node
        head = newNode; // asigning the first position (head) to the new node
    }


    public void insertLast(int value) {  //  Nr 5
        ListNode newNode = new ListNode(value);
        if (head == null) {  // if list is empty
            head = newNode;  // asign the new node to the head
            return;
        }

        ListNode current = head;  // current is pointing to head
        while (null != current.next) {
            current = current.next;
        }
        current.next = newNode;

    }


    public void insert(int data, int position) {  //  Nr 6
        ListNode node = new ListNode(data);
        if (position == 1) {   // position != index, the first position we want to insert is 1
            node.next = head;  //making a connection
            head = node;  // reasigning the head to the new node,
        } else {
            ListNode previous = head;
            int count = 1; // this is previous to the posion "position -1"
            while (count < position - 1) {
                previous = previous.next; // going to the position step by step
                count++;
            }
            ListNode current = previous.next; // asserting the postion, not doin anything new
            previous.next = node;
            node.next = current; // inserting the new node inbetween
        }
    }


    public ListNode deleteFirst() {  //  Nr 7  // we have to add .data bcz this is ListNode

        if (head == null) {  // it is empty
            return null;
        }
        ListNode temp = head;
        head = head.next;  // moving head to next node in positon 2
        temp.next = null;  //we are removing it,break linkage/next is not head which is the node in position 2
        return temp; // return the deleted node which is the previous head

    }

    public ListNode deleteLast() {  // Nr 8
        if (head == null || head.next == null) {  // head is the only node in this case
            return head;  // we are deleting head which is the only node
        }

        ListNode current = head;
        ListNode previous = null;  // this makes head the first node/position in the list

        while (current.next != null) {  // as long as current is not the last node
            previous = current;
            current = current.next;
        }  // we go out from this condition when current.next == null; then we are in the last position

        previous.next = null;//break the link/ we are removing the current node which is in the last position
        return current; //we are returnin the current node which is in the last position and to be deleted
    }


    public void deleteNode(int position) {  // Nr 9
        if (position == 1) {
            head = head.next;
        } else {
            ListNode previous = head;  // head is in position 1
            int count = 1;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }

            ListNode current = previous.next;  // if position=2, this will be position 2
            previous.next = current.next; // we are disconnecting positon 2 from list
        }

    }

    public boolean search(ListNode head, int searchKey) {  // Nr 10
        ListNode current = head;  // poibnting to head
        while (current != null) {
            if (current.data == searchKey) {
                return true;  // if the seacKey is in the list then we return true
            }
            current = current.next; // we resume the search by pointing to the next node
        }
        return false; // the searchKey is not in the list

    }

    public ListNode reversNode(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = previous; //points to the previous node even if it was null
            previous = current; // interchanging the positions
            current = next; //moving current to the last, before null node
        }
        return previous;  //previous become our new head

    }

    public ListNode MiddelNode() {

        if (head == null) {
            return head;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }  // loop terminate when fast.ptr reaches the end  and slowPtr is at the middle of the way
        return slowPtr;
    }

    public ListNode BackwordFind(int n) {  //position away from the last node

        if (head == null) {
            return head;
        }

        if (n <= 0) {
            throw new IllegalArgumentException("Invalid value: n = " + n);
        }

        ListNode mainPtr = head;
        ListNode refPtr = head;
        int count = 0; // first position
        while (count < n) {

            if (refPtr == null) {
                throw new IllegalArgumentException(n + " is greater than the number of nodes in list");
            }

            refPtr = refPtr.next;
            count++;
        }
        while (refPtr != null) {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    public void DuplicateNode() {  // notice the void here as there is no return value

        if (head == null) {
            return;
        }

        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next; //ignore the next node and point to the next next, make current point to the next next node
            } else {
                current = current.next; // travel current to the next(next next)
            }
        }
    }

public  ListNode InsertSorted(int value){

        ListNode newNode = new ListNode(value);

        if(head==null){
            return newNode;
        }

    ListNode current = head;
    ListNode temp = null;
    while(current !=null && current.data < newNode.data)

    {  // current node is different from temp node
        temp = current;  // temp is assigned the current node
        current = current.next; // as long as current.next < newNode
    }  // otherwise

    newNode.next =current; // if current(current.next)> newNode then we go out of the loop and make newNode point to the current node
    temp.next =newNode; // newNode is inbetween temp and current nodes
    return head;
}

public void removeNode(int key) {
    ListNode current = head;
    ListNode temp = null;

    if (current != null && current.data == key)
    { //in this case we found the key in the first position (head) in the list
        head = current.next; // we disconnect the first node from the list
        return; // we are finished
    } // otherwise

    while (current != null && current.data != key)
    {  // we go out of the loop when current == null or current == key

        temp = current;
        current = current.next;
    }

    if (current == null) return;  // we didnt find the key
    temp.next = current.next; //in this condition current == key, we break the linkage between temp and key(current)
    // by making temp point to current.next and so the key is no longer in the list
}


}