package io.github.kozlovva.utils.spring.autoregisterer;


import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import({CleanArcAutoRegisterer.class, EventsAutoRegisterer.class})
public @interface EnableCleanArcAutoRegisterer {

    String[] value() default {};

    String[] basePackages() default {};

    Class<?>[] basePackageClasses() default {};

    Class<?>[] anotherDomainBeans() default {};
}
