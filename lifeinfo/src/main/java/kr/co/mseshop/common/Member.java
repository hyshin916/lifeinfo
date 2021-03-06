package kr.co.mseshop.common;

import javax.validation.constraints.NotBlank;

public class Member{

    private Integer id;
    
    @NotBlank
    private String account;

    //Password 검증 어노테이션 등록
    @Password(min = 3, max = 10, nullable = true)
    private String password;

    @NotBlank
    private String name;

    private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//setter,getter 생략
    
    
    
    
}
