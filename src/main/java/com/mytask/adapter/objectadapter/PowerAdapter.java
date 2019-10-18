package com.mytask.adapter.objectadapter;

/**
 * 工程名:pattern-adapter
 * 包名:com.mytask.adapter.objectadapter
 * 文件名:PowerAdapter
 * description:
 *
 * @author lcwen
 * @version V1.0: PowerAdapter.java 2019/10/18 9:14
 **/
public class PowerAdapter implements Dc5 {

    public Ac220 ac220;

    public PowerAdapter(Ac220 ac220) {
        this.ac220 = ac220;
    }


    @Override
    public int outputDc5() {
        int input = ac220.outputAc220();
        int output = input / 44;
        System.out.println("使用 PowerAdapter 输入 AC:" + input + "V,输出 Dc " + output + "v");
        return output;
    }
}
