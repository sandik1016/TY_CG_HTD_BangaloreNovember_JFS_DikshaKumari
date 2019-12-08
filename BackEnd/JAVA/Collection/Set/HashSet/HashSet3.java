import java.util.HashSet;

public class HashSet3 {

	public static void main(String[] args) {
		HashSet<Student>h1=new HashSet<Student>();

		h1.add(new Student(22,"Divya"));
		h1.add(new Student(24,"anu"));

		h1.add(new Student(23,"vidya"));
		h1.add(new Student(21,"Kivya"));

		System.out.println();

		for(Student s1:h1) {
			System.out.println(s1.studName + " and age is "+ s1.studAge);
		}


	}

}
