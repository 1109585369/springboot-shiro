package com.yy.demo.shiro.config;

import com.yy.demo.shiro.realm.MyRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yy
 * @ProjectName springboot-shiro
 * @Description: TODO
 * @date 2019/6/11 15:16
 */

@Configuration
public class ShiroConfig {

    @Bean
    MyRealm myRealm(){
        return new MyRealm();
    }

    //方式一
//    @Bean
//    SecurityManager securityManager(){
//        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
//        manager.setRealm(myRealm());
//        return manager;
//    }

    @Bean
    DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myRealm());
        return manager;
    }
        //方式一
//    @Bean
//    ShiroFilterFactoryBean shiroFilterFactoryBean(){
//        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
//        bean.setSecurityManager(securityMaShiroConfignager());
//        bean.setLoginUrl("/login");
//        bean.setSuccessUrl("/index");
//        bean.setUnauthorizedUrl("/unauthorizedurl");
//        Map<String,String> map = new LinkedHashMap<>();
//        map.put("/doLogin","anon");
//        map.put("/**","authc");
//        bean.setFilterChainDefinitionMap(map);
//        return bean;
//    }

    //方式二
     @Bean
     ShiroFilterChainDefinition shiroFilterChainDefinition() {
         DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();
         definition.addPathDefinition("/doLogin", "anon");
         definition.addPathDefinition("/**", "authc");
         return definition;
    }
}
