package pack1;

//default members call same class and another class with same package
//when it comes to another package we can't call them in another package
public class java2 {
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
	java1 ob=new java1();
		
		ob.a=19;
		ob.b=8.56;
		ob.c='j';
		ob.str="pradeep";
		ob.dipslay();
	}
}
