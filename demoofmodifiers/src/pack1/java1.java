package pack1;

public class java1 {
	public int a;//public members call another package in anothe class also
	
	private double b;//thisis only same class not even another class also not possible
	 protected char c;
	String str;
	
	void dipslay() {
		System.out.println("a:"+a);
		System.out.println("b:"+b);
		System.out.println("c:"+c);
		System.out.println("str:"+str);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java1 ob=new java1();
		
		ob.a=19;
		ob.b=8.56;
		ob.c='j';
		ob.str="pradeep";
		ob.dipslay();

	}

}
