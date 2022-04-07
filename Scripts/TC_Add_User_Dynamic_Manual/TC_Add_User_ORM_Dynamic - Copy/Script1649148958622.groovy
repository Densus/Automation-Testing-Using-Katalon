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
import org.apache.commons.lang.RandomStringUtils

String username = 'Admin'
String password = 'admin123'
String dynamicUsername = 'Cecil.Bonaparte' + RandomStringUtils.randomNumeric(5)
String employeeName = 'Cecil Bonaparte'
String dynamicPassword = RandomStringUtils.randomAlphanumeric(8) 


//WebUI.openBrowser('')

WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/index.php/auth/login')

WebUI.setText(findTestObject('Orange_HRM/Login_Page/InputUsername'), username)

WebUI.setText(findTestObject('Orange_HRM/Login_Page/inputPassword'), password)

WebUI.click(findTestObject('Orange_HRM/Login_Page/buttonLogin'))

WebUI.verifyElementPresent(findTestObject('Orange_HRM/Login_Page/textWelcome'), 5)

//Call login test case
//WebUI.callTestCase(findTestCase('TC_Login/TC_Login_ORM_Unclosed'), [('username'):'Admin', ('password'):'admin123'], FailureHandling.OPTIONAL)

//Click menu admin
WebUI.click(findTestObject('Orange_HRM/User_Management_Page/menuAdmin'))

//Click button add
WebUI.click(findTestObject('Orange_HRM/User_Management_Page/buttonAdd'))

//Click user role field
WebUI.click(findTestObject('Orange_HRM/User_Management_Page/selectUserRole'))

//Select user role
WebUI.click(findTestObject('Orange_HRM/User_Management_Page/selectedUserRoleESS'))

//Input employee name
WebUI.setText(findTestObject('Orange_HRM/User_Management_Page/textFieldEmployeeName'), employeeName)

//Select employee
WebUI.click(findTestObject('Orange_HRM/User_Management_Page/selectedFieldEmployeeNameCecilBonaParte'))

//Input username
WebUI.setText(findTestObject('Orange_HRM/User_Management_Page/textFieldUsername'), dynamicUsername)

//Click status field
WebUI.click(findTestObject('Orange_HRM/User_Management_Page/selectStatus'))

//Select status
WebUI.click(findTestObject('Orange_HRM/User_Management_Page/selectedStatusEnabled'))

//Input password
WebUI.setText(findTestObject('Orange_HRM/User_Management_Page/textFieldPassword'), dynamicPassword)

//Input confirm password
WebUI.setText(findTestObject('Orange_HRM/User_Management_Page/textFieldConfirmPassword'), dynamicPassword)

//Click button save
WebUI.click(findTestObject('Orange_HRM/User_Management_Page/buttonSave'))

//Input search username field
WebUI.setText(findTestObject('Orange_HRM/User_Management_Page/searchUsernameField'), dynamicUsername)

//Click button search
WebUI.click(findTestObject('Orange_HRM/User_Management_Page/buttonSearch'))

//Validate username exist in the table
WebUI.verifyElementPresent(findTestObject('Orange_HRM/User_Management_Page/usernameSearchResult',['text()':dynamicUsername]), 2)

//Close the browser
//WebUI.closeBrowser()