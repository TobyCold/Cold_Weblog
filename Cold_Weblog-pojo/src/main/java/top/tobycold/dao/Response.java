package top.tobycold.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private int code;
    private String message;
    private T data;

    public static <T> Response<T> seccess() {
        Response<T> seccess = new Response<T>();
        seccess.code = 1;
       return seccess;
    }
    public static <T> Response<T> seccess(T t) {
        return new Response<T>(1, null,t);
    }

    public static <T>Response<T> error(T t) {
        return new Response<>(0, null, t);
    }
}
