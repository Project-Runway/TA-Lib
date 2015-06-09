package ratajczak.artur;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tictactec.ta.lib.CandleSettingType;
import com.tictactec.ta.lib.Compatibility;
import com.tictactec.ta.lib.FuncUnstId;
import com.tictactec.ta.lib.MAType;
import com.tictactec.ta.lib.RangeType;
import com.tictactec.ta.lib.RetCode;
import com.tictactec.ta.lib.meta.annotation.InputParameterType;
import com.tictactec.ta.lib.meta.annotation.OptInputParameterType;
import com.tictactec.ta.lib.meta.annotation.OutputParameterType;

public class TestEnumTypes {

	@Test
	public void testFuncUstId() {
		assertEquals(FuncUnstId.Adx, FuncUnstId.valueOf("Adx"));
	}
	
	@Test
	public void testCandleSettingTypes() {
		assertEquals(CandleSettingType.Equal, CandleSettingType.valueOf("Equal"));
	}
	
	@Test
	public void testRetCode() {
		assertEquals(RetCode.Success, RetCode.valueOf("Success"));
	}
	
	@Test
	public void testRangeType() {
		assertEquals(RangeType.Shadows, RangeType.valueOf("Shadows"));
	}
	
	@Test
	public void testCompatibility() {
		assertEquals(Compatibility.Metastock, Compatibility.valueOf("Metastock"));
	}
	
	@Test
	public void testMAType() {
		assertEquals(MAType.Wma, MAType.valueOf("Wma"));
	}
	
	@Test
	public void testInputParameterType() {
		assertEquals(InputParameterType.TA_Input_Real, InputParameterType.valueOf("TA_Input_Real"));
	}
	
	@Test
	public void testOptInputParameterType() {
		assertEquals(OptInputParameterType.TA_OptInput_RealList, OptInputParameterType.valueOf("TA_OptInput_RealList"));
	}
	

	@Test
	public void testOutputParameterType() {
		assertEquals(OutputParameterType.TA_Output_Integer, OutputParameterType.valueOf("TA_Output_Integer"));
	}

}
