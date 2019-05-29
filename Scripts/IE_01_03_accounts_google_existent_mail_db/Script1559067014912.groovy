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

WebUI.openBrowser('https://accounts.google.com/')

'ввод существующего в базе значения'
WebUI.setText(findTestObject('Page_ Google/input_Google_identifier'), '654321@gmail.com')

'проверяем соответствие названия элемента "Далее"'
WebUI.verifyElementText(findTestObject('Page_ Google/span_NEXT'), 'Далее')

WebUI.click(findTestObject('Page_ Google/span_NEXT'))

'проверяем наличие элемента'
WebUI.verifyElementPresent(findTestObject('Page_ Google/input_password'), 30)

'проверяем соответсвие названию действия'
WebUI.verifyElementText(findTestObject('Page_ Google/input_password'), 'Введите пароль')

WebUI.closeBrowser()

