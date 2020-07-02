@echo off

rem setting ---------------------
set mvn=mvn
set java=java

if /I "%1" EQU "compile" (
    rem compile ---------------------
    cmd /c %mvn% clean package

    rem deploy ---------------------
    if exist deploy rd /s /q deploy
    mkdir deploy
    mkdir deploy\conf
    xcopy /E /I target\lib deploy\lib
    xcopy target\b2e_url_shortener-0.0.1-SNAPSHOT.jar deploy
    xcopy src\main\resources\application.properties deploy\conf

    rem clean -------------------
    cmd /c %mvn% clean
)

rem run ---------------------
%java% -cp deploy\b2e_url_shortener-0.0.1-SNAPSHOT.jar;deploy\conf idv.maxy.b2e_url_shortener.B2EMain

