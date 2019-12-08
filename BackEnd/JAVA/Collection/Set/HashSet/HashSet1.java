import java.util.HashSet;

public class HashSet1 {

	public static void main(String[] args) {
HashSet hs=new HashSet();
hs.add(23);
hs.add(86);
hs.add(78);
hs.add(null);
for(Object ob:hs)
{
System.out.println(ob);
}

	}

}
