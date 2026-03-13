// public class ok {
//     public static void main(String[] args) {
        
//     }
// }

// import java.util.Scanner;

// public class Main{
//     public static void main(String[]args){
//         Scanner in = new Scanner (System.in);
//         int[] arr= new int[4];
//         for (int i = 0; i < arr.length;i++){
//         arr[i]=in.nextInt();
//         }
//         for (int i = 0; i < arr.length;i++){
//         System.out.print(arr[i] + " ");
//         }
//     }
// }

// import java.util.Scanner;
// public class Main{
//     public static void main (String[] args){
//         Scanner input = new Scanner (System.in);
//         System.out.print("Enter the rollno ");
//         int rollno =input.nextInt();
//         System.out.println("roll no is " + rollno);
//     }
// }

// import java.util.Scanner;
// public class Main{
//     public static void main(String[] args){
//         Scanner input = new Scanner (System.in);
//         int num1 = input.nextInt();
//         float num2 = input.nextFloat();
//         float sum = num1 + num2;
//         System.out.println("Sum is = "+ sum);
//     }
// }

// import java.util.Scanner;
// public class Main{
//     public static void main(String[]args){
//         // Scanner input = new Scanner (System.in);
//         int number = 'A';
//         System.out.println(number);
        
//     }
// }

// import java.util.Scanner;
// public class Main{
//     public static void main(String[] args){
//         Scanner input = new Scanner(System.in);
//         int salary = input.nextInt();
//         if (salary > 10000 & salary <20000){
//             salary =salary + 2000;
//         }
//         else if(salary >= 20000){
//             salary = salary + 1000;
//         }
//         else{
//             salary += 100;
//         }
//         System.out.println(salary);
//     }
// }

// import java.util.Scanner;
// public class Main {
//     public static void main(String[]args){
//         Scanner input = new Scanner (System.in);
//         int n = input.nextInt();
//         for (int num = 1; num <=n; num++){
//             System.out.println("yes");
//         }
//     }
// }
// import java.util.Scanner;
// public class Main{
//     public static void main(String[] args ){
//         Scanner input = new Scanner (System.in);
//         int n = 1;
//         while (n <=5 ){
//             System.out.println(n);
//             n++;
//         }
//     }
// }

// import java.util.Scanner;
// public class Main{
//     public static void main(String[] args ){
//         Scanner input = new Scanner (System.in);
//         int a = input.nextInt();
//         int b = input.nextInt();
//         int c = input.nextInt();
//         if (a>b && a>c){
//             System.out.println("a is the largest number " + a);
//         }
//         else if (b>a && b>c){
//             System.out.println("b is the largest number " + b);
//         }
//         else {
//             System.out.println("c is the largest number " + c);
//         }
//         // input.close();
//     }
// }

// Fibonacci number

// import java.util.Scanner;
// public class Main{
//     public static void main(String[] args ){
//         Scanner input = new Scanner (System.in);
//         int n = input.nextInt();
//         int a = 0;
//         int b = 1;
//         int count = 2;
//         while (count <= n){
//             int temp =b;
//             b = b +a;
//             a = temp;
//             count++;
//         }
//         System.out.println(b);
//     }
// }
// count the number of same digit in the line

// import java.util.Scanner;
// public class Main{
//     public static void main(String[] args ){
//         Scanner input = new Scanner (System.in);
//         int n = input.nextInt();
//         int count = 0;
//         while (n>0){
//             int rem = n%10;
//             if (rem == 5){
//                 count ++;
//             }
//             n = n/10;
//         }
//         System.out.println(count);
//     }
// }

// Reverse the number

// import java.util.Scanner;
// public class Main{
//     public static void main(String[] args ){
//         Scanner input = new Scanner (System.in);
//         int n = input.nextInt();
//         int ans = 0;
//         while (n>0){
//             int rem = n%10;
//             n = n/10;
//             ans = ans * 10 + rem;
//         }
//         System.out.println(ans);
//     }
// }

// Switch case statements

// import java.util.Scanner;
// public class Main{
//     public static void main(String[] args ){
//         Scanner input = new Scanner (System.in);
//         String fruit = input.next();  
//         switch (fruit) {
//             case "Mango":
//                 System.out.println("King of Fruits");
//                 break;
//             case "banana":
//                 System.out.println("yellow in color");
//                 break;
//             default :
//             System.out.println("empty");
                    
                
//         }
//     }
// }

// import java.util.Scanner;
// public class Main{
//     public static void main(String[] args ){
//         Scanner input = new Scanner (System.in);
//         int a = input.nextInt();
//         int b = input.nextInt();
//         int c = a +b;
//         System.out.println("sum of a + b = ",c);
//     }
// }

// import java.util.Scanner;
// public class Main{
//     public static void main(String[]args){
//         String message = greet();
//         System.out.println(message);
//     }
//     static String greet(){
//     String greeting="how are you";
//     return greeting;
// }
// }


// import java.util.Arrays;
// public class ok{
//     public static void main(String[]args){
//         int[] arr ={1,2,3,6,54,8};
//         change (arr);
//         System.out.println(Arrays.toString(arr));
//     }
//     static void change(int[] num){
//         num[0] = 9;
//     }
// }

// Print all the 3 Armstrong number ???

// public class ok {
//     public static void main(String[] args) {
//         System.out.println("3-digit Armstrong numbers are:");

//         for (int i = 100; i <= 999; i++) {
//             int original = i;
//             int sum = 0;
//             int temp = i;

//             while (temp > 0) {
//                 int digit = temp % 10;
//                 sum += digit * digit * digit;
//                 temp /= 10;
//             }

//             if (sum == original) {
//                 System.out.println(original);
//             }
//         }
//     }
// }

// linear searching

// public class ok {
//     public static void main(String[] args) {
//         int[] nums = {22,15,25,94,655,55,19,62,58};
//         int target = 555;
//         int ans = linersearch(nums, target);
//         System.out.println(ans);
//     }
//     static int linersearch (int[]arr, int target){
//         if (arr.length == 0){
//             return -1;
//         }
//         for (int i=0; i<arr.length;i++){
//             int element = arr[i];
//             if (element == target){
//                 return i;
//             }
//         }
//         return -1;
//     }
// }

public class ok{
    public static void main(String[] args) {
        int[] arr ={21,858,35,66,358,64,8};
        System.out.println(min(arr));
    }
    static int min (int[] arr){
        int ans = arr[0];
        for (int i=0; i<arr.length; i++){
            if (arr[i]<ans){
                ans =arr[i];
            }
        }
        return ans;
    }
}