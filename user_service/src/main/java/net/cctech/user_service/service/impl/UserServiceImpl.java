package net.cctech.user_service.service.impl;

import net.cctech.user_service.dao.UserRepository;
import net.cctech.user_service.domain.User;
import net.cctech.user_service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private static final Map<Integer, User> daoMap = new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger(getClass());

    static {

        User p1 = new User(1,"iphonex","9999", 10);
        User p2 = new User(2,"冰箱","5342", 19);
        User p3 = new User(3,"洗衣机","523", 90);
        User p4 = new User(4,"电话","64345", 150);
        User p5 = new User(5,"汽车","2345", 140);
        User p6 = new User(6,"椅子","253", 20);
        User p7 = new User(7,"java编程思想","2341", 10);

        daoMap.put(p1.getId(),p1);
        daoMap.put(p2.getId(),p2);
        daoMap.put(p3.getId(),p3);
        daoMap.put(p4.getId(),p4);
        daoMap.put(p5.getId(),p5);
        daoMap.put(p6.getId(),p6);
        daoMap.put(p7.getId(),p7);
    }




    @Override
    public List<User> listProduct() {

        Collection<User> collection = daoMap.values();
        List<User> list = new ArrayList<>(collection);

        return list;
    }

    @Override
    public User findById(int id) {
        logger.info("service findById");
        return daoMap.get(id);
    }

    @Override
    public List<User> dbList() {
        return userRepository.findAll();
    }

    @Override
    public User findDbById(int id) {
        return userRepository.findOneById(id);
    }
}
