### selenium-testng-maven
# Seleneium TestNG Maven project

[![Circle CI](https://circleci.com/gh/nguoianphu/selenium-testng-maven.svg?style=svg)](https://circleci.com/gh/nguoianphu/selenium-testng-maven)

[![Build Status](https://buildhive.cloudbees.com/job/nguoianphu/job/selenium-testng-maven/badge/icon)](https://buildhive.cloudbees.com/job/nguoianphu/job/selenium-testng-maven/)

## Run
```mvn clean install```

---

### Source

## Maven & Jenkins with Selenium: Complete Tutorial 
http://www.guru99.com/maven-jenkins-with-selenium-complete-tutorial.html

---

Step1) In Eclipse IDE, select Help | Install New Software from Eclipse Main Menu.

Step 2) On the Install dialog, select Work with and m2e plugin as shown in the following screenshot: 

http://cdn.guru99.com/images/5-2015/050115_1023_MavenJenkin1.png

Step 3)Click on Next button and finish installation.

Configure Eclipse with Maven

With m2e plugin is installed, we now need create Maven project.

Step 1) In Eclipse IDE, create a new project by selecting File | New | Other from Eclipse menu.

Step 2) On the New dialog, select Maven | Maven Project and click Next 

http://cdn.guru99.com/images/5-2015/050115_1023_MavenJenkin2.png

Step 3) On the New Maven Project dialog select the Create a simple project and click Next 

http://cdn.guru99.com/images/5-2015/050115_1023_MavenJenkin3.jpg

Step 4) Enter WebdriverTest in Group Id: and Artifact Id: and click finish 

http://cdn.guru99.com/images/5-2015/050115_1023_MavenJenkin4.jpg

Step 5) Eclipse will create WebdriverTest with following structure: 

http://cdn.guru99.com/images/5-2015/050115_1023_MavenJenkin5.jpg

Step 6) Right-click on JRE System Library and select the Properties option from the menu. 

http://cdn.guru99.com/images/5-2015/050115_1023_MavenJenkin6.jpg

On the Properties for JRE System Library dialog box, make sure Workspace default JRE is selected and click OK 

http://cdn.guru99.com/images/5-2015/050115_1023_MavenJenkin7.jpg

Step 7). Select pom.xml from Project Explorer.. 

http://cdn.guru99.com/images/5-2015/050115_1023_MavenJenkin8.jpg

pom.xml file will Open in Editor section 

http://cdn.guru99.com/images/5-2015/050115_1023_MavenJenkin9.jpg

Step 8).Add the Selenium and TestNG, JUnit dependencies to pom.xml in the <project> node: 

```<dependencies>            
        <dependency>              
             <groupId>junit</groupId>                               
             <artifactId>junit</artifactId>                             
             <version>3.8.1</version>                               
             <scope>test</scope>                                
        </dependency>             
        <dependency>              
            <groupId>org.seleniumhq.selenium</groupId>                              
            <artifactId>selenium-java</artifactId>                              
            <version>2.45.0</version>                               
        </dependency>             
        <dependency>              
            <groupId>org.testng</groupId>                               
            <artifactId>testng</artifactId>                             
            <version>6.8</version>                              
            <scope>test</scope>                                     
       </dependency>              
</dependencies>
```


Step 9) Create a New TestNG Class. Enter Package name as "example" and "NewTest" in the Name: textbox and click on the Finish button as shown in the following screenshot: 

http://cdn.guru99.com/images/5-2015/050115_1023_MavenJenkin10.jpg

Step 10). Eclipse will create the NewTest class as shown in the following screenshot: 

Step 11) Add the following code to the NewTest class:

This code will verify the title of Guru99 Selenium Page 


> package example;     
import org.openqa.selenium.By;      
import org.openqa.selenium.WebDriver;       
import org.openqa.selenium.firefox.FirefoxDriver;       
import org.testng.Assert;       
import org.testng.annotations.Test; 
import org.testng.annotations.BeforeTest;   
import org.testng.annotations.AfterTest;        
public class NewTest {      
        private WebDriver driver;       
        @Test              
        public void testEasy() {    
            driver.get("http://www.guru99.com/selenium-tutorial.html");  
            String title = driver.getTitle();                
            Assert.assertTrue(title.contains("Free Selenium Tutorials"));       
        }   
        @BeforeTest
        public void beforeTest() {  
            driver = new FirefoxDriver();  
        }       
        @AfterTest
        public void afterTest() {
            driver.quit();          
        }       
}   


Step 12) Right-click on the WebdriverTest and select TestNG | Convert to TestNG.
Eclipse will create testng.xml which says that you need to run only one test with the name NewTest as shown in the following screenshot: 

http://cdn.guru99.com/images/5-2015/050115_1023_MavenJenkin12.jpg

Update the project and make sure that file appears in the tree Package Explorer (right click on the project - Refresh). 

Step 13) Now you need to run test through this testng.xml.

So, go to the Run Configurations and create a new launch TestNG, select the project and field Suite as testng.xml and click Run 

http://cdn.guru99.com/images/5-2015/050115_1023_MavenJenkin14.jpg

Make sure that build finished successfully.

Step 14). Additionally, we need to add

    maven-compiler-plugin
    maven-surefire-plugin
    testng.xml

to pom.xml.

The maven-surefire-plugin is used to configure and execute tests. Here plugin is used to configure the testing.xml for TestNG test and generate test reports.

The maven-compiler-plugin is used to help in compiling the code and using the particular JDK version for compilation. Add all dependencies in the following code snippet, to pom.xml in the <plugin> node: 

Step 15) To run the tests in the Maven lifecycle, Right-click on the WebdriverTest and select Run As | Maven test. Maven will execute test from the project. 

Make sure that build finished successfully. 

Read more in the source link

---

After step 15, test it:

Go to the project directory and run
```mvn test```

Create a JAR executable file to run our program on another machine with Maven.

Create a main class named App


> package com;   
import java.util.List;   
import org.testng.TestListenerAdapter;      
import org.testng.TestNG;    
import org.testng.collections.Lists;      
public class App {      
	public static void main(String[] args) {      
		// TODO Auto-generated method stub        
		System.out.println("Hello");       
		TestListenerAdapter tla = new TestListenerAdapter();        
		TestNG testng = new TestNG();       
		testng.addListener(tla);        
		// testng.setTestClasses(new Class[] { test.TestTitle.class });        
		List<String> suites = Lists.newArrayList();      
		suites.add("testng.xml");// path to xml..       
		// // suites.add("c:/tests/testng2.xml");    
		//      
		testng.setTestSuites(suites);        
		testng.run();      
	}      
}     
        
		
		
 Check it:
 
 ```mvn clean install```
 
At this time, I can make a jar executable file by run ```mvn install``` but it can't run with the test classes.

Workaround:

 In Eclipse
 
 
 - Right click our project
 - Export
 - Runnable JAR file
 - Package required libraries into generated JAR
 
 
 
 Copy our ```App.jar``` and ```testng.xml``` to aonother machine and run
 
 ```java -jar App.jar```