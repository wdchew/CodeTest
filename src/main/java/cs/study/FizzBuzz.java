package cs.study;

public class FizzBuzz {
  public static void main(String arge[]){
    for (int i = 0; i <= 50; i ++){
      print(i);
    }
    
    
  }
  
  public static void print(int num){
    String msg = null;
    if (num % 3 == 0){
      msg = "Fizz";
    }else if (num % 5 == 0){
      msg = "Buzz";
    }else{
      msg = Integer.toString(num);
    }
    
    System.out.println(msg);
    
  }
  

}
