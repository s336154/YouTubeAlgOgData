public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {0, 1, 4, -2, 9,  8, 89}; // array is unsorted
        MergeSort ms = new MergeSort();



        System.out.println("Values unsorted before Merge Sort are: ");
        ms.printArray(arr);



        System.out.println("Values sorted after Merge Sort are: ");
        ms.sort(arr,new int[arr.length], 0, arr.length-1);
        ms.printArray(arr);

    }


    public void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");

        }
        System.out.println();
    }

    private void merge(int[] arr, int[] temp, int low, int mid, int high) {

        for(int i = low; i <= high ; i++){
            temp[i] = arr[i];
        }
        int i = low; //traverse left sorted subarray
        int j = mid + 1;//traverse right sorted subarray
        int k = low; //merge both subarrays into orginal array arr

        while(i <= mid && j <= high ) {
            if(temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }

            k++;
        }

        while ( i <= mid) {
            arr[k] = temp[i];
            k++;
            i++;
        }



    }
    public void sort(int[] arr, int[] temp, int low, int high) { // recursive method
        if(low<high){ //base case
            int mid = low + (high-low) /2;
            sort(arr, temp, low, mid);  //from left
            sort(arr, temp, mid+1, high);  // from right
            merge(arr, temp, low, mid, high);
        }



    }
}
