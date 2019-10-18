package com.mytask.adapter.loginadapter.v2.adapters;

import com.mytask.adapter.loginadapter.MsgResult;

/**
 * 工程名:pattern-adapter
 * 包名:com.mytask.adapter.loginadapter.v2
 * 文件名:LoginAdapter
 * description:
 *
 * @author lcwen
 * @version V1.0: LoginAdapter.java 2019/10/18 9:46
 **/
public interface LoginAdapter {

    boolean isSupport(Object adapter);

    MsgResult login(String id ,Object adapter);
}
