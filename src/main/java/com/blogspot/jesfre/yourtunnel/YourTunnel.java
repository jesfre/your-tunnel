/**
 * 
 */
package com.blogspot.jesfre.yourtunnel;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;

/**
 * @author <a href="mailto:jorge.ruiz.aquino@gmail.com">Jorge Ruiz Aquino</a>
 * May 15, 2019
 */
public class YourTunnel {

	public static void main(String[] args) throws JSchException {
		String user = "xxxxxx";
		String password = "xxxxxx";

		// SSH server info
		String host = "xxxxx";
		int port = 22;

		int tunnelLocalPort = 55555;

		String tunnelRemoteHost = "server1";
		int tunnelRemotePort = 9999;

		JSch jsch = new JSch();
		Session session = jsch.getSession(user, host, port);
		session.setPassword(password);
		java.util.Properties config = new java.util.Properties();
		config.put("PreferredAuthentications", "password");
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		UserInfo lui = new UserInfo() {
			
			@Override
			public void showMessage(String message) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean promptYesNo(String message) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean promptPassword(String message) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean promptPassphrase(String message) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public String getPassword() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getPassphrase() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		session.setUserInfo(lui);
		session.connect();
		session.setPortForwardingL(tunnelLocalPort, tunnelRemoteHost, tunnelRemotePort);
		System.out.println("Connected to " + tunnelRemoteHost + ":" + tunnelRemotePort + " through port " + port);

	}

}
