package com.aligumusoglu.javawork.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ali
 */

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.aligumusoglu.javawork.enums.AppLogType;
import com.aligumusoglu.javawork.enums.PublicResult;
import com.aligumusoglu.javawork.model.User;
import com.aligumusoglu.javawork.dao.AppLogDao;
import com.aligumusoglu.javawork.dao.UserDao;

/**
 * 
 * @author Ali Gümüşoğlu
 *
 */

@ManagedBean
@ViewScoped
public class MainPageBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<User> userList = new ArrayList<User>();
	private User selectedUser;

	// When running this class, users are fetching firstly.
	@PostConstruct
	public void initBean() {
		fetchUserList();
	}

	// Fetch user list to data table from database
	private void fetchUserList() {
		userList = new UserDao().fetchUserList();
	}

	// When user click the 'Yeni' button, prepare a new 'User' object.
	public void newUser() {
		selectedUser = new User();
	}

	// When user click the ''save'' button in dialog page, this method start
	// working.
	// If 'selectedUser' was empty, this means it is a new record so 'save'
	// method will start in UserDao.
	// If 'selectedUser' was loaded, this means it is a update process so
	// 'updateUser' method will start in UserDao.

	public void save() {

		PublicResult result = PublicResult.FAIL;
		boolean save = selectedUser.get_id() == null ? true : false;
		if (save)
			result = new UserDao().save(selectedUser);
		else
			result = new UserDao().updateUser(selectedUser.get_id(),
					selectedUser);
		if (result == PublicResult.SUCCESS) {
			addSavedMessage();
			
			fetchUserList();
			new AppLogDao().saveAppLog(save == true ? AppLogType.SAVE
					: AppLogType.UPDATE, selectedUser);
			hideDialog("userDlg");
		} else if (result == PublicResult.DUMPLICATE) {
			addWarningMessage("Kayıt mevcut!");
		} else {
			addNotDeletedMessage();
		}

		updateGrowl();
	}

	// Delete user from database.
	public void delete() {
		PublicResult result = new UserDao().deleteUser(selectedUser.get_id());
		if (result == PublicResult.SUCCESS) {
			addDeletedMessage();
			fetchUserList();
			new AppLogDao().saveAppLog(AppLogType.DELETE, selectedUser);
		}

		else if (result == PublicResult.DUMPLICATE) {
			addWarningMessage("Kayıt mevcut!");
		} else {
			addNotDeletedMessage();
		}
		updateGrowl();

	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

}
