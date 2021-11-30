package exam;

import java.util.Random;

public class Avengers_Polymorphism {
	
	public static void main(String[] args) {
		Random r = new Random();
		Avengers_Polymorphism p = new Avengers_Polymorphism();
		
		Avengers[] aven = {
				new IronMan(),
				new Thor(),
				new CaptainAmerica(),
				new HawkEye(),
				new Hulk(),
				new BlackWidow(),
				new Loki()
		};
		
		for (int i = 0; i < 20; i++) {
			int index = r.nextInt(7);
		if(	p.whoAreyou(aven[index])) break;
			try { // ait+shift+z 하면 자동으로 감싸기
				Thread.sleep(700);
			} catch (Exception e) {
			}
		}


	}
	
	public boolean whoAreyou(Avengers a ){
		
		boolean isLoki=false;
		
		if(a instanceof IronMan) {
			System.out.println("I AM IRONMAN");
		}else if (a instanceof Thor) {
			System.out.println("I AM Thor");
		} else if(a instanceof CaptainAmerica) {
			System.out.println("I AM CaptainAmerica");
		}else if(a instanceof Hulk) {
			System.out.println("I AM GreenMonster");
		}else if(a instanceof BlackWidow) {
			System.out.println("I AM BlackWidow");
		}else if(a instanceof HawkEye) {
			System.out.println("I AM HawkEye");
		}else if(a instanceof Loki) {
			System.out.println("※ We found Loki ※");
			isLoki = true;
		}	else {System.out.println("Villanin");}
		return isLoki;
	}


	


}


class Avengers{
	public void fight() {
		System.out.println("--Avengers Assemble--");
	}
}

class IronMan extends Avengers{
	@Override
	public void fight() {
		System.out.println("Iron Beam!!");
	}
}

class Thor extends Avengers{
	@Override
	public void fight() {
		System.out.println("Thunder Hammer!!");
	}
}

class Hulk extends Avengers{
	@Override
	public void fight() {
		System.out.println("Big green monster!!");
	}
}

class CaptainAmerica extends Avengers{
	@Override
	public void fight() {
		System.out.println("Throw the shield!");
	}
}

class HawkEye extends Avengers{
	@Override
	public void fight() {
		System.out.println("Arrow bomb!");
	}
}

class BlackWidow extends Avengers{
	@Override
	public void fight() {
		System.out.println("Kick and Punch!");
	}
}

class Loki extends Avengers{
	@Override
	public void fight() {
		System.out.println("Duplication");
	}
}

