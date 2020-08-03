package org.systemtest.demo.vo;

import lombok.SneakyThrows;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.systemtest.demo.entity.UserRole;
import org.systemtest.demo.service.UserService;
import org.systemtest.demo.utils.JwtUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 12589
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username= JwtUtil.getUsername(principalCollection.toString());
        UserRole userRole=userService.getSecureUser();
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(Arrays.asList(userRole.getRoles().split(",")));
        Set<String> permissions=new HashSet<String>(Arrays.asList(userRole.getPermission().split(",")));
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    @SneakyThrows
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token= (String) authenticationToken.getCredentials();
        String username=JwtUtil.getUsername(token);
        if (username==null){
            throw new AuthenticationException("用户名为空");
        }
        UserRole userRole=userService.getUserRoleById(username);
        if (userRole==null){
            throw new AuthenticationException("用户不存在");
        }
        if (!JwtUtil.verify(token,username,userRole.getPassword())){
            throw new AuthenticationException("用户名/密码  有误");
        }
        return new SimpleAuthenticationInfo(token,token,"user_realm");
    }
}
