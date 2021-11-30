package basic;

import java.util.Random;

/*
 * 실수 난수 발생
 */
public class DoubleRandom {
	public static void main(String[] args) {
		
		Random r = new Random();
		
		double x1 = r.nextDouble();
		double x2 = r.nextDouble()*10;
		double x3 = -1*r.nextDouble();
		double x4 = -1+2*r.nextDouble();
		
		System.out.println("0.0 ~ 1.0미만 난수: "+x1);
		System.out.println("1.0 ~ 10.0미만 난수: "+x2);
		System.out.println("-0.0 ~ -1.0미만 난수: "+x3);
		System.out.println("-1.0 ~ 1.0미만 난수: "+x4);
		
	}

}
