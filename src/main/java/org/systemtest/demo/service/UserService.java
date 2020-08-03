package org.systemtest.demo.service;

import org.springframework.stereotype.Service;
import org.systemtest.demo.entity.SysUser;
import org.systemtest.demo.entity.UserRole;

@Service
public interface UserService  {
    /**
     * 测试方法，随便生成一个SecureUser
     * */
    public UserRole getSecureUser();

    public UserRole getUserRoleById(String username);

    public SysUser getUserById(Integer id);

    public SysUser getUserByUsername(String username);

    public Integer getPhoneByName(String name);

    public String getSaltById(Integer id);
}
