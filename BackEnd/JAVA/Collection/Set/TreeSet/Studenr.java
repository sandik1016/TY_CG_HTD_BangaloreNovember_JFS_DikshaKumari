
public class Studenr implements Comparable{
            int age;
            String name;
			public Studenr(int age, String name) {
				super();
				this.age = age;
				this.name = name;
			}
			@Override
			public String toString() {
				return "Studenr [age=" + age + ", name=" + name + "]";
			}
			public int compareTo(Studenr o) {
				if(this.age<o.age)
					return 1;
				else if (this.age<o.age)
					return -1;
				else
					return 0;
			}
			@Override
			public int compareTo(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}
			
//			public int compareTo(Object o) {
//				
//				return 0;//both objects are equal therefore it is not adding before so we must give our own implementation
//			}
//            
}
