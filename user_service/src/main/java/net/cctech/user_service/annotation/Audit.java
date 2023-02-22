package net.cctech.user_service.annotation;



import java.lang.annotation.*;

/**
 * @author Can.Ru
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = { ElementType.METHOD })
@Inherited
public @interface Audit {

    String eventType() default "";

    String object() default "";


}
