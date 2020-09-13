package com.azias.webscanner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AdminControlServer {
	private static final Logger logger = LoggerFactory.getLogger(AdminControlServer.class);
	
	private static Options launchOptions;
	private static CommandLine launchArgs;
	
	public static void main(String[] args) throws ParseException {
		logger.trace("Parsing arguments...");
		//launchOptions = getStandardLaunchArgs();
		//launchArgs = parseLaunchArgs(launchOptions, args);
		
		logger.trace("Processing arguments...");
		//processStandardLaunchArgs(launchArgs, launchOptions);
		
		logger.trace("Starting...");
		logger.info("### Web Scanner Toolkit - Admin Control Server ###");
		logger.info("Java: {} - {}", System.getProperty("java.vendor"), System.getProperty("java.version"));
		logger.info("Operating System: {} - {}", System.getProperty("os.name"), System.getProperty("os.arch"));
		
		
		
		
		logger.info("Goodbye.");
	}
}
