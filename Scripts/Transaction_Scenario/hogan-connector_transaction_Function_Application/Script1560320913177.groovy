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

response = WS.sendRequest(findTestObject('Transaction_Scenario/hogan-connector_transaction_Function_Application', [('URLS') : Transaction_urls]))

WS.verifyResponseStatusCode(response, 200)

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(response.getResponseBodyContent())

def activity_id = result[0].listActivities

String str = activity_id

String[] s = str.split(' ')

for (int i = 0; i <= 1; i++) {
   
    String activity_url = 'http://localhost:9090/hogan-connector/activity/' + (s[i])

    println(activity_url)
	
	WS.callTestCase(findTestCase('Transaction_Scenario/Activity_Controller_Verify_Response'), [('activity_urls') : activity_url], FailureHandling.CONTINUE_ON_FAILURE)
}



