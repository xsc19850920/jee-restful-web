package io.github.howiefh.jeews.test.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestUser implements Serializable {
	private static final long serialVersionUID = 5528940907575087443L;
	private long id;
    private String username;
    private String password;
    private String salt;
    private List<String> rolesList;
    @JsonIgnore
    private String roles;
    private boolean locked;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
    @JsonIgnore
	public String getPassword() {
		return password;
	}
    @JsonProperty
	public void setPassword(String password) {
        this.password = password;
	}
    public List<String> getRolesList() {
		return rolesList;
	}
	public void setRolesList(List<String> rolesList) {
		this.rolesList = rolesList;
	}
	public String getRoles() {
        //存数据库转成字符串
        roles = rolesList.toString();
		return roles;
	}
	public void setRoles(String roles) {
        String mid = roles.substring(1, roles.length()-1);
        if (rolesList == null) {
            rolesList = new ArrayList<String>();
		}
        //从数据库取出
        for (String string : mid.split(",")) {
			rolesList.add(string.trim());
		}
		this.roles = roles;
	}
	@JsonIgnore()
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
}