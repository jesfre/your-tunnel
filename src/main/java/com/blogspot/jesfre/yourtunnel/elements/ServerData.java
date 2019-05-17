package com.blogspot.jesfre.yourtunnel.elements;

import lombok.Builder;
import lombok.Data;

/**
 * @author <a href="mailto:jorge.ruiz.aquino@gmail.com">Jorge Ruiz Aquino</a>
 * May 15, 2019
 */
@Data
@Builder
public class ServerData {

	private String host;
	private Integer port;
	private String username;
	private String password;
	
	@Builder
	private ServerData(String host, Integer port, String username, String password) {
		this.host = host;
		this.port = port;
		this.username = username;
		this.password = password;
	}
	
}
