package com.azias.webscanner;

import com.azias.webscanner.commons.EServerType;
import com.google.gson.Gson;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.InetSocketAddress;
import java.net.URL;
import java.util.Iterator;

/**
 * Main class for the central registry server.
 * This whole process will mainly give routing information to every [???].
 */
public class CentralRegistryServer extends Server {
	private static final Logger logger = LoggerFactory.getLogger(CentralRegistryServer.class);
	
	// Could be moved inside the object
	private static Options launchOptions;
	private static CommandLine launchArgs;
	//private static Configurations configs = new Configurations();
	private static Configuration config;
	
	public static void main(String[] args) throws ParseException {
		logger.trace("Parsing arguments...");
		launchOptions = getStandardLaunchArgs();
		launchArgs = parseLaunchArgs(launchOptions, args);
		
		logger.trace("Processing arguments...");
		processStandardLaunchArgs(launchArgs, launchOptions);
		
		logger.trace("Loading config files...");
		try {
			config = new Configurations().properties(
					CentralRegistryServer.class.getResource("/configs/common.properties")
			);
		} catch (ConfigurationException cex) {
			logger.error("Failed to load configuration: {}", cex.getMessage());
			cex.printStackTrace();
			System.exit(1);
		}
		
		//logger.debug("autoreconnect.start: {}", config.getBoolean("ws.autoreconnect.start"));
		//logger.debug("timeout: {}", config.getLong("ws.timeout"));
		//logger.debug("autoterminate.registry: {}", config.getBoolean("ws.autoterminate.registry"));
		
		logger.trace("Starting...");
		logger.info("### Web Scanner Toolkit - Central Server ###");
		logger.info("Java: {} - {}", System.getProperty("java.vendor"), System.getProperty("java.version"));
		logger.info("Operating System: {} - {}", System.getProperty("os.name"), System.getProperty("os.arch"));
		
		ServerController sc = new ServerController(new CentralRegistryServer());
		
		logger.info("Goodbye.");
	}
	
	// Object part
	
	private Gson gson;
	
	private CentralRegistryServer() {
		super(new InetSocketAddress(8080));
		
		gson = new Gson();
	}
	
	@Override
	public void onOpen(WebSocket conn, ClientHandshake handshake) {
	
	}
	
	@Override
	public void onClose(WebSocket conn, int code, String reason, boolean remote) {
	
	}
	
	@Override
	public void onMessage(WebSocket conn, String message) {
	
	}
	
	@Override
	public void onError(WebSocket conn, Exception ex) {
	
	}
	
	@Override
	public void onStart() {
		logger.info("WebSocket server has started !");
	}
	
	@Override
	protected EServerType getServerType() {
		return EServerType.REGISTRY;
	}
}
