public class HashTable {
    private HashNode[] buckets;
    private int numOfBuckets; //capacity
    private int size; // numeber of key values pairs in hash table or number of hash nodes i

    public HashTable() {
        this( 10); //default capacity
    }

    public HashTable(int capacity){
        this.numOfBuckets = capacity;
        this.buckets = new HashNode[numOfBuckets];
        this.size=0;
    }

    private class HashNode {
        private Integer key; //can be generic type
        private String value; //can be generic type
        private HashNode next; //refernce to next HashNode

        public HashNode(Integer key, String value){
            this.key = key;
            this.value = value;
        }
    }

    private int size(){
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getBucketIndex(Integer key){
        return key % numOfBuckets; //return remainder which is bucket.length
    }

    public void put(Integer key, String value){

        if(key== null || value == null ) {
            throw new IllegalArgumentException("Key or value is null !!!");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while( head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        head = buckets[bucketIndex];
        HashNode node = new HashNode(key, value);
        node.next = head;
        buckets[bucketIndex] = node;

    }



    public String get (Integer key){

        if(key == null){
            throw new IllegalArgumentException("Key is null!!");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public String remove(Integer key){
        if(key == null){
            throw new IllegalArgumentException("Key is null!!");
        }

        int bucketIndex= getBucketIndex(key);
        HashNode head = buckets[bucketIndex];  // (21, "Tom") -> (31, "Harry") -> (41, "Sana") -> null
        HashNode previous = null;

        while(head != null){
            if(head.key.equals(key)){
               break;
            }
            previous = head;
            head = head.next;
        }

        if(head == null) {
            return null;
        }

        size--;

        if(previous != null){
            previous.next = head.next;
        } else {
            buckets[bucketIndex] = head.next;
        }

        return head.value;
    }


    public static void main(String[] args) {

        // First code
        HashTable table = new HashTable(10);
        table.put(105, "Tom");
        table.put(21, "Sana");
        table.put(21, "Mary");
        table.put(31, "Dinesh");

        System.out.println(table.size());

        System.out.println(table.get(31));
        System.out.println(table.get(21));
        System.out.println(table.get(105));
        System.out.println(table.get(21));


        System.out.println(table.remove(105));
        System.out.println(table.remove(21));
        System.out.println(table.size());
    }

}
