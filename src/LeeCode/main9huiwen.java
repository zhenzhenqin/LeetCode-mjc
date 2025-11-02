package LeeCode;
import java.util.*;

public class main9huiwen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        int s = 0;
        long sum = 0;
        int count = 1;

        int temp = x;

        while(temp > 0){
            sum = sum * 10 + temp % 10;
            temp = temp / 10;
        }

        System.out.println(sum);

        if(x == sum){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
