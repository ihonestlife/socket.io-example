/**
 * Created by zb on 2016/10/29.
 */
var express = require('express');
var path = require('path');
var app = express();
var http = require('http').Server(app);

app.use(express.static(__dirname + '/public'));

app.get('/', function (req, res) {
    res.sendfile('views/index.html', {});
});

app.listen(7000);
