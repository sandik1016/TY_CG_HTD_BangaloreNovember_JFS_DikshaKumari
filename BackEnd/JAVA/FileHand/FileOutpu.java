import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutpu {

	public static void main(String[] args) {
		try {
	FileOutputStream fo=new FileOutputStream("anu.txt");
	String s1="divya boggar";
	byte b1[]=s1.getBytes();
	
	fo.write(b1);
	System.out.println("success");
	
	
	
	}catch(IOException e) {
		System.out.println(e.getMessage());
	}

}
}