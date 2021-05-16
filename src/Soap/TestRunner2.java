package Soap;
import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.support.SoapUIException;

public class TestRunner2 {
	
	
	@Test
	public void singleTest() throws XmlException, IOException, SoapUIException {		
		
		WsdlProject project = new WsdlProject("D:\\SoapUI_WorkPlace\\8-EmployeeWebServiceWithFramework-soapui-project.xml");
		WsdlTestSuite testSuite = project.getTestSuiteByName("Testing");
		
		WsdlTestCase testCase = testSuite.getTestCaseByName("GetEmployee");
		
		TestRunner runner = testCase.run(new PropertiesMap(), false); 
		
		Assert.assertEquals(Status.FINISHED, runner.getStatus());
	}

}
