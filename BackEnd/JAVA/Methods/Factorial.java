class Factorial{
                     public static void main(String args[]){
                                                  int fact =  fact(7);
                                               System.out.println("Factorial of a number is"+fact);
                        }
                                        static int fact(int num){
                                                                                         
                                          if(num==0) return 1;
                                            return num*fact(num-1);
                                 }
                                         
}