package business;
/*
* Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of the square of all of its digits, leads us to number ‘1’.
 All other (not-happy) numbers will never reach ‘1’. Instead, they will
be stuck in a cycle of numbers which does not include ‘1’.
* */
public class HappyNumber {
    public static boolean find(int num) {
        int slow = squareSum(num) , fast =  squareSum(squareSum(num));
        while(slow != fast){
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        }
        return slow == 1;
    }
    public static int squareSum(int num){
//        System.out.println(num +"num");
        int sum  = 0;
        while (num > 0){
            int n = num % 10;
            sum =  sum + (n*n);
            num = num/10;
        }
//        System.out.println( sum +"sum");
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
    }
}


