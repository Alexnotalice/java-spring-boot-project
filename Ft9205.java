import java.util.Scanner;
//import java.util.regex.Matcher;

public class Ft9205{  
    
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String sentance= sc.next();
    boolean isIPv4 = sentance.contains(".");//Contains() is used to check out for a certain character
    //System.out.println(isIPv4);  
   
    if (isIPv4) {       
      String [] sen4Split= sentance.split("\\.");
      // //System.out.println(senSplit[2]);// input 192.168.01.1 > senSplit[2]=01
      byte regcnt=0;
      for(int s=0;s<sen4Split.length;s++){        
        if(sen4Split[s].matches("^([0][1-9])")){          
          regcnt++;
        }
      }   
      int[]sen4Int = new int[sen4Split.length];  
      System.out.println(regcnt); 
      for(int k=0;k<sen4Split.length;k++){
        sen4Int[k] = Integer.parseInt(sen4Split[k]);
        if(sen4Int[k]<=255){
          regcnt++;
        }
      }
      if(regcnt==4){      
          System.out.println("IPv4");
      }else{  
        System.out.println("不是合法的IP");
      }
      
    }else{
        String [] s6Split= sentance.split("\\:");        
        int countIPv6=0;
        for(int s=0;s<s6Split.length;s++){                      
          if(s6Split[s].matches("[A-Fa-f0-9]{1,4}")){
            countIPv6++;
          }                 
        }        
        //System.out.println(countIPv6);
        if(countIPv6==8){
          System.out.println("IPv6");
        }else{
          System.out.println("不是合法的IP");
        }

    }
    sc.close();
  }
}