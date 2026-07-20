@echo off
setlocal
for /f "tokens=2 delims=:." %%x in ('chcp') do set _codepage=%%x
chcp 65001>nul
cd C:\Users\Пользователь\Documents\Endemeral\neoforge\run
C:\Users\Пользователь\.jdks\openjdk-21.0.2\bin\java.exe @C:\Users\Пользователь\Documents\Endemeral\neoforge\build\moddev\clientRunClasspath.txt @C:\Users\Пользователь\Documents\Endemeral\neoforge\build\moddev\clientRunVmArgs.txt -Dfml.modFolders=endemeral%%%%C:\Users\Пользователь\Documents\Endemeral\neoforge\build\classes\java\main;endemeral%%%%C:\Users\Пользователь\Documents\Endemeral\neoforge\build\resources\main net.neoforged.devlaunch.Main @C:\Users\Пользователь\Documents\Endemeral\neoforge\build\moddev\clientRunProgramArgs.txt
if not ERRORLEVEL 0 (  echo Minecraft failed with exit code %ERRORLEVEL%  pause)
chcp %_codepage%>nul
endlocal