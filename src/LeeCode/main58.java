package LeeCode;

public class main58 {
    public static void main(String[] args) {
        String s = "Hello World";
        int i = s.length() - 1;  //10
        while(s.charAt(i) == ' '){
            i--;
        }

        int j = i - 1; //9
        while(j != -1 && s.charAt(j) != ' '){
            j--;
        }
        //i = 10, j = 5
        System.out.println(j);
        System.out.println(i - j);
    }
}
