public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort bs = new InsertionSort();
        int[] nums = new int[] {1, 10, 20, 7, 59, 5, 75, 8, 19};
        System.out.println("Values unsorted before Insertion Sort are: ");
        bs.printArray(nums);
        System.out.println("Values sorted after Insertion Sort are: ");
        bs.insertionSort(nums);
        bs.printArray(nums);


    }



    public void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }


    public void insertionSort(int [] arr) {

        for(int i =1; i <arr.length ; i++){  //unsorted part
            int temp = arr[i];  // values in the array
            int j = i - 1; //variable with index b4 i //sorted part
            while(j >= 0 && arr[j] > temp){ // er are swapping values inside this loop if j > i
                arr[j+1] = arr[j];//arr[j+1] is similar to arr[i]/ we are shifting/swapping variables here
                j= j-1;
            }

            arr[j+1] = temp;
        }

    }
}
