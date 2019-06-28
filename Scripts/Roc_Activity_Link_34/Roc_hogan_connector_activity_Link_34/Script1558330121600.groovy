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

response = WS.sendRequest(findTestObject('Roc_Activity_Link_34/Roc_hogan_connector_activity_Link_34'))

WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response, 'results[0].resolutions[0].action.', 'call')

WS.verifyElementPropertyValue(response, 'results[0].resolutions[0].target.annKeyword', 'ActivityID')

WS.verifyElementPropertyValue(response, 'results[0].resolutions[0].target.read', 'true')

WS.verifyElementPropertyValue(response, 'results[0].resolutions[0].target.annText', '34 Issue exception acty 23 using TCB$USCC')

WS.verifyElementPropertyValue(response, 'results[0].resolutions[0].target.value', 'P49135')

WS.verifyElementPropertyValue(response, 'results[0].resolutions[0].target.resourceType', 'CobolProgram')



def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(response.getResponseBodyContent())

def activityid = result.results[0].resolutions[0].target.annText

String[] str = activityid.split(' ')

String activity_id = str[0]

println('activity_id:- ' + activity_id)

def programeName = result.results[0].resolutions[0].target.value

String activity_url = 'http://localhost:9090/hogan-connector/activity/00000000'+activity_id

println('activity_url is :- ' + activity_url)

WS.callTestCase(findTestCase('Roc_Activity_Link_34/Activity_Controller_Verify_Response_34'), [('URLS') : activity_url, ('P_Name') : programeName], FailureHandling.CONTINUE_ON_FAILURE)



