package com.douzone.container.user;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class User {

	private int id = 0;
	private String name = "김재홍";
	private Friend friend;
	private List<String> friends;
	
	
	public User() {}
	public User(String name) {
		this.name = name;
	}
	public User(int id,String name) {
		this.id = id;
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setFriend(Friend friend) {
		this.friend = friend;
	}
	
	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", friend=" + friend + ", friends=" + friends + "]";
	}
}
