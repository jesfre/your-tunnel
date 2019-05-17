/**
 * 
 */
package com.blogspot.jesfre.yourtunnel;

import com.blogspot.jesfre.yourtunnel.elements.LocalUserInfo;
import com.blogspot.jesfre.yourtunnel.elements.RemoteServer;
import com.blogspot.jesfre.yourtunnel.elements.ServerData;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;

/**
 * @author <a href="mailto:jorge.ruiz.aquino@gmail.com">Jorge Ruiz Aquino</a>
 * May 15, 2019
 */
public class YourTunnel {
	private RemoteServer using = RemoteServer.SERVER1;
	
	private ServerData server = null;

	public static void main(String[] args) {
		YourTunnel t = new YourTunnel();
		try {
			t.go(t.server);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void go(ServerData server) throws Exception {
		server = ServerData.builder()
				.host(using.host())
				.port(using.remotePort())
				.build();
		
		String user = "xxxxxx";
		String password = "xxxxxx";

		// SSH server info
		String host = "xxxxx";
		int port = 22;

		int tunnelLocalPort = using.localPort();

		String tunnelRemoteHost = server.getHost();
		int tunnelRemotePort = server.getPort();

		JSch jsch = new JSch();
		Session session = jsch.getSession(user, host, port);
		session.setPassword(password);
		java.util.Properties config = new java.util.Properties();
		config.put("PreferredAuthentications", "password");
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		UserInfo lui = new LocalUserInfo();
		session.setUserInfo(lui);
		session.connect();
		session.setPortForwardingL(tunnelLocalPort, tunnelRemoteHost, tunnelRemotePort);
		System.out.println("Connected to " + using.name() + ":" + using.host() + ":" + using.remotePort() + " through port " + using.localPort());

	}

}
