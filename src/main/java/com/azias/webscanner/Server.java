package com.azias.webscanner;

import com.azias.webscanner.commons.EServerType;
import org.apache.commons.cli.*;
import org.java_websocket.server.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

public abstract class Server extends WebSocketServer {
	public Server(InetSocketAddress address) {
		super(address);
		logger.debug("Instantiated {} with {} as the address !", this.getClass().getName(), address.toString());
	}
	
	private static final Logger logger = LoggerFactory.getLogger(Server.class);
	
	// Static methods
	protected static Options getStandardLaunchArgs() {
		Options launchOptions = new Options();
		launchOptions.addOption("d", "debug", false, "Enable debug mode.");
		launchOptions.addOption("h", "help", false, "Print this help.");
		launchOptions.addOption("b", "bind", false, "IP address to bind to.");
		launchOptions.addOption("p", "port", false, "Port to use.");
		return launchOptions;
	}
	
	protected static CommandLine parseLaunchArgs(Options launchOptions, String[] args) throws ParseException {
		return parseLaunchArgs(launchOptions, args, true);
	}
	
	protected static CommandLine parseLaunchArgs(Options launchOptions, String[] args, boolean allowExits) throws ParseException {
		try {
			return new DefaultParser().parse(launchOptions, args);
		} catch(ParseException e) {
			if(allowExits) {
				logger.error("Failed to parse command line properties", e);
				e.printStackTrace();
				logger.info("Please use \"--help\" to see the help.");
				System.exit(100);
			} else {
				throw e;
			}
		}
		
		// Will never be reached !
		return null;
	}
	
	protected static boolean processStandardLaunchArgs(CommandLine launchArgs, Options launchOptions) {
		return processStandardLaunchArgs(launchArgs, launchOptions, true);
	}
	
	protected static boolean processStandardLaunchArgs(CommandLine launchArgs, Options launchOptions, boolean allowExits) {
		if(launchArgs.hasOption("h") && !launchArgs.hasOption("f")) {
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("Arguments List:", launchOptions);
			if(allowExits) {
				System.exit(0);
			}
		}
		
		return true;
	}
	
	// Non-static abstract methods
	protected abstract EServerType getServerType();
	
	//protected abstract boolean onDataIn();
	//NOPE https://www.baeldung.com/java-websockets
	//https://github.com/TooTallNate/Java-WebSocket/wiki
}
