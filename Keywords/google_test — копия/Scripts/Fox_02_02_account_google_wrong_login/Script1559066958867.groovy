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

'ввод неверного значения почты'
WebUI.setText(findTestObject('Page_ Google/input_Google_identifier'), 'неверное@gmail.com')

'проверяем соответствие названия элемента "Далее"'
WebUI.verifyElementText(findTestObject('Page_ Google/span_NEXT'), 'Далее')

WebUI.click(findTestObject('Page_ Google/span_NEXT'))

'получаем параметры рамки'
css_border = WebUI.getCSSValue(findTestObject('Page_ Google/div_for_border_red'), 'border-top-color')

'проверяем соотвествие параметрам рамки'
WebUI.verifyEqual(css_border, 'rgb(217, 48, 37)')

'проверяем соответствующий текст'
WebUI.verifyElementText(findTestObject('Page_ Google/warning_text_red'), 'Введите адрес электронной почты или номер телефона.')

'получаем цвета текст'
css_color_text = WebUI.getCSSValue(findTestObject('Page_ Google/warning_text_red'), 'color')

'проверяем соотвествие цвета текста'
WebUI.verifyEqual(css_color_text, 'rgb(217, 48, 37)')

WebUI.closeBrowser()

