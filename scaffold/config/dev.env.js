'use strict';
const merge = require('webpack-merge');
const prodEnv = require('./prod.env');

module.exports = merge(prodEnv, {
    NODE_ENV: '"development"',
    ENCRYPT: true,

    
    COOKIE_TIMEOUT: 30,
    MOCK: true,
    NOTICE_URL: '"ws://114.118.30.130:18002/fund/websocket/notify/"',
    SERVER_URL: '"http://114.118.30.130:18002/fund"',
    
});
