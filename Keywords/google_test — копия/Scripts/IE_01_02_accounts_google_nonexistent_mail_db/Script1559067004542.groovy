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

'ввод несуществующего в базе значения'
WebUI.setText(findTestObject('Page_ Google/input_Google_identifier'), 'ne2019sushestvuet@gmail.com')

'проверяем соответствие названия элемента "Далее"'
WebUI.verifyElementText(findTestObject('Page_ Google/span_NEXT'), 'Далее')

WebUI.click(findTestObject('Page_ Google/span_NEXT'))

'проверяем наличие элемента'
WebUI.verifyElementPresent(findTestObject('Page_ Google/div_not_account'), 30)

'проверяем соответсвие названию действия'
WebUI.verifyElementText(findTestObject('Page_ Google/div_not_account'), 'Не удалось найти аккаунт Google')

'получаем цвета текст'
css_color_text = WebUI.getCSSValue(findTestObject('Page_ Google/div_not_account'), 'color')

'проверяем соотвествие цвета текста'
WebUI.verifyEqual(css_color_text, 'rgba(217, 48, 37, 1)')

'получаем параметры рамки'
css_border = WebUI.getCSSValue(findTestObject('Page_ Google/div_for_border_red'), 'border-color')

'проверяем соотвествие параметрам рамки'
WebUI.verifyEqual(css_border, '#d93025')

WebUI.closeBrowser()

