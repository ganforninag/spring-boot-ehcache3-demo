package com.itclj.service.impl;

import com.itclj.model.UserBean;
import com.itclj.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by clj on 2017/6/17.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    UserBean userBean;

    UserServiceImpl() {
        userBean = new UserBean();
        userBean.setBirthday(new Date());
        userBean.setId(123L);
        userBean.setName("张山");
    }

    @Override
    @Cacheable(cacheNames = "users",key = "'userid'+#id")
    public UserBean getById(Long id) {
        logger.info("Get User By Id:{}", id);
        return this.userBean;
    }

    @Override
    @Cacheable(cacheNames = "users",key = "'username'+#name")
    public UserBean getByName(String name) {
        logger.info("Get User By name:{}", name);
        return userBean;
    }
}
