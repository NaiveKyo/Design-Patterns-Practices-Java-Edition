package io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 容器上下文, 包含各类资源
 */
public class Context {
    
    private static List<UserSubject> certifiedUser;
    
    static {
        // 假设应用程序上下文中已经存在一组认证过的用户
        certifiedUser = new ArrayList<>();
        certifiedUser.add(new UserSubject("lucy", Arrays.asList(Privilege.values())));
        certifiedUser.add(new UserSubject("jack", Collections.singletonList(Privilege.LIST_ORDER)));
    }

    /**
     * 检验权限标识是否有效
     * @param permissionIdentify 权限标识符
     * @return 检测结果 true/false
     */
    public static boolean illegalPrivilege(String permissionIdentify) {
        if (permissionIdentify == null || "".equals(permissionIdentify))
            return false;
        Privilege privilege = Arrays.stream(Privilege.values()).filter(p -> p.getName().equals(permissionIdentify)).findAny().orElse(null);
        return privilege != null;
    }

    /**
     * 校验用户的操作是否被授权
     * @param username  用户名
     * @param privilege 要执行的操作
     * @return true/false
     */
    public static boolean checkUserCertified(String username, String privilege) {
        UserSubject subject = certifiedUser.stream().filter(user -> user.getName().equals(username)).findFirst().orElse(null);
        if (subject == null)
            return false;
        return subject.getPrivileges().stream().anyMatch(p -> p.getName().equals(privilege));
    }
    
    public enum Privilege {
        CREATE_ORDER("创建订单"), DELETE_ORDER("删除订单"),
        LIST_ORDER("展示订单"), MODIFY_ORDER("修改订单");
        
        private String name;

        Privilege(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 用户主体, 包含用户名和拥有的权限
     */
    static class UserSubject {
        private String name;
        private List<Privilege> privileges;

        public UserSubject(String name, List<Privilege> privileges) {
            this.name = name;
            this.privileges = privileges;
        }

        public void setPrivileges(List<Privilege> privileges) {
            this.privileges = privileges;
        }

        public String getName() {
            return name;
        }

        public List<Privilege> getPrivileges() {
            return privileges;
        }
    }
}
