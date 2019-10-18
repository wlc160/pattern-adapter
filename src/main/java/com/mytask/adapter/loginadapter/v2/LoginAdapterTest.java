package com.mytask.adapter.loginadapter.v2;

/**
 * 工程名:pattern-adapter
 * 包名:com.mytask.adapter.loginadapter.v2
 * 文件名:LoginAdapterTest
 * description:
 *
 * @author lcwen
 * @version V1.0: LoginAdapterTest.java 2019/10/18 9:51
 **/
public class LoginAdapterTest {

    public static void main(String[] args) {
        ThirdLoginServiceImpl impl = new ThirdLoginServiceImpl();
        System.out.println(impl.loginForQQ("1"));
        System.out.println(impl.loginForWechat("1"));
        System.out.println(impl.loginForPhone("133333333","456789"));
    }
}
