package com.mytask.adapter.loginadapter.v1;

import com.mytask.adapter.loginadapter.MsgResult;
import com.mytask.adapter.loginadapter.User;

/**
 * 工程名:pattern-adapter
 * 包名:com.mytask.adapter.loginadapter
 * 文件名:SignService
 * description:
 *
 * @author lcwen
 * @version V1.0: SignService.java 2019/10/18 9:28
 **/
public class SignService {

    public MsgResult login(String userName, String password) {
        return new MsgResult(1, "登陆成功", new User());
    }

}
