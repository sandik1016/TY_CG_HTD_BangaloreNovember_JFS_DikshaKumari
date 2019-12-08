class FoorLoop{
            public static void main(String args[]){
                      int i;
                     for(i=0;i<10;i++)
                          {  
                              if(i==4)
                              break;
                            System.out.println("value of i:"+i);
                          }
                       System.out.println("-------------------------------");
                          for(i=0;i<10;i++)
                          {  
                              if(i==4)
                              continue;
                            System.out.println("value of i:"+i);
                          }      
                    }
}