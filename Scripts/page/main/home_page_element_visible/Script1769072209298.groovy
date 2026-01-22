import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.TestObject
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import com.kms.katalon.core.webui.driver.DriverFactory

// Buka browser dan navigasi ke URL
WebUI.openBrowser('')
WebUI.navigateToUrl('https://advantageonlineshopping.com/')



// Tangkap semua elemen yang memiliki atribut sesuai category_text_clickable
// Cari semua elemen dengan findTestObject dan WebUI.findWebElements
TestObject categoryObj = findTestObject('Object Repository/category_text_clickable')
List<WebElement> categoryElements = WebUI.findWebElements(categoryObj, 10) as List<WebElement>

// Ambil parameter category_name dari test case pemanggil
String category_name = category_name

// Print dan cocokan dengan category_name
boolean found = false
for (WebElement el : categoryElements) {
	String text = el.getText()
	if (text.equalsIgnoreCase(category_name)) {
		println("MATCH: " + text)
		found = true
	} else {
		println("NO MATCH: " + text)
	}
}

// Jika tidak ditemukan match, testcase fail
assert found : "Category '" + category_name + "' tidak ditemukan di halaman!"

