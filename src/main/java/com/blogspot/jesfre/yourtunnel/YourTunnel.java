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
			t.connect(t.server);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void connect(ServerData server) throws Exception {
		server = ServerData.builder()
				.host(using.host())
				.port(using.remotePort())
				.build();
		
		ServerData sshServer = ServerData.builder()
				.host("xxxxx")
				.port(22)
				.username("uuuuu")
				.password("ppppp")
				.build();

		int tunnelLocalPort = using.localPort();

		JSch jsch = new JSch();
		Session session = jsch.getSession(sshServer.getUsername(), sshServer.getHost(), sshServer.getPort());
		session.setPassword(sshServer.getPassword());
		java.util.Properties config = new java.util.Properties();
		config.put("PreferredAuthentications", "password");
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		UserInfo lui = new LocalUserInfo();
		session.setUserInfo(lui);
		session.connect();
		session.setPortForwardingL(tunnelLocalPort, server.getHost(), server.getPort());
		System.out.println("Connected to " + using.name() + ":" + using.host() + ":" + using.remotePort() + " through port " + using.localPort());

	}

}
