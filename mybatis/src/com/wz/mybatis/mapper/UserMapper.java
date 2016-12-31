package com.wz.mybatis.mapper;

import java.util.List;

import com.wz.mybatis.po.User;
import com.wz.mybatis.po.UserQueryVo;

public interface UserMapper {
	
	/**
	 * 根据用户ID查询用户信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User findUserById(int id) throws Exception;
	
	/**
	 * 根据用户名字模糊查询用户列表
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<User> findUsersByName(String name) throws Exception;
	
	/**
	 * 添加用户
	 * @param user
	 * @throws Exception
	 */
	public void insertUser(User user) throws Exception;
	
	/**
	 * 综合查询
	 * @param vo
	 * @return
	 */
	public List<User> findUserList(UserQueryVo vo);
	
	/**
	 * 综合查询用户总数
	 * @param vo
	 * @return
	 */
	public int findUserCount(UserQueryVo vo);

}
