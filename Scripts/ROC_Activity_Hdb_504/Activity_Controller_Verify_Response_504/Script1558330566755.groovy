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

response = WS.sendRequest(findTestObject('ROC_Activity_Hdb_504/Activity_Controller_Verify_Response_504', [('Activity_URL') : URLS]))

WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response, '[0].databaseName', 'CCTXNDB')

String Databasename = D_Name

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(response.getResponseBodyContent())

def database_name = result[0].databaseName

def dglist = result[0].listADG

println (dglist)

String[] dg = dglist.split(",")

println (dg[3])

if(database_name.equalsIgnoreCase(Databasename))
{
	WS.verifyElementPropertyValue(response, '[0].activityType', 'HDB')
	
}else {

println ('HDB is not displayed in this record')

}