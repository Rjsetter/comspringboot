//package com.example.Utils;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.*;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//
///**
// * 登录配置
// */
//@Configuration
//public class WebSecurityConfig extends WebMvcConfigurationSupport {
//
//    /**
//     * 登录session key
//     */
//    public final static String SESSION_USERNAME = "username";
//    public final static String SESSION_ROLE = "role";
//
//    @Bean
//    public SecurityInterceptor getSecurityInterceptor() {
//        return new SecurityInterceptor();
//    }
//
//    public void addInterceptors(InterceptorRegistry registry) {
//        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
//
//        // 排除配置
//        addInterceptor.excludePathPatterns("/**/*.js");
//        addInterceptor.excludePathPatterns("/**/*.css");
//        addInterceptor.excludePathPatterns("/**/*.map");
//        addInterceptor.excludePathPatterns("/**/*.svg");
//        addInterceptor.excludePathPatterns("/**/*.jpg");
//        addInterceptor.excludePathPatterns("/user/login");
//        addInterceptor.excludePathPatterns("/login/index");
//        addInterceptor.excludePathPatterns("/error");
//
//
//        // 拦截配置
//        addInterceptor.addPathPatterns("/**");
//    }
//
//    private class SecurityInterceptor extends HandlerInterceptorAdapter {
//
//        @Override
//        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//                throws Exception {
//            HttpSession session = request.getSession();
//            if (session.getAttribute(SESSION_USERNAME) != null && session.getAttribute(SESSION_ROLE) != null) {
//                return true;
//            }
//
//            // 跳转登录
//            System.out.println(request.getRequestURI());
//            String url = "/user/login";
//            response.sendRedirect(url);
//            return false;
//        }
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        super.addResourceHandlers(registry);
//    }
//
//}
////@Configuration
////public class WebSecurityConfig extends WebMvcConfigurerAdapter{
////    public final static String SESSION_KEY="username";
////
////    @Bean
////    public SecurityInterceptor getSecurityInterceptor(){
////        return new SecurityInterceptor();
////    }
////
////    public void  addInterceptors(InterceptorRegistry registry){
////        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
////
////        addInterceptor.excludePathPatterns("/error");
////        addInterceptor.excludePathPatterns("/user/login");
////        addInterceptor.addPathPatterns("/**");
////    }
////
////    private class SecurityInterceptor extends HandlerInterceptorAdapter{
////        @Override
////        public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws IOException {
////            HttpSession session = request.getSession();
////
//////            判断是否已有该用户登录的session
////            if(session.getAttribute(SESSION_KEY) != null){
////                return true;
////            }
////
//////            跳转到登录页
////            String url = "/user/login";
////            response.sendRedirect(url);
////            return false;
////        }
////    }
////}