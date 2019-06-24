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

response = WS.sendRequest(findTestObject('ROC_Activity_Sdb_114/Roc_hogan_connector_activity_Sdb_114'))

WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response, 'results[0].resolutions[0].action', 'FileWrite')

WS.verifyElementPropertyValue(response, 'results[0].resolutions[0].resources[0].annKeyword', 'ActivityID')

WS.verifyElementPropertyValue(response, 'results[0].resolutions[0].resources[0].read', 'true')

//WS.verifyElementPropertyValue(response, 'results[0].resolutions[0].resources[0].annText', '114')

WS.verifyElementPropertyValue(response, 'results[0].resolutions[0].resources[0].value', 'PRINT')

WS.verifyElementPropertyValue(response, 'results[0].resolutions[0].resources[0].resourceType', 'File')

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(response.getResponseBodyContent())

def activityid = result.results[0].resolutions[0].resources[0].annText

println('activityid:- ' + activityid)

def DataBase_Name = result.results[0].resolutions[0].resources[0].value

String activity_url = 'http://localhost:9090/hogan-connector/activity/0000000114' 
//+ activityid

println('activity_url is :- ' + activity_url)

WS.callTestCase(findTestCase('ROC_Activity_Sdb_114/Activity_Controller_Verify_Response_114'), [('URLS') : activity_url, ('D_Name') : DataBase_Name], FailureHandling.CONTINUE_ON_FAILURE)

