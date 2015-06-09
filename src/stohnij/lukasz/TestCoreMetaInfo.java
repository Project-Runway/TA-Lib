package stohnij.lukasz;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;






import com.tictactec.ta.lib.meta.CoreMetaInfo;
import com.tictactec.ta.lib.meta.TaFuncMetaInfo;

public class TestCoreMetaInfo {
static CoreMetaInfo coremetainfo;
	
	
	@BeforeClass
	public static void beforeClass(){
		coremetainfo = new CoreMetaInfo();
	}
	
	
	@Test
	public void testget() {
		
	String taName = "lol";
	Class[] inVarTypes = null;
	
	TaFuncMetaInfo tfm = coremetainfo.get(taName, inVarTypes);
		
	}
	
	
	@Test
	public void testgetAllFuncs() {
		
	
	Collection<TaFuncMetaInfo> tfm = coremetainfo.getAllFuncs();
		
		
	}
	
	
	

}
