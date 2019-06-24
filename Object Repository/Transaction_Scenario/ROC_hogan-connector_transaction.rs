<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>ROC_hogan-connector_transaction</name>
   <tag></tag>
   <elementGuidId>0a5e47df-e407-4d76-b0a8-12fdd33d7e5a</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\&quot;schemaVersion\&quot;:\&quot;1.0\&quot;,\n\&quot;inputs\&quot;:[{\&quot;id\&quot;:\&quot;0\&quot;,\n\&quot;apiKey\&quot;:\&quot;BATCHPEM\&quot;,\n\&quot;apiText\&quot;:\&quot;BATCHPEM\&quot;,\n\&quot;params\&quot;:[{\&quot;paramKey\&quot;:\&quot;ddKey\&quot;,\n\&quot;paramMode\&quot;:\&quot;byValue\&quot;,\n\&quot;value\&quot;:\&quot;1111 49 319 \n\\\\n#107¬DUMP¬1111¬CIF¬¬¬¬%               * DUMP CIF                       \n\\\\n1111 10 101                         \n\\\\n#107¬DUMP¬1111¬CRK¬¬¬¬%               * DUMP CRK                       \n\\\\n1111 49 319                                                            \n\\\\n#107¬DUMP¬1111¬CHF¬¬¬¬%               * DUMP CHF                       \n\\\\n1111 49 319-DUMP¬1111¬CRK¬¬¬¬%                                                              \n\\\\n#107¬DUMP¬1111¬ADF¬¬¬¬%               * DUMP ADF                       \n\\\\n1111 49 319                                                            \n\\\\n#107¬DUMP¬1111¬HRK¬¬¬¬%               * DUMP HRK                       \n\\\\n1111 49 319                                                            \n\\\\n#107¬DUMP¬1111¬AIF¬¬¬¬%               * DUMP AIF                       \n\\\\n1111 49 319                                                            \n\\\\n#107¬DUMP¬1111¬ARK¬¬¬¬%               * DUMP ARK                       \n\\\\n1111 49 319                                                            \n\\\\n#107¬DUMP¬1111¬CRF¬¬¬¬%               * DUMP CRF                       \n\\\\n1111 49 319                                                            \n\\\\n#107¬DUMP¬1111¬CDS¬¬¬¬%               * DUMP CDS                       \n\\\\n1111 49 319                                                            \n\\\\n#107¬DUMP¬1111¬RPM¬¬¬¬%               * DUMP RPM                       \n\\\\n1111 49 319                                                            \n\\\\n#107¬DUMP¬1111¬RPMP¬¬¬¬%              * DUMP RPMP                      \n\\\\n1111 49 319                                                            \n\\\\n#107¬DUMP¬1111¬CISC¬¬¬¬%              * DUMP CISC \&quot;}\n]}]}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>http://localhost:9090/hogan-connector/transaction?</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
