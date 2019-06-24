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

response = WS.sendRequest(findTestObject('Transaction_Scenario/ROC_hogan-connector_transaction'))

WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response, 'results[0].resolutions[0].action', 'call')

WS.verifyElementPropertyValue(response, 'results[0].resolutions[0].target.read', 'true')

WS.verifyElementPropertyValue(response, 'results[0].resolutions[0].target.resourceType', 'CobolProgram')

WS.verifyElementPropertyValue(response, 'results[0].resolutions[1].action', 'call')

WS.verifyElementPropertyValue(response, 'results[0].resolutions[1].target.read', 'true')

WS.verifyElementPropertyValue(response, 'results[0].resolutions[1].target.resourceType', 'CobolProgram')

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(response.getResponseBodyContent())

def program_name1 = result.results[0].resolutions[0].target.value

def program_name2 = result.results[0].resolutions[1].target.value

println (program_name1)

println (program_name2)

GlobalVariable.Program_Name1 = program_name1

GlobalVariable.Program_Name2 = program_name2

String value = '00319/00049 00101/00010'

String[] st = value.split(' ')

/*String application1 = '00049'

String function1 = '00319'

String application2 = '00010'

String function2 = '00101'*/

for(int i=0; i<=1; i++){

//String transaction_url = (('http://localhost:9090/hogan-connector/transaction/' + function1) + '/') + application1

String transaction_url = 'http://localhost:9090/hogan-connector/transaction/' + st[i]

println(transaction_url)

WS.callTestCase(findTestCase('Transaction_Scenario/hogan-connector_transaction_Function_Application'), [('Transaction_urls') :transaction_url ], FailureHandling.CONTINUE_ON_FAILURE)
}

