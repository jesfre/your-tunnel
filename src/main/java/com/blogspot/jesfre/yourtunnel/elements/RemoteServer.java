package com.blogspot.jesfre.yourtunnel.elements;

/**
 * 
 * @author <a href="mailto:jorge.ruiz.aquino@gmail.com">Jorge Ruiz Aquino</a>
 * May 15, 2019
 */
public enum RemoteServer {
	SERVER1("server1", 0001, 5050), 
	SERVER2("server2", 0002, 5051);

	private String host;
	private Integer remotePort;
	private Integer localPort;

	private RemoteServer(String host, Integer remotePort, Integer localPort) {
		this.host = host;
		this.remotePort = remotePort;
		this.localPort = localPort;
	}

	public String host() {
		return host;
	}

	public Integer remotePort() {
		return remotePort;
	}

	public Integer localPort() {
		return localPort;
	}
	
}