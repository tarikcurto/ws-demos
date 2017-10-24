
var ws = new WebSocket('ws://localhost:8080/ws');
ws.onmessage = function(messageEvent){
    
    var message = messageEvent.data;
    
    var messageElement = document.createElement('p');
    messageElement.innerHTML = message;
    
    var responseLoggerContainer = document.querySelector('#response-logger');
    responseLoggerContainer.appendChild(messageElement);
}

var wsRequestByInput = function(){
    
    var input = document.querySelector('#client-input');
    var inputValue = input.value;
    
    var messageElement = document.createElement('p');
    messageElement.innerHTML = inputValue;
    
    var responseLoggerContainer = document.querySelector('#request-logger');
    responseLoggerContainer.appendChild(messageElement);
    
    ws.send(inputValue);
}