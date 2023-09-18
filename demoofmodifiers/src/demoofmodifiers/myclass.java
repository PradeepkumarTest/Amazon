package demoofmodifiers;



public class myclass {
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
			
			
			myclass ob=new myclass();
			ob.a=19;
			ob.b=8.56;
			ob.c='j';
			ob.str="pradeep";
			ob.dipslay();
			System.out.println("..............");
			myclass obj=new myclass();
			
			obj.a=40;
			obj.b=18.56;
			obj.c='k';
			obj.str="pradeepkumar";
			obj.dipslay();
		}
	}


