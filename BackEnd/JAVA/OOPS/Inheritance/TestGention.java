package iheritance;

public class TestGention {
public static void main(String arr[])
{
	ThirdGeneration tg=new ThirdGeneration();
	tg.call();
	tg.msg();
	tg.radio();
   tg.camera();
	SecondGeneration sg=new SecondGeneration();
	sg.call();
	sg.msg();
	sg.radio();
	FirstGerneration fg=new FirstGerneration();
	fg.call();
	fg.msg();
	FirstGerneration kg=new SecondGeneration();
	kg.call();
	kg.msg();
	SecondGeneration hg=new ThirdGeneration();
	hg.call();
	hg.msg();
	hg.radio();
}
}
