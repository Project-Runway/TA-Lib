package stohnij.lukasz;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.tictactec.ta.lib.Core;
import com.tictactec.ta.lib.meta.CoreMetaData;
import com.tictactec.ta.lib.meta.TaGrpService;

public class TestCoreMetaData {
	static CoreMetaData coremetadata;
	
	
	@BeforeClass
	public static void beforeClass(){
		coremetadata = new CoreMetaData();
	}

	@Test
	public void testforEachGrp() {
	
		TaGrpService service = 12;
		
		int actual = coremetadata.forEachGrp(service);
			assertEquals(taGrpMap.get(group), actual);
			
	}

}
