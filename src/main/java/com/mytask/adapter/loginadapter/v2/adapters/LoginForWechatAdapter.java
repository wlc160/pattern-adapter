package com.mytask.adapter.loginadapter.v2.adapters;

import com.mytask.adapter.loginadapter.MsgResult;

/**
 * 工程名:pattern-adapter
 * 包名:com.mytask.adapter.loginadapter.v2
 * 文件名:LoginForWechatAdapter
 * description:
 *
 * @author lcwen
 * @version V1.0: LoginForWechatAdapter.java 2019/10/18 9:50
 **/
public class LoginForWechatAdapter implements LoginAdapter {
    @Override
    public boolean isSupport(Object adapter) {
        return adapter instanceof LoginForWechatAdapter;
    }

    @Override
    public MsgResult login(String id, Object adapter) {
        return new MsgResult(200,"微信授权登录成功",null);
    }
}
