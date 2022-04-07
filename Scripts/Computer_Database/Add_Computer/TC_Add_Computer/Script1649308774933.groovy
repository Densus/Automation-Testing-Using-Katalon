import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.concurrent.ThreadLocalRandom

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
import internal.GlobalVariable

import org.apache.commons.lang.RandomStringUtils
import org.openqa.selenium.Keys as Keys


Random randomDays = ThreadLocalRandom.current()
DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
LocalDateTime startDate = LocalDateTime.now().minusDays(randomDays.nextInt(365) + 1)
LocalDateTime endDate = LocalDateTime.now().plusDays(randomDays.nextInt(365) + 1)

//System.out.println("date: "+ startDate.format(dateTimeFormatter) + " dan " + endDate.format(dateTimeFormatter));
//
List<String> listCompanies = Arrays.asList("Nokia", "Apple Inc.", "RCA", "IBM", "Canon", "Sony", "Lenovo", "ASUS", "HTC", "Samsung", "Sun Microsystems")
Random r = new Random();
//System.out.println(listCompanies.get(r.nextInt(listCompanies.toArray().length)));
String companyName = listCompanies.get(r.nextInt(listCompanies.toArray().length))
String computerName = companyName + " " + RandomStringUtils.randomAlphabetic(20)


WebUI.click(findTestObject('Object Repository/Computer_Database/Computer_Page/addANewComputerButton'))
//
WebUI.setText(findTestObject('Object Repository/Computer_Database/Add_Computer_Page/computerNameField'),computerName)

WebUI.setText(findTestObject('Object Repository/Computer_Database/Add_Computer_Page/introducedField'),startDate.format(dateTimeFormatter))

WebUI.setText(findTestObject('Object Repository/Computer_Database/Add_Computer_Page/discontinuedField'),endDate.format(dateTimeFormatter))

WebUI.click(findTestObject('Object Repository/Computer_Database/Add_Computer_Page/companySelection',['text()':companyName]))

WebUI.click(findTestObject('Object Repository/Computer_Database/Add_Computer_Page/createThisComputerButton'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Computer_Database/Computer_Page/alertComputerCreated'))

