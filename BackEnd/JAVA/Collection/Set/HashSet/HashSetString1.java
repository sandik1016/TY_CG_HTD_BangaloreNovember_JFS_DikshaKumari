import java.util.HashSet;

public class HashSetString1 {

	public static void main(String[] args) {
		HashSet<String> hs=new HashSet<String>();
		hs.add("atif");
		hs.add("aslam");
		hs.add(null);
		hs.add(null);
		for(Object ob:hs)
		{
		System.out.println(ob);
		}

	}

}
