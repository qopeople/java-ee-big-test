package com.example.bigtest.utils;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class CommonResponse implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 表示当前相应的状态是成功或者失败
     */
    private String code;
    /**
     * 表示当响应失败之后给前端的错误提示
     */
    private String msg;
    /**
     * 表示当响应成功之后返回给前端的数据
     */
    private Object data;

    public static CommonResponse setOk(Object data) {
        return new CommonResponse("200", "请求成功", data);
    }

    public static CommonResponse error(String msg) {
        return new CommonResponse("500", msg, "网络异常，请稍后重试");
    }

    public static CommonResponse error(Integer code, String msg) {
        return new CommonResponse(String.valueOf(code), msg, null);
    }

    public static CommonResponse setOk(String msg, Object data) {
        return new CommonResponse("200", msg, data);
    }

    /**
     *
     */
    public CommonResponse() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param code
     * @param msg
     * @param data
     */
    public CommonResponse(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}

