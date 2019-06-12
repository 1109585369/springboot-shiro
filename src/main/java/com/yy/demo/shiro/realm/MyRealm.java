package com.yy.demo.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author yy
 * @ProjectName springboot-shiro
 * @Description: TODO
 * @date 2019/6/11 15:07
 */
public class MyRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        if(!"javaboy".equals(userName)){
            throw new UnknownAccountException("账户不存在");
        }
        return new SimpleAuthenticationInfo(userName,"123",getName());
    }
}
