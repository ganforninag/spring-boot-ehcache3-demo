package com.itclj.service;

import com.itclj.model.UserBean;

/**
 * Created by clj on 2017/6/17.
 */
public interface UserService {

    UserBean getById(Long id);

    UserBean getByName(String name);

}
