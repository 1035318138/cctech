package net.cctech.user_service.aop;

import net.cctech.user_service.annotation.Audit;
import net.cctech.user_service.dao.OperateLogRepository;
import net.cctech.user_service.domain.OperateLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * @author Can.Ru
 */
@Component
@Aspect
public class AuditAop {

    @Autowired
    private OperateLogRepository operateLogRepository;

    @Pointcut("@annotation(net.cctech.user_service.annotation.Audit)")
    public void auditPoint() {}

    @Around("auditPoint()")
    public Object AuditControl(ProceedingJoinPoint joinPoint) {
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method method = ms.getMethod();
        // 获取方法注解的参数信息
        Audit auditAnno = AnnotationUtils.getAnnotation(method, Audit.class);

        //执行方法
        Object result = null;
        //接口执行开始时间
        LocalDateTime startTime = null;
        //接口执行开始时间
        LocalDateTime endTime = null;
        try {
            startTime = LocalDateTime.now();
            result = joinPoint.proceed();
            endTime = LocalDateTime.now();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        //记录方法执行后日志
        String resultStr = result == null ? "null" : result.toString();

        //操作日志记录
        OperateLog log = OperateLog.builder()
                .eventType(auditAnno.eventType())
                .object(auditAnno.object())
                .result(resultStr)
                .startTime(startTime)
                .endTime(endTime)
                .build();
        operateLogRepository.save(log);

        return resultStr;
    }
}
