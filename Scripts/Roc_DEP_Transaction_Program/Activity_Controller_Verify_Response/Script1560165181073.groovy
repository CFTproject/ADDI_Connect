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

response = WS.sendRequest(findTestObject('Roc_DEP_Transaction_Program/Activity_Controller_Verify_Response', [('URLS') : activityid_url]))

WS.verifyResponseStatusCode(response, 200)

String P_Name = pro_name

println('public variable _program_Name:- ' + P_Name)

WS.verifyElementPropertyValue(response, '[0].programName', P_Name)

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(response.getResponseBodyContent())

def programname = result[0].programName

def activitytype = result[0].activityType

if(activitytype.equalsIgnoreCase('LINK'))
{
	WS.verifyElementPropertyValue(response, '[0].programName', P_Name)
	
	println ('programname is :- ' +programname + '   Activity type is :- '+activitytype)
	
}else
{

	println (programname+'  progrname or program id is not exist in this record')

}