package com.mytask.adapter.loginadapter.v1;

import com.mytask.adapter.loginadapter.MsgResult;

/**
 * 工程名:pattern-adapter
 * 包名:com.mytask.adapter.loginadapter.v1
 * 文件名:SignServiceTest
 * description:
 *
 * @author lcwen
 * @version V1.0: SignServiceTest.java 2019/10/18 9:43
 **/
public class SignServiceTest {

    public static void main(String[] args) {
        SignForThirdService service = new SignForThirdService();
        MsgResult mr1 = service.loginForQQ("sss");
        System.out.println(mr1);
        MsgResult mr2 = service.login("lcwen", "123456");
        System.out.println(mr2);
    }
}
