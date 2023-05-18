package io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.request;

/**
 * 对请求的包装, 后续可以接着扩展该类
 */
public class StandardRequest implements Request {

    /**
     * 一次请求需要携带用户信息
     */
    private String username;

    /**
     * 要进行的操作对应的权限标识符
     */
    private String doPrivilege;

    public StandardRequest(String username, String doPrivilege) {
        this.username = username;
        this.doPrivilege = doPrivilege;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPrivilege() {
        return doPrivilege;
    }
}
