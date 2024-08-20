import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
 
public class Main {
 
   public static int[] stack;
   
   public static int size = 0;
 
 

   public static void main(String[] args) throws NumberFormatException,IOException {
	 
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    //  BufferedWriter sb = new BufferedWriter(new OutputStreamWriter(System.out));
	      StringBuilder SB = new StringBuilder();
	     // String s = "";
	      int t = Integer.parseInt(br.readLine()); //3
	      stack = new int[t];//숫자나열
	      int m =0;
	      boolean stop = true;
	      
	      while(t-->0) {
	    	 
	    	 int n = Integer.parseInt(br.readLine()); //3,1,2
	    	 
	    	 if(n>m) { //3>0,1,2
	    		 while(n>m) {//
		    		SB.append(push(m));//0,1,2, 
		    		
	    			 m++;
		    	 }
	    		
	    		 SB.append(pop(m)); //3
	    		
	    	 }else {
	    		 
	    		 if(top()== n) {
	    			 
	    			 SB.append(pop(top())); 
	    			
	    		 }else {
	    			 stop = false;
	    			 
	    		 }
	    		 
	    	 }
	    	 
	    	
	    	 
	     }
	      if(!stop) System.out.println("NO");
	      else 
	      {
	    	  for(int i=0;i<SB.length();i++) {
	    		  System.out.println(SB.charAt(i));
	    	  }
	      }
	    
	    
      }
      
   
  
//   
   public static String push(int i) { 
	   stack[size] = i+1;//1,2,3
	  
	   size++;
	  
	   return "+";
	}
   
   public static String pop(int i) { 
	   stack[size-1] -= i;//3
	  
	   size--;
	   return "-";
	 }
      
      
   
//   
//   public static String empty() {
//      if(size == 0) {
//         return "YES";
//      }
//      else {
//         return "NO";
//      }
//   }
//   
   public static int top() {
   
      if(size == 0) {
         return 0;
      }
      else {
         return stack[size-1];
      }
   }
   
}
 
