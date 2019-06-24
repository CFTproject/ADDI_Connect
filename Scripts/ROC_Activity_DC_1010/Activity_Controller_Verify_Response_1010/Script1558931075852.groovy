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

response = WS.sendRequest(findTestObject('ROC_Activity_DC_1010/Activity_Controller_Verify_Response_1010', [('Activity_URL') : URLS]))

WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response, '[0].mapName', 'P49ERRM')

WS.verifyElementPropertyValue(response, '[0].dataBaseAction', 'DISP')

String Mapnamesename = M_Name

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(response.getResponseBodyContent())

def map_name = result[0].mapName

if(map_name.equalsIgnoreCase(Mapnamesename))
{
	WS.verifyElementPropertyValue(response, '[0].activityType', 'DC')
	
}else {

println ('DC is not displayed in this record')

}