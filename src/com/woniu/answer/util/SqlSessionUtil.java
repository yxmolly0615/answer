package com.woniu.answer.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 创建一个SqlSession的工具类
 * @author wugd
 *
 */
public class SqlSessionUtil {
	private static SqlSessionFactory sqlSessionFactory ;
	
	static {
		//加载著配置文件 
		//加载Mybatis的主配置文件 
		try {
			InputStream in = Resources.getResourceAsStream("SqlConfig.xml");
			//创建一个SqlSessionFactory
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获得一个SqlSession对象
	 * @return
	 */
	public SqlSession getSqlSession(){
		
		return sqlSessionFactory.openSession();
	}
	
	/**
	 * 释放资源
	 * @param sqlSession
	 */
	public void close(SqlSession sqlSession){
		
		sqlSession.close();
	}
	
	
}
