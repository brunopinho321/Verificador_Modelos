import java.time.Year;
import java.util.ArrayList;

import net.sf.javabdd.*;

public class Main {
	//pre-imagem fraca 
	public static BDD preImagemFraca(BDD y_DD, BDD t_DD, BDDPairing pair, ArrayList<BDD> proposicoes_linha) {
		// y'
		BDD y_linha_DD = y_DD.replace(pair);
		// (y'DD ^ tDD)
		BDD y_DD_and_t_DD = t_DD.andWith(y_linha_DD);
		
		BDD auxi; 
		//calculando pre imagem
		//prefraca(yDD) = Ep'Eq'Er'Es'(y'DD ^ tDD)
		for(BDD x : proposicoes_linha) {
			auxi = y_DD_and_t_DD.exist(x);
			y_DD_and_t_DD = auxi;
		}
		return y_DD_and_t_DD;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BDDFactory fac = JFactory.init(100, 100);
		int n = 4;
		
		fac.setVarNum(n*2);
		BDD p = fac.ithVar(0);
		BDD q = fac.ithVar(2);
		BDD r = fac.ithVar(4);
		BDD s = fac.ithVar(6);
	
		BDD pl = fac.ithVar(1);
		BDD ql = fac.ithVar(3);
		BDD rl = fac.ithVar(5);
		BDD sl = fac.ithVar(7);
		
		ArrayList<BDD> proposicoes_linha = new ArrayList<BDD>();
		proposicoes_linha.add(pl);
		proposicoes_linha.add(ql);
		proposicoes_linha.add(rl);
		proposicoes_linha.add(sl);
		
		BDD s0 = p.and(q.not().and(r.not().and(s.not())));
		
		BDD s1 = p.not().and(q.not().and(r.not().and(s.not()))); 
		BDD s1l = pl.not().and(ql.not().and(rl.not().and(sl.not())));
		
		BDD s2 = p.and(q.and(r.not().and(s.not())));
		BDD s2l = pl.and(ql.and(rl.not().and(sl.not())));
		
		BDD s3 = p.and(q.not().and(r.not().and(s)));
		BDD s3l = pl.and(ql.not().and(rl.not().and(sl)));
		
		BDD s4 = p.and(q.not().and(r.and(s.not())));
		BDD s4l = pl.and(ql.not().and(rl.and(sl.not())));
		
		BDD s5 = p.not().and(q.not().and(r.and(s.not())));
		BDD s5l = pl.not().and(ql.not().and(rl.and(sl.not())));
		
		BDD s6 = p.and(q.not().and(r.and(s)));
		BDD s6l = pl.and(ql.not().and(rl.and(sl)));
		
		BDD s7 = p.not().and(q.not().and(r.not().and(s)));
		BDD s7l = pl.not().and(ql.not().and(rl.not().and(sl)));
		
		BDD s8 = p.not().and(q.and(r.and(s.not())));
		BDD s8l = pl.not().and(ql.and(rl.and(sl.not())));
		
		BDD s9 = p.and(q.and(r.and(s.not())));
		BDD s9l = pl.and(ql.and(rl.and(sl.not())));
		
		BDD s10 = p.not().and(q.and(r.not().and(s.not())));
		BDD s10l = pl.not().and(ql.and(rl.not().and(sl.not())));
		
		BDD s11 = p.not().and(q.and(r.not().and(s)));
		BDD s11l = pl.not().and(ql.and(rl.not().and(sl)));
		
		BDD s12 = p.and(q.and(r.not().and(s)));
		BDD s12l = pl.and(ql.and(rl.not().and(sl)));
		
		BDD s13 = p.not().and(q.and(r.and(s)));
		BDD s13l = pl.not().and(ql.and(rl.and(sl)));
		
		BDD s14 = p.and(q.and(r.and(s)));
		BDD s14l = pl.and(ql.and(rl.and(sl)));
		
		BDD s15 = p.not().and(q.not().and(r.and(s)));
		BDD s15l = pl.not().and(ql.not().and(rl.and(sl)));
		
		BDD s0s1 = s0.and(s1l);
		BDD s0s4 = s0.and(s4l);
		BDD s1s2  = s1.and(s2l);
		BDD s1s5  = s1.and(s5l);
		BDD s1s6  = s1.and(s6l);
		BDD s2s3  = s2.and(s3l);
		BDD s3s7  = s3.and(s7l);
		BDD s4s8  = s4.and(s8l);
		BDD s5s8  = s5.and(s8l);
		BDD s5s9  = s5.and(s9l);
		BDD s5s10  = s5.and(s10l);
		BDD s6s7  = s6.and(s7l);
		BDD s7s11  = s7.and(s11l);
		BDD s8s12  = s8.and(s12l);
		BDD s9s13  = s9.and(s13l);
		BDD s10s14  = s10.and(s14l);
		BDD s10s11  = s10.and(s11l);
		BDD s11s7  = s11.and(s7l);
		BDD s11s15  = s11.and(s15l);
		BDD s12s13  = s12.and(s13l);
		BDD s13s12  = s13.and(s12l);
		BDD s13s14  = s13.and(s14l);
		BDD s14s15  = s14.and(s15l);
		BDD s15s15  = s15.and(s15l);
		
		//modelo
		BDD t_DD = s0s1.or(s0s4.or(s1s2.or(s1s5.or(s1s6.or(
				s2s3.or(s3s7.or(s4s8.or(s5s8.or(s5s9.or(s5s10.or(
						s6s7.or(s7s11.or(s8s12.or(s9s13.or(s10s14.or(s10s11.or(
								s11s7.or( s11s15.or(s12s13.or(s13s12.or(s13s14.or(
										s14s15.or(s15s15)))))))))))))))))))))));
		
	
		
		fac = t_DD.getFactory();
		BDDPairing pair = fac.makePair();
		
		for(int i = 0; i < (n*2); i=i+2) {
			pair.set(i, i+1);
		}
		
		BDD y_DD = s3;
		
		BDD pre_imagem_y = preImagemFraca(y_DD, t_DD, pair, proposicoes_linha);
		System.out.println(pre_imagem_y);

	}
 
}
