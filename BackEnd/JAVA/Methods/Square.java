class Square{
                     public static void main(String args[]){
                                                     double result = perimeterSquare(6);
                                                      double result1 = areaSquare(5);
                                               System.out.println("Perimeter of square "+result);
                                               System.out.println("Area of square "+result1);
                        }
                                        static double perimeterSquare(int side){
                                                                                         
                                             double perimeterSquare= 4*side;
                                                return perimeterSquare;
                                 }
                                            static double areaSquare(int side){
                                                      double areaSquare=side*side;
                                                        return areaSquare;
                }
}