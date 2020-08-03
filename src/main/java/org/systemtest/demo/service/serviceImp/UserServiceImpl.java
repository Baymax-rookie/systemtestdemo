package org.systemtest.demo.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.systemtest.demo.entity.SysUser;
import org.systemtest.demo.entity.UserRole;
import org.systemtest.demo.mapper.UserMapper;
import org.systemtest.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserRole getSecureUser() {
            return new UserRole("testuser","password","user,admin","view,write");
    }

    @Override
    public UserRole getUserRoleById(String username) {
            return new UserRole("test2","password","user,superAdmin","view,write,delete");
    }

    @Override
    public SysUser getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public SysUser getUserByUsername(String username) {
        return userMapper.getUserByUserName(username);
    }

    @Override
    public Integer getPhoneByName(String name) {
        return userMapper.getPhoneByName(name);
    }

    @Override
    public String getSaltById(Integer id) {
        return userMapper.getSalt(id);
    }


}
