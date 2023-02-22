package net.cctech.user_service.service;

import net.cctech.user_service.domain.User;

import java.util.List;

public interface UserService {

    List<User> listProduct();

    User findById(int id);


    List<User> dbList();

    User findDbById(int id);
}
