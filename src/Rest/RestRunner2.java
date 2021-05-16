package Rest;
import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCaseRunner;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.support.SoapUIException;

public class RestRunner2 {
	
	@Test
	public void runAllTestSuite() throws XmlException, IOException, SoapUIException {
		
		WsdlProject project = new WsdlProject("D:\\SoapUI_WorkPlace\\8-LibraryAPIWithFramework-soapui-project.xml");
		//pick each testsuite		
		for(int j=0 ; j<project.getTestSuiteCount();j++) {
			WsdlTestSuite testSuite = project.getTestSuiteAt(j);
			//pick each testcase
			for(int i=0; i<testSuite.getTestCaseCount(); i++) {
				WsdlTestCase testCase = testSuite.getTestCaseAt(i);
				 WsdlTestCaseRunner runner = testCase.run(new PropertiesMap(), false);			 
				 Assert.assertEquals(Status.FINISHED, runner.getStatus());			
			}
		}
		
				
	}

}

