

package com.ratel.shiro.modules.jwt.service.impl;



import com.ratel.shiro.common.exception.RRException;
import com.ratel.shiro.common.validator.Assert;
import com.ratel.shiro.modules.jwt.dao.JwtUserDao;
import com.ratel.shiro.modules.jwt.entity.UserEntity;
import com.ratel.shiro.modules.jwt.form.LoginForm;
import com.ratel.shiro.modules.jwt.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
  *@业务描述：
  *@author：
  *@create_time： 2019/12/13 17:37
  */  
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired(required = false)
	private JwtUserDao userDao;

	@Override
	public UserEntity queryByMobile(String mobile) {
		return userDao.selectOne( mobile);
	}

	@Override
	public long login(LoginForm form) {
		UserEntity user = queryByMobile(form.getMobile());
		Assert.isNull(user, "手机号或密码错误");

		//密码错误
		if(!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))){
			throw new RRException("手机号或密码错误");
		}

		return user.getUserId();
	}

    @Override
    public UserEntity getById(Integer id) {
       return userDao.selectById(id);
    }
}
