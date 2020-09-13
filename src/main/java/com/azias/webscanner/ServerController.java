package com.azias.webscanner;

// Receives a server object and uses it to respond to shit.
public class ServerController {
	private Server server;
	
	protected ServerController(Server server) {
		this.server = server;
	}
	
	protected Server getServer() {
		return server;
	}
}
