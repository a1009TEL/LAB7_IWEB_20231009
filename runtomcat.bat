@echo off

set TOMCAT_DIR=%CATALINA_HOME%
set WAR_FILE=target\lab7.war
call mvn clean package

copy /Y "%WAR_FILE%" "%TOMCAT_DIR%\webapps\"

call "%TOMCAT_DIR%\bin\startup.bat"