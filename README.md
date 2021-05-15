# MiroService_E2ETest Framework
** **Steps To run project** **
>Prerequisite : Maven should be installed on machine, after installation to work maven, restart the machine
               

>Step1: Open command line

>Step2: cd "<path_till_project_Folder>"

>Step3 : mvn clean test


>Report: Report will be generated as "index.html" under "target/Destination" folder 
        Right click on it and open with any browser
        
        
This framework is combination of REST API and Web automation via selenium using cucumber , we can execute both[REST API/Web] the test together as per the requirement. Currently it's working only for web.

 Prerequisite:
1. User have to provide the chrome driver on the specified path in order to execute test cases in this framework, also chrome driver should be match with your current Chrome browser version. Driver depends on platforms i.e. MAC or windows.
   Also expacting user should have initial setup for java, and in order to excecute cucumber tc's we have to add the plugin in your Idea i.e "Cucumber for JAVA"
2. Currenty we are executing only for webUI, You can execute test cases only for REST API or only for Web automation via changing in the OpenTest_Runner class depends on the tag.
3. Also Added the video(i.e. MiroServiceE2ETest) for the e2e execution

        
        ========================OR=========================
        if you are using any ide Intellij or Eclipse
        
        right click on OpenTest_Runner.java and run the file

