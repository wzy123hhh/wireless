window.onload = function() {
	var ws;
	var target="ws://localhost:8080/Wireless/demo";
	function subopen(){
	    
	    if ('WebSocket'in window) {
	        ws = new WebSocket(target);
	        alert("Websocket");
	    }else if ('MozWebsocket'in window) {
	        ws = new MozWebsocket(target);
	        alert("MozWebsocket");
	    }else{
	        alert("不支持websocket");
	        return;	
	    }

	    ws.onopen = function(event){
	        ws.send("hello");
	    }
	    
	    ws.onmessage = function(event){
	        alert(event.data);
	    }

	    ws.sendmessage = function(){
	        send("sss")
	    }
	    
	}	
	    
	subopen();
}