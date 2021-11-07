package com.pilnyck.reflection;

import com.pilnyck.datastructure.queue.ArrayQueue;
import com.pilnyck.datastructure.reflection.Activity;
import com.pilnyck.datastructure.reflection.Charge;
import com.pilnyck.datastructure.reflection.ReflectionTools;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ReflectionToolTest {

    //        Метод принимает класс и возвращает созданный объект этого класса
    @Test
    public void testCreatedObjectsByConstructor() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Object createdObject = ReflectionTools.createdObject(ArrayQueue.class);

        assertNotNull(createdObject);
        assertEquals(ArrayQueue.class, createdObject.getClass());
    }

    //        Метод принимает object и вызывает у него все методы без параметров
    @Test
    public void testCallMethodsWithZeroParameters() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Object createdObject = ReflectionTools.createdObject(ArrayQueue.class);

        Method[] methods = ReflectionTools.callMethodsWithZeroParameters(createdObject);
        int parametersCount = methods[0].getParameters().length;

        assertNotNull(methods);
        assertEquals(0, parametersCount);
    }

    //        Метод принимает object и выводит на экран все сигнатуры методов в который есть final
    @Test
    public void testShowSignatureOfFinalMethods() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Object createdObject = ReflectionTools.createdObject(Charge.class);
        String actual = ReflectionTools.getMethodsSignature(createdObject);
        String expected = "final";

        assertNotNull(actual);
        assertTrue(actual.contains(expected));
    }

    // Метод принимает Class и выводит все не публичные методы этого класса
    @Test
    public void testGetNotPublicMethods()  {
        Method[] methods = ReflectionTools.getNotPublicMethods(Charge.class);

        assertNotNull(methods);
        String actual = Modifier.toString(methods[0].getModifiers());
        assertEquals("private", actual);
        assertEquals(2,methods[0].getModifiers());
    }

    //        Метод принимает Class и выводит всех предков класса и все интерфейсы которое класс имплементирует
    @Test
    public void testGetParentsAndInterfaceOfClass(){
        ArrayList parentsAndInterfaceOfClass = ReflectionTools.getParentsAndInterfaceOfClass(ArrayList.class);
        //ArrayList expectedList = new ArrayList();
        String actual = ReflectionTools.print(parentsAndInterfaceOfClass);

        String expected = "Object";
        assertTrue(actual.contains(expected));
    }

    //        Метод принимает объект и меняет всего его приватные поля на их нулевые значение (null, 0, false etc)+
    @Test
    public void testChangePrivateFields() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Object createdObject = ReflectionTools.createdObject(Activity.class);

        Field someDeclaredPrivateIntField = createdObject.getClass().getDeclaredField("someOtherPrivateIntField");
        someDeclaredPrivateIntField.setAccessible(true);
        int notChangedVariable = someDeclaredPrivateIntField.getInt(createdObject);
        assertNotNull(notChangedVariable);

        ReflectionTools.changePrivateFields(createdObject);

        Field someChangedPrivateIntField = createdObject.getClass().getDeclaredField("someOtherPrivateIntField");
        someChangedPrivateIntField.setAccessible(true);
        int changedVariable = someChangedPrivateIntField.getInt(createdObject);

        assertEquals(15, notChangedVariable);
        assertEquals(0, changedVariable);
    }

    @Test
    public void testChangePrivateFieldsOrThrowExceptionIfFieldDoesNotExist() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Object createdObject = ReflectionTools.createdObject(Activity.class);

        assertThrows(NoSuchFieldException.class, () -> {
            createdObject.getClass().getField("someField").getInt(createdObject);
        });
    }
}
