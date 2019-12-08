package ExceptionPropagat;

public class D {
static void o() throws ClassNotFoundException {
	Class.forName("A");//checked exception can be handled by try and catch or throws keyword
}
}
