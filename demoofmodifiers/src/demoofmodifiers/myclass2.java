package demoofmodifiers;

public class myclass2 {
	int a;
	double b;
	char c;
	String str;
	
	void dipslay() {
		System.out.println("a:"+a);
		System.out.println("b:"+b);
		System.out.println("c:"+c);
		System.out.println("str:"+str);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myclass obj=new myclass();
		/*
		 * obj.a=40; obj.b=18.56; obj.c='k'; obj.str="pradeepkumar";
		 */
		obj.dipslay();
	}

}
