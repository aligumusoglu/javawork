package com.aligumusoglu.javawork.dao;

import com.aligumusoglu.javawork.enums.AppLogType;
import com.aligumusoglu.javawork.model.User;
import com.mongodb.BasicDBObject;

/**
 * 
 * @author Ali Gümüşoğlu
 *
 */

public class AppLogDao extends BaseDao {

	//This method saving a user's process.
	public void saveAppLog(AppLogType appLogType, User user) {
		try {
			BasicDBObject object = new BasicDBObject();
			object.put("app_log_type", appLogType.getType());
			object.put("app_log_name", appLogType.getTypeName());
			object.put("user_info", user.getName() + " " + user.getSurname());

			getDbCollection("log").insert(object);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
