set M2_HOME=C:\Software\apache-maven-2.2.0
set PATH=C:\Software\apache-maven-2.2.0\bin;C:\WINDOWS\system32;C:\WINDOWS;C:\WINDOWS\System32\Wbem;C:\WINDOWS\System32\WindowsPowerShell\v1.0\;C:\Windows\CCM;;C:\PostgreSQL\pg95\bin;C:\Program Files\node;C:\Users\rahamathulla.m\AppData\Roaming\npm;C:\Program Files\TortoiseSVN\bin;C:\Program Files\Git\cmd;C:\ProgramData\chocolatey\bin;C:\Python27\DLLs;C:\Program Files (x86)\Microsoft.NET;C:\Program Files\Amazon\AWSCLIV2\;C:\Program Files\TortoiseGit\bin;C:\Program Files (x86)\Yarn\bin\;C:\WINDOWS\System32\OpenSSH\;C:\Users\rahamathulla.m\.windows-build-tools\python27\;C:\Users\rahamathulla.m\AppData\Local\Yarn\bin;C:\Microsoft VS Code\bin;C:\Program Files\JetBrains\PyCharm Community Edition 2020.2\bin;;C:\Software\openshift\odo;;C:\Users\rahamathulla.m\AppData\Local\Microsoft\WindowsAppscall
set JAVA_HOME=C:\Program Files\Java\jdk1.5.0_22
set TOMCAT6_HOME=C:\Software\apache-tomcat-6.0.32
set SRC_DIR=C:\Presto
cd %SRC_DIR% 
start /W /B mvn clean install  
start /W /B copy %SRC_DIR%\target\Presto.war %TOMCAT6_HOME%\webapps\Presto.war
cd %TOMCAT6_HOME%\bin
startup.bat
