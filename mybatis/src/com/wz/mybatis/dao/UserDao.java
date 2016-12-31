package com.wz.mybatis.dao;

import java.util.List;

import com.wz.mybatis.po.User;

public interface UserDao {

	/**
	 * 根据用户ID查询用户信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public  User findUserById(int id) throws Exception;
	
	/**
	 * 根据用户名字模糊查询用户列表
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<User> findUserByName(String name) throws Exception;
	
	
	/**
	 * 添加用户
	 * @param user
	 * @throws Exception
	 */
	public void insertUser(User user) throws Exception;
}
