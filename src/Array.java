public class Array {

    public static void main(String[] args) {
        int[] numbers = {1, 3, 9, 2, 5, 9, 22, 10};
        printArray(numbers);

        ////////////////////////////////////////////////////////////////////////////////////////

        reverseArray(numbers, 0, numbers.length - 1);
        printArray(numbers);
    }

    public static void printArray(int[] n) {

        for (int i = 0; i < n.length-1; i++) {
            System.out.print(n[i] + " ");
        }
        System.out.println();
    }

    public static void reverseArray(int[] numbers, int start, int end) {

        while (start < end) {
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }

    }

    public void moveZeros(int[] num, int n) {
        int j = 0; // pointer that focus at zero elements
        for (int i = 0; i < n; i++) { // pointer focus on non-zero elements
            if (num[i] != 0 && num[j] == 0) {  // we only swap if value in list is 0
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }

            if (num[j] != 0) { // we are incrementing bcz we are focusing just on zero elements
                j++;
            }
        }
    }

    public int[] resize(int[] num, int cap) {
        int[] temp = new int[cap];
        for (int i = 0; i < num.length; i++) {
            temp[i] = num[i];
        }
        return temp;  //reassigning num array to temp array
    }

}

