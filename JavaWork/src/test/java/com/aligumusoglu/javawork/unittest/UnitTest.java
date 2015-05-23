package com.aligumusoglu.javawork.unittest;

import org.junit.Assert;
import org.junit.Test;

import com.aligumusoglu.javawork.dao.BaseDao;
import com.aligumusoglu.javawork.dao.UserDao;
import com.aligumusoglu.javawork.enums.PublicResult;
import com.aligumusoglu.javawork.model.User;

public class UnitTest extends BaseDao {

	@Test
	public void saveTest() {

		User testUser = new User();
		testUser.setName("testName");
		testUser.setSurname("testSurname");
		testUser.setPhone("(541) 249-2633");
		UserDao userDao = new UserDao();
		PublicResult sonuc = userDao.save(testUser);
		Assert.assertTrue("Hata!", sonuc == PublicResult.SUCCESS);
	}

}
