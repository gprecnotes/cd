package CD;

import java.util.*;
public class Recusrvive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of items in the parsing table: ");
        int n = sc.nextInt();
        System.out.println("Enter the parsing table(row,column,production) : ");
        HashMap<String,String> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            System.out.println("Enter item "+i);
            String row = sc.next();
            String col = sc.next();
            String p = sc.next();
            hm.put(row+col,p);
        }
        System.out.println("Enter the starting symbol : ");
        String start = sc.next();
        System.out.println("Enter the input string: ");
        String input = sc.next();
        input+="$";
        String st = start+"$";
        System.out.println("--------Non Recursive Predictive Parser----------");
        System.out.println();
        System.out.println("Stack\t\tInput\t\tProduction");
        System.out.println(st+"\t\t"+input);
        while(!st.equals("$")){
            if(st.substring(0,1).equals(input.substring(0,1))){
                char ch = input.charAt(0);
                st = st.substring(1);
                input = input.substring(1);
                System.out.println(st+"\t\t"+input+"\t\tMatched: "+ch);
            }
            else{
                String temp = String.valueOf(st.charAt(0)+""+input.charAt(0));
                String production = hm.get(temp);
                String right = production.substring(3);
                if(right.equals("€")){
                    st = st.substring(1);
                }
                else{
                    st = right+st.substring(1);
                }
                System.out.println(st+"\t\t"+input+"\t\t"+production);
            }
        }
    }
   
}

