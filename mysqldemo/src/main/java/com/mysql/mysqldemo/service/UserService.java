package com.mysql.mysqldemo.service;

import com.mysql.mysqldemo.entity.User;

public interface UserService {
    public boolean register(User user);
    public boolean login(User user);
}
