
public interface Bottle {
      void open();
      void drink();
      default void juice() {
    	  System.out.print("juice name is");
      }
      static void close() {
    	  System.out.print("closed");//we cannot refer it by object refernce because it is static we can either access using 
    	  //class name or interface name
      }
}
 