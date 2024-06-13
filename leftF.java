package CD;
import java.util.*;
public class leftF
{
    private static String common(String str[]){
        String prefix=str[0];
        for(int i=1;i<str.length;i++){
            while(!str[i].startsWith(prefix)){
                prefix=prefix.substring(0,prefix.length()-1);
            }
            
            if(prefix.isEmpty()){
                return "";
            }
        }
        return prefix;
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Number of productions : ");
		int n=sc.nextInt();
		String str[] = new String[n];
		System.out.println("Enter productions : ");
		for(int i=0;i<str.length;i++){
		    str[i]=sc.next();
		}
		for(int i=0;i<str.length;i++){
		   String s = str[i].substring(0,1);
		   String arr[] = str[i].substring(3).split("\\|");
		   Map<Character,ArrayList<String>> map = new HashMap<>();
		   for(String k:arr){
		       char ch=k.charAt(0);
		       if(!map.containsKey(ch)){
		           map.put(ch,new ArrayList<String>());
		           
		       }
		       map.get(ch).add(k);
		   }
		   String out = s+"'->";
		   String in=s+"->";
		   String prefix="";
		   for(char key:map.keySet()){
		       String krr[]=map.get(key).toArray(new String[0]);
		       if(krr.length>1){
		             prefix=krr[0];
        		       prefix = common(krr);
        		       for(int l=0;l<krr.length;l++){
        		           if(prefix.length()==krr[l].length()){
        		               if(prefix.equals(krr[l])){
        		                   in+="E|";
        		               }
        		              continue;
        		           }
        		           out+=krr[l].substring(prefix.length())+"|";
        		       }
		       }
		       else{
		           in+=(krr[0])+"|";
		       }
		     
		   }
		   in+=(prefix+s+"'");
		   System.out.println(out+"\n"+in);
		}
		
	
	}
}

