@echo off
rem //设置变量 
set NAME="WLAN"
rem //以下属性值可以根据需要更改
set ADDR=172.16.103.13
set MASK=255.255.255.0
set GATEWAY=172.16.103.254
set DNS1=114.114.114.114
set DNS2=
rem //以上属性依次为IP地址、子网掩码、网关、首选DNS、备用DNS

rem //获取当前wifi名称
netsh wlan show interface > temp.txt
FOR /F "tokens=2 delims=: " %%i in ('findstr /R "\<SSID" temp.txt') do set wifiName=%%i
del temp.txt

set mode=dynamic
rem //当wifi名为iBizSys_5G时，配置静态ip
set value=iBizSys_5G
IF %value%==%wifiName% set mode=static
rem //当wifi名为iBizSys时，配置静态ip
set value=iBizSys
IF %value%==%wifiName% set mode=static

IF  %mode%==static (
  goto 1
) ELSE (
  goto 2
)



:1
echo 正在设置静态IP，请稍等...
rem //可以根据你的需要更改 
echo IP地址 = %ADDR%
echo 掩码 = %MASK%
echo 网关 = %GATEWAY%
netsh interface ipv4 set address %NAME% static %ADDR% %MASK% %GATEWAY% 
rem //echo 首选DNS = %DNS1% 
rem //netsh interface ipv4 set dns %NAME% static %DNS1%
rem //echo 备用DNS = %DNS2% 
rem //if "%DNS2%"=="" (echo DNS2为空) else (netsh interface ipv4 add dns %NAME% %DNS2%) 
echo 静态IP已设置！
rem //pause
goto 3


:2
echo 正在设置动态IP，请稍等...
echo 正在从DHCP自动获取IP地址...
netsh interface ip set address %NAME% dhcp
echo 正在从DHCP自动获取DNS地址...
netsh interface ip set dns %NAME% dhcp 
echo 动态IP已设置！
rem //pause
goto 3


:3
exit

:4
rem //手动切换代码
echo 当前可用操作有：
echo 1 设置为静态IP
echo 2 设置为动态IP
echo 3 退出
echo 请选择后回车：
set /p operate=
if %operate%==1 goto 1
if %operate%==2 goto 2
if %operate%==3 goto 3