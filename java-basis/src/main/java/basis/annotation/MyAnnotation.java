package basis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// ElementType.TYPE: For class or interface
// ElementType.FIELD: For field
// ElementType.METHOD: For method
// ElementType.CONSTRUCTOR: For constructor
// ElementType.PARAMETER: For method parameter
@Target({
        ElementType.FIELD
})
// If null, default value: CLASS
// RetentionPolicy.SOURCE: Work in compile
// RetentionPolicy.CLASS: Work for class file
// RetentionPolicy.RUNTIME: Work in program running
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    int min() default 0;
    int max() default 255;
}
