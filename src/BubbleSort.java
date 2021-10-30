

public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        int[] nums = new int[] {1, 10, 20, 7, 59, 5, 75, 8, 19};
        bs.printArray(nums);
        bs.sort(nums);
        bs.printArray(nums);


    }



    public void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public void sort(int [] arr) {
        int n = arr.length;
    boolean isSwapped;
    for(int i=0; i< n-1; i++) {

        {
            isSwapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                // we use i to controll inner for loop value by the outer for loop value
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if (isSwapped == false) {
                break;
            }
            }

        }
    }
    }





