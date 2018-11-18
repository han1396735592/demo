package cn.qqhxj.demo.layui.common;

import lombok.Data;

/**
 * @author han xinjian
 * @date 2018/10/25 15:51
 */
@Data
public class R<T> {

    private boolean success;

    private Integer code;

    private String msg;

    private T data;

    private R() {
    }


    public static <T> R<T> ok(T data) {
        R<T> r = new R<>();
        r.success = true;
        r.data = data;
        r.code = 0;
        return r;
    }

    public static <T> R<T> err(String msg) {
        R<T> r = new R<>();
        r.success = false;
        r.msg = msg;
        r.code = 500;
        return r;
    }


}
