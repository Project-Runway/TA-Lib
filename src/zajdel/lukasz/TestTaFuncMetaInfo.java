package zajdel.lukasz;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.BeforeClass;
import org.junit.Test;

import com.tictactec.ta.lib.Core;
import com.tictactec.ta.lib.meta.TaFuncMetaInfo;
@SuppressWarnings("deprecation")
public class TestTaFuncMetaInfo {
	static TaFuncMetaInfo taFuncMetaInfo;
	
	   Method method =taFuncMetaInfo.getMethod();
	   Method lookbackMethod= taFuncMetaInfo.getLookbackMethod();

	@BeforeClass
	public static void beforeClass() {

	}

	@Test
	public void testTaFuncMetaInfo() {
		String nazwa = "Cosik";

		taFuncMetaInfo = new TaFuncMetaInfo(nazwa, method, lookbackMethod);
		
	}
	@Test
	public void testCreateVarTypes(){
		//taFuncMetaInfo.getNumberOfInputParameters();  // nie mozna wywolac tych funkcji, ktora jest w taFuncMetaInfo
		//taFuncMetaInfo.getNumberOfOutputParameters(); // a bez nich nie mozna utworzyc parametrow ktore pobieraja funkcje
		
	}

}
