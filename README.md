# 🚀 AutoIT File Upload Automation using Selenium WebDriver

This project demonstrates how to automate file uploads in web applications using **Selenium WebDriver (Java)** along with **AutoIT** for handling OS-level file dialog interactions that Selenium cannot directly access.

## ✅ Features

- Automates file uploads using AutoIT `.exe` scripts.
- Integrates with Selenium WebDriver for web automation.
- Configures Chrome for custom download directory.
- Verifies file download success using Java.
- Supports Maven-based Java project setup.

## 🛠️ Requirements

- Java 8 or later
- Maven
- Eclipse or IntelliJ
- AutoIT installed (for `.exe` file generation)
- Google Chrome + compatible ChromeDriver
- TestNG (optional for assertions)

 ## Project Structure 
 project/
└── src/
└── defaultPackage
├── FileUploadAutoIT.java
└── windowHandling.java

## 🔧 Setup Instructions

1. **Clone the repository:**

   ```bash
   git clone https://github.com/your-username/AutoIT-FileUpload.git
   cd AutoIT-FileUpload

2. Install AutoIT:

Download and install AutoIT from:
https://www.autoitscript.com/site/autoit/downloads/

3. Write and compile an AutoIT script:
   
AutoItSetOption("WinTitleMatchMode", 2)

ControlFocus("Open", "", "Edit1")
ControlSetText("Open", "", "Edit1", "C:\\Path\\To\\Your\\File.pdf")
ControlClick("Open", "", "Button1")

Compile it into an .exe file using the AutoIT Script Editor.

4. Update the .java file to call the AutoIT executable:
   
Runtime.getRuntime().exec("P:\\Path\\To\\fileUpload.exe");

5. Make sure download.default_directory is set in ChromeOptions:

chromePrefs.put("download.default_directory", "C:\\Your\\Download\\Path");

6. Build and run the Maven project:

You can use Eclipse or run:
mvn clean compile exec:java


