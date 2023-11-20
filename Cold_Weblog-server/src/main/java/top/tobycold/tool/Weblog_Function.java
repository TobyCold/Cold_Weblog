package top.tobycold.tool;

@FunctionalInterface
public interface Weblog_Function<T> {
    T splicePath(Runnable runnable);
}
