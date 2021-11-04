package com.pilnyck.junit;

import com.pilnyck.datastructure.list.ArrayListTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class JUnit {
    public static void main(String[] args) throws Exception{
        runTests(ArrayListTest.class);
    }

    static void runTests(Class clazz) throws Exception {
        Constructor constructor = clazz.getConstructor();

        Object testInstance = constructor.newInstance();

        ArrayList testMethods = getTests(clazz);

        for (int i = 0; i < testMethods.size(); i++) {
            Method testMethod = (Method) testMethods.get(i);
            try{
                testMethod.invoke(testInstance);
                System.out.println("Test: " + testMethod.getName() + " success!");
            }catch (Throwable error){
                System.err.println("Test: " + testMethod.getName() + " failed!");
                error.printStackTrace();
            }
        }
    }

    private static ArrayList getTests(Class clazz) {
        ArrayList methodsList = new ArrayList();
        for (Method method : clazz.getMethods()) {
            if (method.isAnnotationPresent(Test.class)){
                methodsList.add(method);
            }
        }
        return methodsList;
    }
}
