import java.util.Stack;

public class Extra {

    public static String reverse(String str) {  //method to reverse a string
        Stack<Character> stack = new Stack<>();  // holds only charachter values, we r creating empty Stack
        char[] chars = str.toCharArray(); //it will be converted to character array, return back character array
        for(char c :chars)  {
            stack.push(c);  //pushing elements of array "chars" into stack
        }

        for(int i = 0; i<str.length();i++) {
            chars[i] = stack.pop(); //poping the elements in stack out of stack into the Array "chars" ved LIFO
        } //Stack follows LIFO method so the last element inserted to Stack will be the first element in char array
        return new String(chars); // we return the newly reversed array chars

    }


    public static void main(String[] args) {
        String str = "ABCD";
        System.out.println("Before reverse -" + str);
        System.out.println("After reverse - " +reverse(str));
    }
}
