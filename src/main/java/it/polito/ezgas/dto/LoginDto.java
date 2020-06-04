package it.polito.ezgas.dto;

import javax.persistence.Column;
import javax.persistence.Id;

public class LoginDto {
	
	@Id
	private Integer userId;
    @Column
    private String userName;
    @Column
    private String token;
    @Column
    private String email;
    @Column
    private Integer reputation;
    @Column
    private Boolean admin;
    
    public LoginDto (Integer userId, String userName, String token, String email, Integer reputation) {
    	this.userId = userId;
    	this.userName = userName;
    	this.token = token;
    	this.email = email;
    	this.reputation = reputation;
    }
    
    public LoginDto() {}
    
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getReputation() {
		return reputation;
	}
	public void setReputation(Integer reputation) {
		this.reputation = reputation;
	}
    public Boolean getAdmin() {
    	return admin;
    }
    public void setAdmin(Boolean admin) {
    	this.admin = admin;
    }
    
}
