package com.ins.user;

import java.util.List;

import com.ins.common.dto.Message;
import com.ins.common.dto.Page;
import com.ins.user.dto.MENU_CD;
import com.ins.user.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Message login(@RequestBody User user) {
        return userService.login(user);
    }

    @RequestMapping(value = "/userGet", method = RequestMethod.POST)
    public List<User> userGet(@RequestBody Page p) {
        return userService.userGet(p);
    }

    @RequestMapping(value = "/menuGet", method = RequestMethod.POST)
    public List<MENU_CD> menuGet(@RequestBody Page p) {
        return userService.menuGet(p);
    }

}
