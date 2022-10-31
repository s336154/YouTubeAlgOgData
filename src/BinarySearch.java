


public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int [] nums = {1, 10, 20, 47, 59, 65, 75, 88, 99};

        System.out.println(bs.binarySearch(nums, 20));

    }

    public int binarySearch(int [] nums, int key) { // return indeks from indeks 0 to nums.lenght-1
        int low = 0;
        int high = nums.length - 1;

        while( low <= high) {
            int mid = ( high + low)/2;  //divide the list into two
            if(nums[mid] == key) {
                return mid;
            }

            if(key < nums[mid]){
                high = mid -1; // search in the first half
            } else {
                low = mid + 1;  //search in the second half
            }
        }
        return -1;


    }


}
