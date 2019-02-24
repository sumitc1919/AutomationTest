e:
cd "E:\AutoJava\WebDriverTraining\lib"
java ^
-Dwebdriver.ie.driver="E:\AutoJava\WebDriverTraining\test\resources\IEDriverServer.exe" ^
-jar selenium-server-standalone-3.14.0.jar -role node ^
-hub http://192.168.0.103:4444/grid/register ^
-browser "browserName=internet explorer,maxInstances=3" ^
-maxSession 4
pause