package com.ins.mapper.user;

import java.util.List;

import com.ins.common.dto.Message;
import com.ins.common.dto.Page;
import com.ins.user.dto.MENU_CD;
import com.ins.user.dto.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    Message login(User user);

    List<User> userGet(Page p);

    List<MENU_CD> menuGet(Page p);
}