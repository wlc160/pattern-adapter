package com.mytask.adapter.loginadapter.v1;

import com.mytask.adapter.loginadapter.MsgResult;

/**
 * 工程名:pattern-adapter
 * 包名:com.mytask.adapter.loginadapter.v1
 * 文件名:SignForThirdService
 * description:
 *
 * @author lcwen
 * @version V1.0: SignForThirdService.java 2019/10/18 9:38
 **/
public class SignForThirdService extends SignService {

    public MsgResult loginForQQ(String openid){
        return new MsgResult(1,"QQ授权登录成功",null);
    }

    public MsgResult loginForWechat(String openid){
        return new MsgResult(1,"微信授权登录成功",null);
    }
}
