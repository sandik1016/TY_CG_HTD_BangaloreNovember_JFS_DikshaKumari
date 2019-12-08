class Rectangle{
                     public static void main(String args[]){
                                                     double result = perimeterRectangle(6,6);
                                                      double result1 = areaRectangle(5,6);
                                               System.out.println("Perimeter of rectangle "+result);
                                               System.out.println("Area of rectangle "+result1);
                        }
                                        static double perimeterRectangle(int length,int breadth){
                                                                                         
                                             double perimeterRectangle = 2*(length+breadth);
                                                return perimeterRectangle;
                                 }
                                            static double areaRectangle(int length,int breadth){
                                                      double areaRectangle=length*breadth;
                                                        return areaRectangle;
                }
}