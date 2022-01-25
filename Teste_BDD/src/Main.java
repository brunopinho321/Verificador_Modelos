import net.sf.javabdd.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BDDFactory fac = JFactory.init(100, 100);
		
		
		fac.setVarNum(4);
		BDD p = fac.ithVar(0);
		BDD q = fac.ithVar(1);
		BDD r = fac.ithVar(2);
		BDD s = fac.ithVar(3);
		
		
		//BDD s6 = p.and(q.not().and(r.and(s.not())))
		//s6.printDot();
		
		//BDD s14 = p.and(q.and(r.and(s)));
		//s14.printDot();
		
		BDD s1 = p.not().and(q.not().and(r.not().and(s.not())));
		s1.printDot();
	}

}
