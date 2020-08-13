const withLess = require('@zeit/next-less');
const path = require('path');

module.exports = withLess({
    lessLoaderOptions: {
        javascriptEnabled: true
    },
    webpack(config) {
        if (config.externals) {
            const includes = [/^antd/];
            config.externals = config.externals.map(external => {
                if (typeof external !== 'function') return external;
                return (ctx, req, cb) => {
                    return includes.find(include =>
                        req.startsWith('.')
                            ? include.test(path.resolve(ctx, req))
                            : include.test(req)
                    )
                        ? cb()
                        : external(ctx, req, cb);
                };
            });
        }
        return config;
    }
});