package io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.handler;

import io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.container.Context;
import io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.request.Request;
import io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.response.Response;

public class CheckPrivilegeHandler extends BaseHandler {
    
    public CheckPrivilegeHandler(int order) {
        super(order);
    }

    @Override
    protected boolean doHandle(Request request, Response response) {
        // 鉴权
        if (Context.illegalPrivilege(request.getPrivilege())) {
            if (Context.checkUserCertified(request.getUsername(), request.getPrivilege())) {
                response.write("[" + this.getClass().getSimpleName() + " : " + "pass;] ");
                return false;
            } else {
                response.write("[" + this.getClass().getSimpleName() + " : " + " Unauthorized operation!] ");
            }
        } else {
            response.write(this.getClass().getSimpleName() + " : " + " Illegal privilege! ");
        }
        
        return true;
    }
    
    @Override
    protected boolean supportHandle(Request request) {
        // 假设当前 Handler 要处理携带有 privilege 的 Request
        return request.getPrivilege() != null && !"".equals(request.getPrivilege());
    }
    
}
