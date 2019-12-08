
public class Demo4 {   
	private String name;
	private int age;  //create own immutable class
	
	@Override
	public String toString() {
		return "Demo4 [name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	 
public Demo4(String name,int age) {
	super();
	this.name=name;
	this.age=age;
}
}
