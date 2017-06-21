package com.itclj.service.impl;

import com.itclj.model.UserBean;
import com.itclj.service.UserService;
import java.util.concurrent.TimeUnit;
import javax.cache.CacheManager;
import javax.cache.annotation.CacheResult;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.Duration;
import javax.cache.expiry.TouchedExpiryPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by clj on 2017/6/17.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

  Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

  @Component
  public static class CachingSetup implements JCacheManagerCustomizer
  {
    @Override
    public void customize(CacheManager cacheManager)
    {
      cacheManager.createCache("users", new MutableConfiguration<>()
          .setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(TimeUnit.SECONDS, 10)))
          .setStoreByValue(false)
          .setStatisticsEnabled(true));
    }
  }


  UserBean userBean;

  UserServiceImpl() {
    userBean = new UserBean();
    userBean.setBirthday(new Date());
    userBean.setId(123L);
    userBean.setName("张山");
  }

  @Override
  @CacheResult
  public UserBean getById(Long id) {
    logger.info("Get User By Id:{}", id);
    return this.userBean;
  }

  @Override
  @CacheResult(cacheName = "users")
  public UserBean getByName(String name) {
    logger.info("-------------------------Get User By name:{}", name);
    return userBean;
  }
}
