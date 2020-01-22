## 安装

1. 下载[官网](http://nginx.org/en/download.html)稳定版（stable version），并解压缩。
2. 把解压的nginx文件夹放在英文路径下，并在html文件夹内放入编译好的项目文件。
3. 在nginx文件夹目录下，运行cmd，执行`start nginx`命令。（**不要直接执行nginx.exe**）
4. 访问`localhost:80`来访问项目

## 目录结构

- conf：配置文件目录
- contrib：存放一些实用的工具
- docs：文档目录
- html：默认静态页面目录
- logs：error.log（异常日志）
- temp：临时文件目录
- nginx.exe：本体

## 配置文件

### 常用配置

```nginx
server {
    listen       80;
    server_name  localhost;
    root html/;
    index index.html index.htm index.php;
    location / {
        try_files $uri $uri/ /index.php?$args;
    }
}
#获取url，先寻找serve_name
#匹配location，如果没有，寻找index，若没有index，则404
#匹配到location，进入执行try_files
#查找try_files是否有相应的文件，没有直接重定向从最后一项。
```

### 其他配置

```nginx
# user 指定运行 nginx 的用户和组（第一个参数为用户第二个为组，这里只有用户）
#user  nobody;
# 指定工作进程数（一般设置为CPU核数）
worker_processes  1;   

# 指定错误日志为 logs/ 目录下的 error.log 文件
#error_log  logs/error.log;
# 指定错误日志，并指定写入格式为 notice
#error_log  logs/error.log  notice;
# 指定错误日志，并指定写入格式为 info  
#error_log  logs/error.log  info;

# 指定 pid 文件（存放主进程 pid 号）
#pid        logs/nginx.pid;

# nginx 连接配置模块
events {
    # 指定每个工作进程最大连接数为 1024
    worker_connections  1024;
}

# http 配置模块
http {
    # 通过 include 加载 mime.types 文件，里面的 types {} 模块将文件扩展名映射到响应的 MIME 类型
    include       mime.types;
    # 定义响应的默认 MIME 类型
    default_type  application/octet-stream;

    # 写入格式 main 的内容格式如下
    #log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
    #                  '$status $body_bytes_sent "$http_referer" '
    #                  '"$http_user_agent" "$http_x_forwarded_for"';

    # 指定访问日志和写入格式为 main
    #access_log  logs/access.log  main;

    # 启用或者禁用 sendfile()
    sendfile        on;
    # 启用或者禁用使用套接字选项（仅在 sendfile 使用时使用）
    #tcp_nopush     on;

    # 0 值禁用保持活动的客户端连接
    #keepalive_timeout  0;
    # 65 s 超时
    keepalive_timeout  65;

    # 启用或者禁用 gzip
    #gzip  on;

    # 虚拟主机配置模块
    server {
        # 监听 80 端口
        listen       80;
        # 监听域名为 localhost
        server_name  localhost;
        # 将指定的 charset 添加到 “Content-Type” 响应头字段。如果此charset与source_charset指令中指定的charset不同，则执行转换。
        #charset koi8-r;

        # 指定该虚拟主机的访问日志
        #access_log  logs/host.access.log  main;

        # 将特定的文件或目录重新定位，如 php 文件，image 目录等
        location / {
            # 设置请求的根目录
            root   html;
            # 定义索引，按顺序匹配
            index  index.html index.htm;
        }

        # 定义显示 404 错误的 uri
        #error_page  404              /404.html;

        # redirect server error pages to the static page /50x.html
        #
        error_page   500 502 503 504  /50x.html;
        # location 精准匹配 '/50x.html'
        location = /50x.html {
            root   html;
        }

        # proxy the PHP scripts to Apache listening on 127.0.0.1:80
        # 正则表达式匹配 php 文件
        #location ~ \.php$ {
            # 设置代理服务器的协议和地址，以及应该映射位置的可选URI。作为协议，可以指定“http”或“https”。该地址可以指定为一个域名或IP地址，以及一个可选端口
        #    proxy_pass   http://127.0.0.1;
        #}

        # pass the PHP scripts to FastCGI server listening on 127.0.0.1:9000
        #
        #location ~ \.php$ {
        #    root           html;
             # 设置 FastCGI 服务器的地址。地址可以指定为一个域名或 IP 地址，以及一个端口
        #    fastcgi_pass   127.0.0.1:9000;
             # 设置将在以斜杠结尾的URI之后追加的文件名，
        #    fastcgi_index  index.php;
             # 设置一个应该传递给FastCGI服务器的参数。
        #    fastcgi_param  SCRIPT_FILENAME  /scripts$fastcgi_script_name;
             # 加载 conf/fastcgi_params 文件
        #    include        fastcgi_params;
        #}

        # deny access to .htaccess files, if Apache's document root
        # concurs with nginx's one
        #
        #location ~ /\.ht {
        #    deny  all;
        #}
    }


    # another virtual host using mix of IP-, name-, and port-based configuration
    #
    #server {
    #    listen       8000;
    #    listen       somename:8080;
    #    server_name  somename  alias  another.alias;

    #    location / {
    #        root   html;
    #        index  index.html index.htm;
    #    }
    #}


    # HTTPS server
    #
    # ssl 配置，要启用 ssl 模块需要在编译 nginx 时加上 --with-http_ssl_module 参数
    #server {
    #    listen       443 ssl;
    #    server_name  localhost;

    #    ssl_certificate      cert.pem;
    #    ssl_certificate_key  cert.key;

    #    ssl_session_cache    shared:SSL:1m;
    #    ssl_session_timeout  5m;

    #    ssl_ciphers  HIGH:!aNULL:!MD5;
    #    ssl_prefer_server_ciphers  on;

    #    location / {
    #        root   html;
    #        index  index.html index.htm;
    #    }
    #}

}
```

## 命令

```cmd
start nginx  启动nginx
nginx -s reload 重新加载配置文件
nginx -t -c /nginx-1.15.2/conf/nginx.conf  检查一下配置文件是否正确
nginx -s stop  快速停止
nginx -s quit  完整有序的关闭
```

