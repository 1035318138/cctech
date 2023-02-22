package net.cctech.user_service.controller;

import net.cctech.user_service.annotation.Audit;
import net.cctech.user_service.domain.User;
import net.cctech.user_service.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {



    @Value("${server.port}")
    private String port;

    @Autowired
    private UserService userService;

    /**
     * 会员列表(不查库)
     * @return
     */
    @Audit(eventType = "会员列表(不查库)",object = "mockList")
    @RequestMapping("mockList")
    public Object mockList(){
        return userService.listProduct();
    }

    /**
     * 会员列表(查库)
     * @return
     */
    @Audit(eventType = "会员列表查询")
    @RequestMapping("dbList")
    public Object dbList(){
        return userService.dbList();
    }


    /**
     * 根据id查找会员信息
     * @param id
     * @return
     */
    @Audit(eventType = "根据id查找会员信息(非数据库查询)",object = "find")
    @RequestMapping("find")
    public Object findById(int id){

        User user = userService.findById(id);

        User result = new User();
        BeanUtils.copyProperties(user,result);
        result.setName( result.getName() + " data from port="+port );
        return result;
    }


    /**
     * 根据id查找会员信息
     * @param id
     * @return
     */
    @Audit(eventType = "根据id查找会员信息",object = "user查询接口")
    @RequestMapping("findDb")
    public Object findDb(int id){

        User user = userService.findDbById(id);

        User result = new User();
        BeanUtils.copyProperties(user,result);
        result.setName( result.getName() + " data from port="+port );
        return result;
    }



}
