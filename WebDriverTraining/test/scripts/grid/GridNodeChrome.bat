e:
cd "E:\AutoJava\WebDriverTraining\lib"
java ^
-Dwebdriver.chrome.driver="E:\AutoJava\WebDriverTraining\test\resources\chromedriver.exe" ^
-jar selenium-server-standalone-3.14.0.jar -role node ^
-hub http://192.168.0.103:4444/grid/register ^
-browser "browserName=chrome,maxInstances=3" ^
-maxSession 3
pause