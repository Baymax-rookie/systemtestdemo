package org.systemtest.demo.config;

import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.systemtest.demo.filter.JwtFilter;
import org.systemtest.demo.vo.UserRealm;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 12589
 */
@Configuration
public class ShiroConfig {
//    @Bean
//    public DefaultWebSecurityManager getManager(UserRealm userRealm){
//        DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
//        manager.setRealm(userRealm);
//        DefaultSubjectDAO subjectDAO=new DefaultSubjectDAO();
//        manager.setSubjectDAO(subjectDAO);
//        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator=new DefaultSessionStorageEvaluator();
//        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
//        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
//        manager.setSubjectDAO(subjectDAO);
//        return manager;
//    }
//
//    @Bean("shiroFilter")
//    public ShiroFilterFactoryBean factory(DefaultWebSecurityManager securityManager) {
//        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
//        // 添加自己的过滤器并且取名为jwt
//        Map<String, Filter> filterMap = new HashMap<>();
//        filterMap.put("jwt", new JwtFilter());
//        factoryBean.setFilters(filterMap);
//        factoryBean.setSecurityManager(securityManager);
//        factoryBean.setUnauthorizedUrl("/401");
//        /*
//         * 自定义url规则  博客如下
//         * http://shiro.apache.org/web.html#urls-
//         */
//        Map<String, String> filterRuleMap = new HashMap<>();
//        // 所有请求通过我们自己的JWT Filter
//        filterRuleMap.put("/**", "jwt");
//        // 访问401和404页面不通过我们的Filter
//        filterRuleMap.put("/requestRedirect", "anon");
//        factoryBean.setFilterChainDefinitionMap(filterRuleMap);
//        return factoryBean;
//    }
//    @Bean
//    @DependsOn("lifecycleBeanPostProcessor")
//    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
//        // 强制使用cglib，防止重复代理和可能引起代理出错的问题
//        // https://zhuanlan.zhihu.com/p/29161098
//        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
//        return defaultAdvisorAutoProxyCreator;
//    }
//
//    @Bean
//    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
//        return new LifecycleBeanPostProcessor();
//    }
//
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
//        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
//        advisor.setSecurityManager(securityManager);
//        return advisor;
//    }

}
