public class SelectionSort {

    public static void main(String[] args) {
        SelectionSort bs = new SelectionSort();
        int[] nums = new int[] {1, 10, 20, 7, 59, 5, 75, 8, 19};
        System.out.println("Values unsorted before Selection Sort are: ");
        bs.printArray(nums);
        System.out.println("Values sorted after Selection Sort are: ");
        bs.selectionSort(nums);
        bs.printArray(nums);


    }

    public void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }


    public void selectionSort(int [] arr){
        int n = arr.length;

        for(int i =0; i<n-1; i++){
            int min = i;
            for(int j = i+1; j<n; j++){
                if(arr[j] < arr[min]) {
                    min= j;
                }
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}
