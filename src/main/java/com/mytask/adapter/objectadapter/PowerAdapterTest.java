package com.mytask.adapter.objectadapter;

/**
 * 工程名:pattern-adapter
 * 包名:com.mytask.adapter.objectadapter
 * 文件名:PowerAdapterTest
 * description:
 *
 * @author lcwen
 * @version V1.0: PowerAdapterTest.java 2019/10/18 9:18
 **/
public class PowerAdapterTest {

    public static void main(String[] args) {
        PowerAdapter adapter = new PowerAdapter(new Ac220());
        adapter.outputDc5();

    }
}
