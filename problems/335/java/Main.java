/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.lang.String;
import java.util.*;

public class Main
{
    public static int index = 0;
    
    //convert string numbers to integer
    static int getNumber(String n, int p){
        int counter = 0;
        int i = p;
        while(n.charAt(p) != ',' && n.charAt(p) != ' ' && n.charAt(p) != '}' && n.charAt(p) != '{'){
            counter++;
            p++;
            index++;
            if( p >= n.length())
                break;
        }
        int t = 0;
        int pow = counter-1;
        for(int j = i; j < counter+i; ++j){
            t += Integer.parseInt(String.valueOf(n.charAt(j)) ) * Math.pow(10, pow);
            pow--;
        }
        return t;
    }
    
    
    static int doit(String numberGroup, int i){
        int sum = 0;
        if(numberGroup.charAt(index) == '{'){
            int tmp = 0;
            index+=1;
            while(!(numberGroup.charAt(index) == '}')){
                if(numberGroup.charAt(index) == '{'){
                    sum += doit(numberGroup, index);
                    index+=1;
                }
                else if(numberGroup.charAt(index) == ',' || numberGroup.charAt(index) == ' '){
                    index+=1;
                }
                //it's number
                else{
                    tmp = getNumber(numberGroup, index);
                    sum = sum + tmp;
                    
                }
            }
            System.out.println(sum);
            return sum;
        }
        if(numberGroup.charAt(index) == '}' || numberGroup.charAt(index) == ',' || numberGroup.charAt(index) == ' '){
            return sum;
            
        }
        
        int tmp = 0;
        while(!(numberGroup.charAt(index) == '}')){
            if(numberGroup.charAt(index) == '{'){
                    sum += doit(numberGroup, index);
                    index+=1;
                }
                
                else{
                    tmp = getNumber(numberGroup, index);
                    sum = sum + tmp;
                    
                }
        }
        System.out.println(sum);
        return sum;

    }

	public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String numberGroup = read.nextLine();
        doit(numberGroup,index);
	}
}
