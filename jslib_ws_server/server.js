const express = require('express');
const http = require('http');
const url = require('url');
const WebSocket = require('ws');

const app = express();
const server = http.createServer(app);
const wss = new WebSocket.Server({server});

wss.on('connection', function connection(ws, req) {

    const location = url.parse(req.url, true);

    ws.on('message', (message) => {

        ws.send('Client message: ' + message)
    });


    ws.on('close', () => {

    });

});

server.listen(8080);