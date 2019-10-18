package com.mytask.adapter.loginadapter.v2.adapters;

import com.mytask.adapter.loginadapter.MsgResult;

/**
 * 工程名:pattern-adapter
 * 包名:com.mytask.adapter.loginadapter.v2
 * 文件名:LoginQQAdapter
 * description:
 *
 * @author lcwen
 * @version V1.0: LoginQQAdapter.java 2019/10/18 9:47
 **/
public class LoginQQAdapter implements LoginAdapter {
    @Override
    public boolean isSupport(Object adapter) {
        return adapter instanceof LoginQQAdapter;
    }

    @Override
    public MsgResult login(String id, Object adapter) {
        return new MsgResult(200,"QQ授权登录成功",null);
    }
}
