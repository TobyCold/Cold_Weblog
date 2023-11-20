package top.tobycold.admin;

public class BaseContext {
    public static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static String getContext(){
        return threadLocal.get();
    }

    public static void setContext(String str){
        threadLocal.set(str);
    }
}
