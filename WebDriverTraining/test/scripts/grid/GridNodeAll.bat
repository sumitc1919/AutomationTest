c:
cd "C:\Users\Ketan\SkyDrive\Selenium\workspace\webdrivertrainingSept18\lib"
java ^
-Dwebdriver.gecko.driver="C:\Users\Ketan\SkyDrive\Selenium\workspace\webdrivertrainingSept18\test\resources\geckodriver64bit.exe" ^
-Dwebdriver.chrome.driver="C:\Users\Ketan\SkyDrive\Selenium\workspace\webdrivertrainingSept18\test\resources\chromedriver.exe" ^
-Dwebdriver.ie.driver="C:\Users\Ketan\SkyDrive\Selenium\workspace\webdrivertrainingSept18\test\resources\IEDriverServer.exe" ^
-jar selenium-server-standalone-3.14.0.jar -role node ^
-hub http://192.168.0.103:4444/grid/register ^
-port 5557 ^
-browser "browserName=firefox,maxInstances=1,platform=Windows" ^
-browser "browserName=chrome,maxInstances=9" ^
-browser "browserName=internet explorer,maxInstances=5" ^
-browser "browserName=safari,maxInstances=150" ^
-maxSession 20
pause