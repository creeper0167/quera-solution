import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String[] strings;
        int t = userInput.nextInt();
        strings = new String[t];
        int i = 0;
        int max, min, refPercentage, diff;
        refPercentage = 100;

        for(String str: strings){
            strings[i] = userInput.next();
            ++i;
        }

        max = Integer.parseInt(strings[0]);
        min = 100;
        for(String str: strings){
            if(Integer.parseInt(str) < max)
                max = Integer.parseInt(str);
        }

        for(String str: strings){
            diff = 100 - Integer.parseInt(str);
            min -= diff;
            if(min < 0){
                min = 0;
                break;
            }
        }

        System.out.println(min + " " + max);

    }
}
