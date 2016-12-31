package com.wz.mybatis.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.wz.mybatis.mapper.UserMapper;
import com.wz.mybatis.po.User;
import com.wz.mybatis.po.UserQueryVo;

public class MybatisTest {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		// 读取配置文件
		// 全局配置文件的路径
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}

	@Test
	public void findUserByIdTest() throws Exception {

		// 创建UserMapper对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//由mybatis通过sqlSession来创建代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(1);
		System.out.println(user);
		sqlSession.close();
	}
	
	@Test
	public void InsertUserTest() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user = new User();
		user.setUsername("张三");
		user.setAddress("上海");
		user.setSex("男");
		
		userMapper.insertUser(user);
		
		System.out.println(user.getId());
		
		sqlSession.commit();
	
		sqlSession.close();
	}
	
	
	@Test
	public void findUserByName() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		List<User> users = userMapper.findUsersByName("王");
		
		System.out.println(users);
		sqlSession.close();
	}
	
	@Test
	public void findUserList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		UserQueryVo vo = new UserQueryVo();
		
		List<Integer> idList = new ArrayList<>();
		idList.add(24);
		idList.add(25);
		idList.add(26);
		
		vo.setIdList(idList);
		
		List<User> users = userMapper.findUserList(vo);
		
		int count = userMapper.findUserCount(vo);
		
		System.out.println("-------users : " + users);
		System.out.println("-------count : " + count);
		sqlSession.close();
	}

}










