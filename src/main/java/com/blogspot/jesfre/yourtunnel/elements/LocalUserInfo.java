package com.blogspot.jesfre.yourtunnel.elements;

import com.jcraft.jsch.UserInfo;

public class LocalUserInfo implements UserInfo {
	private String password;

	public String getPassword() {
		return password;
	}

	public boolean promptYesNo(String str) {
		return true;
	}

	public String getPassphrase() {
		return null;
	}

	public boolean promptPassphrase(String message) {
		return true;
	}

	public boolean promptPassword(String message) {
		return true;
	}

	public void showMessage(String message) {
	}
}