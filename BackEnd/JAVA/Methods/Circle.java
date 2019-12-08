class Circle{
                     public static void main(String args[]){
                                                     double result = perimeterCircle(6);
                                                      double result1 = areaCircle(5);
                                               System.out.println("Perimeter of circle "+result);
                                               System.out.println("Area of circle "+result1);
                        }
                                        static double perimeterCircle(int r){
                                                                                         
                                             double perimeterCircle = 2*3.142*r;
                                                return perimeterCircle;
                                 }
                                            static double areaCircle(int r){
                                                      double areaCircle=3.142*r*r;
                                                        return areaCircle;
                }
}