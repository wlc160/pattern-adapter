package com.mytask.adapter.loginadapter.v2.adapters;

import com.mytask.adapter.loginadapter.MsgResult;

/**
 * 工程名:pattern-adapter
 * 包名:com.mytask.adapter.loginadapter.v2
 * 文件名:LoginForPhoneAdapter
 * description:
 *
 * @author lcwen
 * @version V1.0: LoginForPhoneAdapter.java 2019/10/18 9:49
 **/
public class LoginForPhoneAdapter implements LoginAdapter {
    @Override
    public boolean isSupport(Object adapter) {
        return adapter instanceof LoginForPhoneAdapter;
    }

    @Override
    public MsgResult login(String id, Object adapter) {
        return new MsgResult(200, "手机号登陆成功", null);
    }
}
