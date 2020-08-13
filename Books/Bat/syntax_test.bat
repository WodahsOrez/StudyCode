REM 可显示的注释
rem 小写也可以
ReM 不区分大小写
:: 不会显示的注释
:~ 也可以注释

echo off
rem 不会回显了
echo.
echo.
echo 强制输出信息，不被echo off 影响
echo on
rem 回显开始了
echo
echo.|time
echo %errorlevel%

title 标题2333
COLOR fc

Echo 其他提示语 & pause > nul