# DemoQA UI Automation with Selenium and JUnit

This project is a complete web UI automation test suite built using **Java**, **Selenium WebDriver**, and **JUnit 5**. The test cases are designed around the components available on [DemoQA](https://demoqa.com), a demo site commonly used for practicing test automation.

## 🧪 Project Overview

The purpose of this project is to demonstrate hands-on experience with:
- Automated UI interactions using Selenium WebDriver
- JUnit-based test lifecycle management
- Assertions and validations
- Handling browser windows, frames, alerts, dropdowns, and more

## ✅ Features Covered

### 📄 General Website Automation
- Visit and validate page titles
- Fill out and submit forms
- Extract and verify submitted data

### 🖱️ Mouse and Keyboard Actions
- Double-click, right-click, and single click using the `Actions` class
- Mouse hover over multiple menu items (AIUB site)
- Keyboard input using `Keys` (e.g., date selection, dropdowns)

### 📊 Table Data Extraction
- Scrape and print dynamic table data from the web page
- Locate table rows and cells using CSS selectors

### ⚠️ Alert and Frame Handling
- Accept browser alerts
- Switch between iframes and return to default content

### 🧭 Dropdown and Date Picker Interaction
- Interact with standard and custom dropdowns
- Set date using the date picker field

### 🔗 Multi-Window and Tab Handling
- Open new tabs and windows
- Switch between window handles and validate content

## 🛠️ Technologies Used

| Tool/Framework | Purpose                        |
|----------------|--------------------------------|
| Java           | Main programming language      |
| Selenium WebDriver | UI automation tool         |
| JUnit 5        | Test structure and assertions  |
| ChromeDriver   | Browser automation             |

## 🔧 Prerequisites

- Java JDK 11 or higher installed  
- Chrome browser installed  
- ChromeDriver added to system `PATH`  
- IntelliJ IDEA or Eclipse IDE  
- JUnit 5 and Selenium libraries configured in your project

---

## ▶️ How to Run

1. Clone this repository  
2. Open the project in your IDE  
3. Run `MyJunit.java` as a JUnit test class  
4. (Optional) Uncomment `driver.quit()` in `@AfterAll` to auto-close browser after tests

### 🧾 Test Execution Report (HTML Screenshot)
![Image alt text](https://github.com/abhishek11das/selenium-junit-demoqa-automation/blob/abefbc2a9a57ce47816a8688ef1a702e23f3a37b/Report.png?raw=true)

