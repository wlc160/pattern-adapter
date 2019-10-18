package com.mytask.adapter.loginadapter;

/**
 * 工程名:pattern-adapter
 * 包名:com.mytask.adapter.loginadapter
 * 文件名:MsgResult
 * description:
 *
 * @author lcwen
 * @version V1.0: MsgResult.java 2019/10/18 9:30
 **/
public class MsgResult {

    private int code;
    private String msg;
    private Object data;

    public MsgResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        return "MsgResult{" + "code=" + code + ", msg='" + msg + '\'' + ", data=" + data + '}';
    }
}
