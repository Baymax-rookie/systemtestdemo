package org.systemtest.demo.control;

import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 12589
 */
@RequestMapping("/hjlogin")
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(String name){
        return "hello there "+name;
    }
}
