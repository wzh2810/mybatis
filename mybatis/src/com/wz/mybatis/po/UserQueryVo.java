package com.wz.mybatis.po;

import java.util.List;

public class UserQueryVo {

	//用户信息
	public User user;
	
	//商品ID集合
	private List<Integer> idList;
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Integer> getIdList() {
		return idList;
	}

	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}
	
	
}
