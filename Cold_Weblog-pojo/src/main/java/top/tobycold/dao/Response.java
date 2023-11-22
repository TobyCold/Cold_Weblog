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

    public static <T> Response<T> success() {
        Response<T> seccess = new Response<T>();
        seccess.code = 1;
       return seccess;
    }
    public static <T> Response<T> success(String message) {
        return new Response<T>(1, message, null);
    }
    public static <T> Response<T> success(String message, T t) {
        return new Response<T>(1, message,t);
    }

    public static <T>Response<T> error(T t) {
        return new Response<>(0, null, t);
    }
    public static <T> Response<T> error(String mes, T t) {
        return new Response<T>(0, mes,t);
    }
}
