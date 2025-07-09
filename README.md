
DemoQA UI Automation Using Selenium and JUnit
This project is a complete UI automation test suite built with Java, Selenium WebDriver, and JUnit 5. It focuses on automating and testing different components from DemoQA, a popular practice site for web testing.

🔍 Project Objective
To demonstrate hands-on experience in:

Automating UI interactions with Selenium WebDriver

Structuring tests using JUnit 5

Performing validations through assertions

Handling alerts, iframes, windows, dropdowns, mouse/keyboard actions, and more

✅ Key Features
🌐 General Automation
Navigate to pages and verify titles

Fill out and submit forms

Extract and validate input data

🖱️ Mouse & Keyboard Actions
Perform double-click, right-click, and single-click using the Actions class

Hover over menu items (example: AIUB Website)

Use keyboard input with Keys class (e.g., dropdown and date picker interaction)

📊 Web Table Interaction
Scrape and display dynamic table content

Locate rows and cells using CSS selectors

⚠️ Alerts & Frames
Handle browser alerts

Switch between iframes and return to the main content

📅 Dropdowns & Date Pickers
Interact with both standard and custom dropdown menus

Select dates using input or calendar widget

🪟 Window & Tab Management
Open and manage multiple browser tabs or windows

Switch between them using window handles

🛠️ Tools & Technologies
Tool	Purpose
Java	Programming language
Selenium WebDriver	Browser automation
JUnit 5	Test framework
ChromeDriver	Browser driver for Chrome

⚙️ Requirements
Before running the tests, ensure you have:

Java JDK 11 or higher

Google Chrome browser installed

ChromeDriver added to system PATH

IDE (e.g., IntelliJ IDEA or Eclipse)


---

## ▶️ How to Run

1. Clone this repository  
2. Open the project in your IDE  
3. Run `MyJunit.java` as a JUnit test class  
4. (Optional) Uncomment `driver.quit()` in `@AfterAll` to auto-close browser after tests

### 🧾 Test Execution Report (HTML Screenshot)
![Image alt text](https://github.com/abhishek11das/selenium-junit-demoqa-automation/blob/abefbc2a9a57ce47816a8688ef1a702e23f3a37b/Report.png?raw=true)

