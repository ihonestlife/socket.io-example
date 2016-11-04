/**
 * socket.io on v1.5.0
 */
var app = require('http').createServer();
var io = require('socket.io')(app);

app.listen(7009);

io.on('connection', function (socket) {

  socket.on('change', function (data) {
    console.log(data);
  });

  socket.on('update data', function (data) {
    io.sockets.emit('move car', data);
  });

});
