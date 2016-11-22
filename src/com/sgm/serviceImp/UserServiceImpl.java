package com.sgm.serviceImp;

import java.util.List;

import com.sgm.dao.UserDao;
import com.sgm.entity.User;
import com.sgm.service.UserService;  
  
public class UserServiceImpl implements UserService {  
  
    public UserDao userDao;  
    
    public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override  
    public User getUser(int id) {  
        return userDao.getUser(id);  
    }  
  
    @Override  
    public List<User> getAllUser() {  
        return userDao.getAllUser();  
    }  
  
    @Override  
    public void addUser(User user) {  
        userDao.addUser(user);  
    }  
  
    @Override  
    public boolean delUser(int id) {  
          
        return userDao.delUser(id);  
    }  
  
    @Override  
    public boolean updateUser(User user) {  
        return userDao.updateUser(user);  
    }
}  
