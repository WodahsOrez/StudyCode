const path = require('path');
const os = require('os');

function resolve(dir) {
    return path.join(__dirname, dir)
}

module.exports = {
    publicPath: './',
    // 去除 map 文件
    productionSourceMap: false,
    devServer: {
        host: '0.0.0.0',
        port: 8111,
        compress: true,
        disableHostCheck: true,
        // proxy: "http://127.0.0.1:8080/PC_VUE_R7",
        historyApiFallback: {
            rewrites: [
            ]
        }
    },
    pages: {
        index: {
            // page 的入口
            entry: 'src/pages/common/index/main.ts',
            // 模板来源
            template: 'src/template.html',
            // 在 dist/index.html 的输出
            filename: 'index.html',
            // 当使用 title 选项时，
            // template 中的 title 标签需要是 <title><%= htmlWebpackPlugin.options.title %></title>
            title: '应用首页视图',
            // 在这个页面中包含的块，默认情况下会包含
            // 提取出来的通用 chunk 和 vendor chunk。
            // chunks: ['chunk-vendors', 'chunk-common', 'index']
        },
    },
    // 多核打包
    parallel: os.cpus().length > 1,
    chainWebpack: (config) => {
        // 删除自动计算预加载资源
        config.plugins.delete('preload-index')
        // 删除预加载资源
        config.plugins.delete('prefetch-index')
        config.resolve.alias
            .set('@ibizsys', resolve('src/ibizsys'))
            .set('@pages', resolve('src/pages'))
            .set('@components', resolve('src/components'))
            .set('@widgets', resolve('src/widgets'))
            .set('@engine', resolve('src/engine'))
            .set('@interface', resolve('src/interface'))
            .set('@locale', resolve('src/locale'))
            .set('@mock', resolve('src/mock'))
            .set('@service', resolve('src/service'))
            .set('@codelist', resolve('src/codelist'))
    },
    configureWebpack: config => {
        if (Object.is(config.mode, 'production')) {
            // 多核启动编译及内存提升
            const data = config.plugins[9 + 1];
            // 最大进程数
            data.workersNumber = os.cpus().length > 4 ? 4 : os.cpus().length; // 会占用额外内存不释放，不建议开发阶段使用
            // 单个进程最大使用内存
            data.memoryLimit = 4096;
        } else {
            // 多核启动编译及内存提升
            const data = config.plugins[7 + 1];
            // 最大进程数
            // data.workersNumber = os.cpus().length > 4 ? 4 : os.cpus().length; // 会占用额外内存不释放，不建议开发阶段使用
            // 单个进程最大使用内存
            data.memoryLimit = 4096;
        }
    },
}