package com.mysql.mysqldemo.service.serviceimpl;

import com.mysql.mysqldemo.entity.User;
import com.mysql.mysqldemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author leslie
 * @Date 2022/7/21 15:15
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean register(User user) {
        Integer count = jdbcTemplate.queryForObject("select count(*) from user where name = ?",
                Integer.class,
                user.getName());
        //数据库字段为非null设置，这里校验输入是否为空字符串
        if(count == 0 && user.getName() != "" && user.getPassword() != ""){
            jdbcTemplate.update("INSERT INTO user(name,password) VALUES(?,?)",
                    user.getName(),
                    user.getPassword());
            return true;
        }
        return false;
    }

    @Override
    public boolean login(User user) {
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        List<User> userList = jdbcTemplate.query("SELECT name,password FROM user WHERE name = ? AND password = ?",
                rowMapper,
                user.getName(),
                user.getPassword());
        if(userList.size() > 0){
            return true;
        }
        return false;
    }
}
