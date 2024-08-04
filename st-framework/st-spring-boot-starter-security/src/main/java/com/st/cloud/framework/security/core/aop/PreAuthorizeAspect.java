package com.st.cloud.framework.security.core.aop;

import com.st.cloud.common.exception.auth.NotLoginException;
import com.st.cloud.common.exception.auth.NotPermissionException;
import com.st.cloud.common.pojo.R;
import com.st.cloud.framework.security.core.util.AuthUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * 基于 Spring Aop 的注解鉴权
 * 
 * @author Tim
 */
@Aspect
@Slf4j
public class PreAuthorizeAspect {

    private final AuthUtil authUtil;
    /**
     * 构建
     */
    public PreAuthorizeAspect(AuthUtil authUtil) {
        this.authUtil = authUtil;
    }

    /**
     * 定义AOP签名 (切入所有使用鉴权注解的方法)
     */
    public static final String POINTCUT_SIGN = " @annotation(com.st.cloud.framework.security.core.aop.RequiresLogin) || "
            + "@annotation(com.st.cloud.framework.security.core.aop.RequiresPermissions)";

    /**
     * 声明AOP签名
     */
    @Pointcut(POINTCUT_SIGN)
    public void pointcut(){}

    /**
     * 环绕切入
     * 
     * @param joinPoint 切面对象
     * @return 底层方法执行后的返回值
     * @throws Throwable 底层方法抛出的异常
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 注解鉴权
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        try {
            checkMethodAnnotation(signature.getMethod());
            // 执行原有逻辑
            return joinPoint.proceed();
        } catch (NotLoginException e) {
            log.error("鉴权失败-用户未登录", e);
            return R.fail("99999", "用户未登录");
        } catch (NotPermissionException e) {
            log.error("鉴权失败-没有权限 {}", e.getMessage(), e);
            return R.fail("99999", "没有权限");
        } catch (Exception e) {
            log.error("鉴权失败-系统异常", e);
            return R.fail("99999", "系统异常");
        }
    }

    /**
     * 对一个Method对象进行注解检查
     */
    public void checkMethodAnnotation(Method method) {

        // 校验 @RequiresLogin 注解
        RequiresLogin requiresLogin = method.getAnnotation(RequiresLogin.class);
        if (requiresLogin != null) {
            authUtil.checkLogin();
        }

        // 校验 @RequiresPermissions 注解
        RequiresPermissions requiresPermissions = method.getAnnotation(RequiresPermissions.class);
        if (requiresPermissions != null) {
            authUtil.checkPermi(requiresPermissions);
        }
    }
}
