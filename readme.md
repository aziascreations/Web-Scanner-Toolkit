# Web Scanner Toolkit



## Preamble

This project is not as modular or extensible as some of my other projects, this was done to avoid the aditional [shit]
that is usually required for that type of stuff.<br>
But it can easily be added back in if you want to.

Why is it so fragmented

## Summary
* [Building]()
* [Running]()
* [Server types]()
  * [Central Registry Server]()
  * [Logging Server]()
  * [Gateway Server]()
  * [Admin Control Server]()
  * [Record Storage Server]()
  * [Central Scheduler Server]()
  * [Primitive Worker Server]()
  * [Webpage Consumer]()
* [Technical details]()
* [License]()

## Building


## Running



## Server types

Every server described below fulfils a very specific task and is mostly independent of every other server code-wise.

They all extend the abstract class `com.azias.webscanner.Server` which provides them with some utility methods, 
some abstract methods provided by the extended class `org.java_websocket.server.WebSocketServer` which gives them the
ability to host a WebSocket server to communicate with the potential clients of the network.

The clients follow the save basic concept, but they instead extend `com.azias.webscanner.ServerClient` which extends 
the `org.java_websocket.server.WebSocketClient` class instead.

Each one of them can use the classes in the `com.azias.webscanner.commons` package freely, but they should only access
their personal package in the `com.azias.webscanner.servers` package and/or the relevant libraries. 

### Central Registry Server
Main class: `com.azias.webscanner.CentralRegistryServer`<br>
Private package: `com.azias.webscanner.servers.registry`

This server takes care of remembering the basic contact info of every server on the network.<br>
Each new server usually tries to contact this server first to register on the network, and then they query it to get
the info of other server or client that might be present on the network.

### Logging Server
Main class: `com.azias.webscanner.LoggingServer`<br>
Private package: `com.azias.webscanner.servers.logging`

This server takes care of handling the logs.

### Gateway Server
Main class: `com.azias.webscanner.GatewayServer`<br>
Private package: `com.azias.webscanner.servers.gateway`

This server simple acts as a gateway between multiple sets of servers.<br>
It is mainly used to isolate potentially dangerous or unsafe networks from the main one.<br>
[or less port usage]

Will probably hand out a token for an internal lookup table.

### Admin Control Server

### Record Storage Server

### Central Scheduler Server

### Primitive Worker Server

### Webpage Consumer (aka Websoomer)


Used to isolate potentially dangerous or unsafe server



## Technical details


## License

### This repository
[Unlicense](LICENSE)<br>
<sub>Just DM me if you make some cool shit with it.</sub>

### Libraries

#### Apache V2
[???](???)

#### MIT
[TooTallNate/Java-WebSocket](https://github.com/TooTallNate/Java-WebSocket/)
