
abstract class GfG 
{ 
    // Instance Initialization Block 
    {  
        System.out.println("IIB block"); 
    } 
     
    // Constructor of GfG class 
    GfG() 
    { 
        System.out.println("Constructor Called"); 
    } 
    static {
    	System.out.println("static block");
    }
    void eat() {
    	System.out.println("eat method");
    }
    abstract  void drink();
    static int count;
    int sum;
    
}