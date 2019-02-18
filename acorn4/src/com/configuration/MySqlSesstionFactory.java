package com.configuration;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//Configuration.xml 설정
//SqlSesstionFactory 얻기
//deptService
public class MySqlSesstionFactory {
	private static SqlSessionFactory sqlSessionFactory=null;
	static {
		String resource = "com/configuration/Configuration.xml";
		InputStream inputStream=null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sqlSessionFactory =
		  new SqlSessionFactoryBuilder().build(inputStream);
	}
	public static SqlSession getSesstion() {
		return sqlSessionFactory.openSession();
	}
}
