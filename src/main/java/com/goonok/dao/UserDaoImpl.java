package com.goonok.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.goonok.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional
	@Override
	public int registerUser(User user) {
		int i = (int) hibernateTemplate.save(user);
		return i;
	}

	@Transactional
	@Override
	public void updateUser(User user) {
		hibernateTemplate.update(user);

	}

	@Transactional
	@Override
	public void deleteUser(int id) {
		User user = hibernateTemplate.get(User.class, id);
		hibernateTemplate.delete(user);
	}

	@Override
	public User getUserById(int id) {
		User user = hibernateTemplate.get(User.class, id);
		return user;
	}

	@Override
	public List<User> getAllUserInformation() {
		List<User> userList = hibernateTemplate.loadAll(User.class);
		return userList;
	}

	@Transactional
	@Override
	public User loginUser(String email, String password) {
		
		//select * from user_registration_table where email =? and password =?; ->user object
		String sql = "from User where email=:eml and password=:pass";
		User user = (User) hibernateTemplate.execute( s ->{
			Query q = s.createQuery(sql);
			q.setParameter("eml", email);
			q.setParameter("pass", password);
			return q.uniqueResult();
		});
		return user;
	}

}
