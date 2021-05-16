package Soap;
import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCaseRunner;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.support.SoapUIException;

public class TestRunner {
	
	@Test
	public void soapTest() throws XmlException, IOException, SoapUIException {
		//Grab Soap UI Project
		WsdlProject project = new WsdlProject("D:\\SoapUI_WorkPlace\\8-EmployeeWebServiceWithFramework-soapui-project.xml");
		WsdlTestSuite testSuite = project.getTestSuiteByName("Testing");  	//Grab testSuite name
		
	
		for(int i=0; i<testSuite.getTestCaseCount(); i++) {      	          //Get all the testcases one by one.
			WsdlTestCase testCase = testSuite.getTestCaseAt(i); 			//Grab testCase name
			 WsdlTestCaseRunner runner = testCase.run(new PropertiesMap(), false);	//execute perticular testcase		 
			 Assert.assertEquals(Status.FINISHED, runner.getStatus());			
		}
		
	}

}
