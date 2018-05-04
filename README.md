### Code Samples
Repository to hold implementation for below scenarios

1. Write the script to Login in to website. Verify your email address under My account.

2. Write a script to login into Facebook account (test account) from website. And Post a test comment.

3. Now, write a script to check the same posted comment by logging into Facebook App. And verify the same comment is posted or not.


### Execution

Maven can be used to execute test scripts standalone and from CI pipeline

TestNG provides core keywords. Test execution can be started using TestNG test suite as well.

#### Cross Browser Testing support

##### Supported Browser:
Chrome Browser
Firefox Browser
Android App

Test execution logs will be captured in /Result/TestExecution.log file.

Application url under test can be changed from AUT_Conf.properties file. Helps to execute tests in different environents.

SeleniumUtil and SeleniumAndroidUtil classes to maintain reusable scripts.

BrowserFactory - One place to create browser objects 
