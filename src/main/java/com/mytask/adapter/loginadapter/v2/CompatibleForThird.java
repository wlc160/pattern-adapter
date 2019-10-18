package com.mytask.adapter.loginadapter.v2;

import com.mytask.adapter.loginadapter.MsgResult;

/**
 * 工程名:pattern-adapter
 * 包名:com.mytask.adapter.loginadapter.v2
 * 文件名:CompatibleForThird
 * description:
 *
 * @author lcwen
 * @version V1.0: CompatibleForThird.java 2019/10/18 9:54
 **/
public interface CompatibleForThird {

    MsgResult loginForQQ(String openid);

    MsgResult loginForWechat(String openid);

    MsgResult loginForPhone(String phone ,String code);

}
