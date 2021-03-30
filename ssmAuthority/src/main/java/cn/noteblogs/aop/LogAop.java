package cn.noteblogs.aop;

import cn.noteblogs.controllor.SysLogController;
import cn.noteblogs.domain.SysLog;
import cn.noteblogs.service.ISysLogService;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Date;
import java.util.UUID;


public class LogAop {
    @Autowired
    HttpServletRequest request;

    @Autowired
    ISysLogService sysLogService;

    private Date startTime;
    private Date endTime;

    //访问的类
    private Class executionClass;
    //访问的方法
    private Method method;

    private SysLog sysLog = new SysLog();

    /**
     * 表示要切面所有的controller中的所有方法
     * @param joinPoint
     */
    @Before("execution(* cn.noteblogs.controllor.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        startTime = new Date();
        //获取访问路径
        //获取访问的类
        executionClass = joinPoint.getTarget().getClass();
        //获取访问的方法
        String methodName = joinPoint.getSignature().getName();
        //获取访问的参数
        Object[] args = joinPoint.getArgs();
        if(args == null || args.length == 0){
            method = executionClass.getMethod(methodName);
        }else{

            Class[] agrsClass = new Class[args.length];
            for(int i = 0;i < args.length;i++){
                agrsClass[i] = args[i].getClass();
            }
            method = executionClass.getMethod(methodName,agrsClass);
        }

    }

    @After("execution(* cn.noteblogs.controllor.*.*(..))")
    public void doAfter(JoinPoint joinPoint){
        //封装访问时间

        if(executionClass != SysLogController.class){
            //通过反射获取访问Controller类上的RequestMapper注解
            RequestMapping requestMappingAnnoClass = (RequestMapping)executionClass.getAnnotation(RequestMapping.class);
            if(requestMappingAnnoClass != null){
                //获取方法上的RequestMapper注解
                RequestMapping requestMappingAnnoMethod = method.getAnnotation(RequestMapping.class);
                if(requestMappingAnnoMethod != null){
                    String url = "";
                    //进行url的拼接 类上的Controller和方法上的url
                    url = requestMappingAnnoClass.value()[0] + requestMappingAnnoMethod.value()[0];
                    sysLog.setUrl(url);
                    endTime = new Date();
                    sysLog.setExecutionTime(endTime.getTime() - startTime.getTime());
                    sysLog.setIp(request.getRemoteAddr());
                    //封装用户名，可以从SpirngSecurity中的SecurityContextHolder获取
                    SecurityContext context = SecurityContextHolder.getContext();
                    User principal = (User)context.getAuthentication().getPrincipal();
                    sysLog.setUsername(principal.getUsername());
                    sysLog.setMethod("[类名]" + executionClass.getName() + "[方法名]" + method.getName());
                    sysLog.setVisitTime(startTime);
                    sysLog.setId(UUID.randomUUID().toString().replaceAll("-",""));
                    sysLogService.save(sysLog);

                }
            }
        }

    }

}
