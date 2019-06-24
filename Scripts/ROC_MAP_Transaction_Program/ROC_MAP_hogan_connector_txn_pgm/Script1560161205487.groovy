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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

response = WS.sendRequest(findTestObject('ROC_MAP_Transaction_Program/ROC_MAP_hogan_connector_txn_pgm'))

WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response, 'results[0].resolutions[0].source.resourceType', 'CICSMap')

WS.verifyElementPropertyValue(response, 'results[0].resolutions[0].target.resourceType', 'CobolProgram')

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(response.getResponseBodyContent())

for (int i = 0; i <= 20; i++) {
	
    def Map_Name = result.results[0].resolutions[i].source.value

    def activityId = result.results[0].resolutions[i].target.annText
	
	String[] st = activityId.split(' ')
	
	String activity_id = st[0]

    def program_Name = result.results[0].resolutions[i].target.value

    String activity_controller_url = 'http://localhost:9090/hogan-connector/activity/' + activity_id
    
    WS.callTestCase(findTestCase('ROC_MAP_Transaction_Program/Activity_Controller_Verify_Response'), [('activityid_url') : activity_controller_url
            , ('pro_name') : program_Name], FailureHandling.CONTINUE_ON_FAILURE)

    String map_transaction_controller_url = 'http://localhost:9090/hogan-connector/map/' + Map_Name

    println((('Activity Controller Url - ' + i) + ':-- ') + activity_controller_url)

    println((('MAP Transaction Controller Url - ' + i) + ':-- ') + map_transaction_controller_url)
	
			WS.callTestCase(findTestCase('ROC_MAP_Transaction_Program/Map_Controller_Verify_Response'), [('transaction_url') : map_transaction_controller_url
            ,('M_name') : Map_Name], FailureHandling.CONTINUE_ON_FAILURE)
}



