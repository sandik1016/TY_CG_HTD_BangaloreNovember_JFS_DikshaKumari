import java.util.Stack;

public class Stack1 {

	public static void main(String[] args) {
		Stack s1= new Stack();
		s1.add(23);
		s1.add(56);
		s1.push(67);
		System.out.println(s1);
		s1.pop();
		System.out.println(s1);
		System.out.println(s1.peek());//same as get().it will return last element
		System.out.println(s1);
		System.out.println(s1.search(23));//same as getIndex it will give output in reverse order and it is giving position value not index as index starts from 0
		System.out.println(s1);

	}

}

