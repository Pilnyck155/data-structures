package com.pilnyck.datastructure.reflection;

import java.lang.reflect.*;
import java.util.ArrayList;

public class ReflectionTools {
    private static java.lang.Object Object;
    private static java.lang.Object String;

    //        Метод принимает класс и возвращает созданный объект этого класса
    public static Object createdObject(Class clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor constructor = clazz.getConstructor();
        Object obj = constructor.newInstance();
        return obj;
    }

//        Метод принимает object и вызывает у него все методы без параметров
    public static Method[] callMethodsWithZeroParameters(Object obj) throws InvocationTargetException, IllegalAccessException {
        Class aClass = obj.getClass();
        Method[] methodsWithZeroParameter = aClass.getMethods();
        Method[] newMethodsArray = new Method[methodsWithZeroParameter.length];
        int methodsCounter = 0;
        for (int i = 0; i < methodsWithZeroParameter.length; i++) {
            if (methodsWithZeroParameter[i].getParameters().length == 0) {
                try{
                    methodsWithZeroParameter[i].invoke(obj);
                }catch (Exception exception){
                    System.err.println("Method: " + methodsWithZeroParameter[i].getName() + " failed!");
                }
                newMethodsArray[methodsCounter] = methodsWithZeroParameter[i];
                methodsCounter++;
            }
        }
        return newMethodsArray;
    }

//        Метод принимает object и выводит на экран все сигнатуры методов в который есть final
    public static String getMethodsSignature(Object obj){
        Class aClass = obj.getClass();
        StringBuilder stringBuilder = new StringBuilder();
        Method[] methodsWithZeroParameter = aClass.getDeclaredMethods();

        for (int i = 0; i < methodsWithZeroParameter.length; i++) {
            if (Modifier.isFinal(methodsWithZeroParameter[i].getModifiers())) {
                try{
                    System.out.println("method: " + methodsWithZeroParameter[i].getName() + ", signature: " + methodsWithZeroParameter[i].toString());
                    stringBuilder.append(methodsWithZeroParameter[i].toString());
                }catch (Exception exception){
                    System.err.println("Method: " + methodsWithZeroParameter[i].getName() + " failed!");
                }
            }
        }
        return stringBuilder.toString();
    }

//        Метод принимает Class и выводит все не публичные методы этого класса
    public static Method[] getNotPublicMethods(Class clazz){

        Method[] upPublicMethods = clazz.getDeclaredMethods();
        Method[] newMethodsArray = new Method[upPublicMethods.length];
        int methodsCounter = 0;
        for (int i = 0; i < upPublicMethods.length; i++) {
            if (Modifier.isPrivate(upPublicMethods[i].getModifiers())) {
                try{
                    System.out.println("method: " + upPublicMethods[i].getName());
                }catch (Exception exception){
                    System.err.println("Method: " + upPublicMethods[i].getName() + " failed!");
                }
                newMethodsArray[methodsCounter] = upPublicMethods[i];
                methodsCounter++;
            }
        }
        return newMethodsArray;
    }

//        Метод принимает Class и выводит всех предков класса и все интерфейсы которое класс имплементирует

    public static ArrayList getParentsAndInterfaceOfClass(Class clazz){
        ArrayList superClassList = new ArrayList();
        while (clazz.getSuperclass() != null){
            Class newParentsClazz = clazz.getSuperclass();
            Class[] newParentsInterface = clazz.getInterfaces();
            for (Class aClass : newParentsInterface) {
                superClassList.add(aClass);
            }
            superClassList.add(newParentsClazz);
            clazz = newParentsClazz;
        }
        return superClassList;
    }

    public static String print(ArrayList list){
        for (Object o : list) {
            System.out.println(o);
        }
        return list.toString();
    }

//        Метод принимает объект и меняет всего его приватные поля на их нулевые значение (null, 0, false etc)+
    public static void changePrivateFields(Object obj) throws IllegalAccessException {
        Class aClass = obj.getClass();

        for (Field privateField : aClass.getDeclaredFields()) {
            if (Modifier.isPrivate(privateField.getModifiers())){
                privateField.setAccessible(true);
                System.out.println("private fields= " + privateField + ", generic type= " + privateField.getGenericType());
                if (privateField.getGenericType().toString().equals("int")){
                    privateField.set(obj, 0);
                }else if (privateField.getType().getName().equals("double")){
                    privateField.set(obj, 0);
                }else if (privateField.getType().getName().equals("byte")){
                    privateField.set(obj, (byte)0);
                }else if (privateField.getType().getName().equals("boolean")){
                    privateField.set(obj, false);
                }else if (privateField.getType().getName().equals(String)){
                    privateField.set(obj, null);
                }else if (privateField.getType().getName().equals(Object)){
                    privateField.set(obj, null);
                }
            }
        }
    }
}
