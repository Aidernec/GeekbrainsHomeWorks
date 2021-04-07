package homework;

import homework.annotation.AfterSuite;
import homework.annotation.BeforeSuite;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Tester {
    public static void start(Class<?> testClass){
        Method[] declareMethod = testClass.getDeclaredMethods();
        Method beforeMethod = getSuitMethod(BeforeSuite.class, declareMethod);
        Method afterMethod = getSuitMethod(AfterSuite.class, declareMethod);

        runTests(declareMethod, beforeMethod, afterMethod);
    }

    private static Method getSuitMethod(Class<? extends Annotation> suitAnnotationClass, Method[] declareMethods){
        Method suitMethod = null;

        for(Method declareMethod : declareMethods){
            if(declareMethod.isAnnotationPresent(suitAnnotationClass)){
                if(suitMethod != null){
                    throw new RuntimeException(suitAnnotationClass.getName() + " more than one");
                } else {
                    suitMethod = declareMethod;
                }
            }
        }
        return suitMethod;
    }

    private static void runTests(Method[] declareMethods, Method beforeMethod, Method afterMethod){
        invokeMethod(beforeMethod);
        callTestMethods(declareMethods);
        invokeMethod(afterMethod);
    }

    private static void callTestMethods(Method[] declareMethods){
        Arrays.stream(declareMethods)
                .filter(method -> method.isAnnotationPresent(Tester.class))
                .sorted(Comparator.comparingInt(method -> method.getAnnotation(Tester.class).priority()))
                .forEach(method1 -> invokeMethod(method1));
    }

    private static void invokeMethod(Method method){
        try{
            method.invoke(null);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
