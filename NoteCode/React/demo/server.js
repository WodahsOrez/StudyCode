const express = require('express');
const next = require('next');
// 代理配置
const devProxy = {
    '/api': {
        target: 'http://172.16.100.204:8099/',
        pathRewrite: { '^/api': '/' },
        changeOrigin: true,
    },
};

const port = parseInt(process.env.PORT, 10) || 3000;
const env = process.env.NODE_ENV;
const dev = env !== 'production';
const app = next({
    dir: '.', // 根目录
    dev,
});

const handle = app.getRequestHandler();

const start = async function () {
    let server
    try {
        await app.prepare();
        server = express();
        // 设置代理
        if (dev && devProxy) {
            const { createProxyMiddleware } = require('http-proxy-middleware');
            Object.keys(devProxy).forEach(function (context) {
                server.use(context, createProxyMiddleware(devProxy[context]));
            })
        }
        // 让next.js代理所有路由
        server.all('*', (req, res) => handle(req, res))
        // 启动监听
        server.listen(port, (err) => {
            if (err) {
                throw err;
            }
            console.log(`> Ready on port ${port} [${env}]`);
        })
    } catch (err) {
        console.log('An error occurred, unable to start the server');
        console.log(err);
    }
}
start();