import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

response = WS.sendRequest(findTestObject('Roc_DEP_Transaction_Program/ROC_DEP_hogan_connector_txn_pgm'))

WS.verifyResponseStatusCode(response, 200)

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(response.getResponseBodyContent())

for (int i = 0; i <=20; i++) {
	
	//WS.verifyElementPropertyValue(response, 'results[0].resolutions['+i+'].source.resourceType', 'GenericTransaction')
	
	//WS.verifyElementPropertyValue(response, 'results[0].resolutions['+i+'].target.resourceType', 'AssemblerProgram' || 'CobolProgram')
	
    def function_application = result.results[0].resolutions[i].source.value
    
    def activityId = result.results[0].resolutions[i].target.annText
	
	String[] st = activityId.split(' ')
	
	String activity_id = st[0]

    def program_Name = result.results[0].resolutions[i].target.value

    String activity_controller_url = 'http://localhost:9090/hogan-connector/activity/' + activity_id
	
    WS.callTestCase(findTestCase('Roc_DEP_Transaction_Program/Activity_Controller_Verify_Response'), [('activityid_url') : activity_controller_url
            , ('pro_name') : program_Name], FailureHandling.CONTINUE_ON_FAILURE)
	
	String str = function_application

	String[] s = str.split(',')	
		
	String application = s[0]	
		
	String function = s[1]			
	
	String transaction_controller_url = 'http://localhost:9090/hogan-connector/transaction/'+ function +'/'+ application
	
	println('Activity Controller Url - ' + i +':-- '+ activity_controller_url)
	println('Transaction Controller Url - ' + i +':-- '+ transaction_controller_url)
	
    WS.callTestCase(findTestCase('Roc_DEP_Transaction_Program/Transaction_Controller_Verify_Response'), [('transaction_url') : transaction_controller_url, 
      ('Function') : function, ('Application') : application],  FailureHandling.CONTINUE_ON_FAILURE)
}