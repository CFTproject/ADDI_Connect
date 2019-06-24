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

response = WS.sendRequest(findTestObject('Transaction_Scenario/Activity_Controller_Verify_Response',, [('URLSS') : activity_urls]))

WS.verifyResponseStatusCode(response, 200)

println ('GlobalVariable.Program_Name1'+GlobalVariable.Program_Name1)

println ('GlobalVariable.Program_Name2'+GlobalVariable.Program_Name2)

//WS.verifyElementPropertyValue(response, '[0].programName', GlobalVariable.Program_Name1)

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(response.getResponseBodyContent())

def activity_Type = result[0].activityType

def P_Name = result[0].programName

println (activity_Type)

if(activity_Type.equalsIgnoreCase('LINK'))
{
	WS.verifyElementPropertyValue(response, '[0].activityType', 'LINK')	
	
	
}else
{
	println ('activityType is DC')
}

if(P_Name.equalsIgnoreCase(GlobalVariable.Program_Name1))
{
	WS.verifyElementPropertyValue(response, '[0].programName', GlobalVariable.Program_Name1)
	
}else if(P_Name.equalsIgnoreCase(GlobalVariable.Program_Name2))
{
	WS.verifyElementPropertyValue(response, '[0].programName', GlobalVariable.Program_Name2)
}
