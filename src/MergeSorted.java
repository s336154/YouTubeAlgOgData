

public class MergeSorted {

    // we use this method to merge two sorted arrays into new array

    public static void main(String[] args) {
        MergeSorted msa = new MergeSorted();
        int [] arr1 = {0, 1 , 4, 8,89}; // array is sorted
        int [] arr2 = {2, 21 , 22, 38,69}; // array is sorted

        System.out.println("Values unsorted before Merge Sort are: ");
        msa.printArray(arr1);
        msa.printArray(arr2);

        System.out.println("Values sorted after Merge Sort are: ");
       int [] result = msa.merge(arr1,arr2, arr1.length, arr2.length);
        msa.printArray(result);}

    public void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }



    int[] merge(int[] arr1, int[] arr2, int n, int m) {
        // we compare two arrays and insert values that are lesser
        // n is the length of array 1 and m is the length of array 2
    int[] result = new int[n + m]; // new merged array
    int i = 0; //traverse arr1
    int j = 0; //traverse arr2
    int k = 0;  // traverse result / k is the variable name for elements in the new array

    while(i<n &&j<m) { //boundary conditions
        if (arr1[i] < arr2[j]) { //if i < j then we begin by inserting the values of i
            result[k] = arr1[i]; // storing the values into result array
            i++;
        } else { //otherwise if i > j then we begin by inserting the values of j
            result[k] = arr2[j]; // storing the values into result array
            j++;
        }
        k++; } // we perform the same process until result array is full

    while(i<n) { // i is the first indeks and n is the last indeks in arr1 array
        result[k] = arr1[i];
        i++;
        k++;}


    while(j<m) { // j is the first indeks and m is the last indeks in arr2 array
        result[k] = arr2[j];
        j++;
        k++;}

    return result;

}



}
