package com.mytask.adapter.loginadapter.v2;

import com.mytask.adapter.loginadapter.MsgResult;
import com.mytask.adapter.loginadapter.v1.SignService;
import com.mytask.adapter.loginadapter.v2.adapters.LoginAdapter;
import com.mytask.adapter.loginadapter.v2.adapters.LoginForPhoneAdapter;
import com.mytask.adapter.loginadapter.v2.adapters.LoginForWechatAdapter;
import com.mytask.adapter.loginadapter.v2.adapters.LoginQQAdapter;

/**
 * 工程名:pattern-adapter
 * 包名:com.mytask.adapter.loginadapter.v2
 * 文件名:ThirdLoginServiceImpl
 * description:
 * *********   简单工厂、策略设计模式结合使用  *********
 * @author lcwen
 * @version V1.0: ThirdLoginServiceImpl.java 2019/10/18 9:58
 **/
public class ThirdLoginServiceImpl extends SignService implements CompatibleForThird {
    @Override
    public MsgResult loginForQQ(String openid) {
        return processLogin(openid, LoginQQAdapter.class);
    }

    @Override
    public MsgResult loginForWechat(String openid) {
        return processLogin(openid, LoginForWechatAdapter.class);
    }

    @Override
    public MsgResult loginForPhone(String phone, String code) {
        return processLogin(phone, LoginForPhoneAdapter.class);
    }

    //简单工厂设计模式
    private MsgResult processLogin(String key , Class<? extends LoginAdapter> clazz){
        try{
            LoginAdapter adapter = clazz.newInstance();
            if (adapter.isSupport(adapter)){
                return adapter.login(key,adapter);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
