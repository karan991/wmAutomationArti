package com.wmAutomationArti.util;

import java.util.Properties;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SSHConnection {

	public Session getTunnelledConnection(Session session) {

		//String sshUser = "qauser";
		String sshUser = "tester";
		String sshPassword = "Br0ctag0n@123";
		String sshHost = "52.78.64.157";

		String databaseHost = "priv-qa.fintech";
		int databasePort = 3356;
		int localHostPort = 3366;

		try {
			JSch jsch = new JSch();

			// connecting to intermediate server
		jsch.addIdentity("C:\\Users\\karandeep.singh\\Desktop\\tester (3)");
		JSch.setConfig("StrictHostKeyChecking", "no");

			session = jsch.getSession(sshUser, sshHost, 22);
			// session.setPassword(sshPassword);
			final Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();

			// now server is connected using ssh, so now we are forwarding
			// localhost port 3366 to mysql server 3356
			session.setPortForwardingL(localHostPort, databaseHost, databasePort);

		} catch (Exception e) {
			System.out.println("I AM IN2");
			e.printStackTrace();
		}
		return session;
	}

	
	
	
}


