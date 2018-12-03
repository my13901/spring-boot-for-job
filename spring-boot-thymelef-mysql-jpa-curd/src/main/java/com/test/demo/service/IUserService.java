package com.test.demo.service;

import com.test.demo.entity.User;

import java.util.List;

public interface IUserService {
    public void save(User user);
    public List<User> list();
    public void delete(Long id);
}
