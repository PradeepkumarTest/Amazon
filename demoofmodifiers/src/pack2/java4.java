package pack2;

import pack1.java1;

public class java4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		java3 ob = new java3();//protected not possible here becoz we do have to inheritence then accessibel possible
		ob.a = 19;// public
		ob.b = 8.56;
		ob.c = 'j';// protected
		ob.str = "pradeep";

		ob.dipslay();
	}

}
