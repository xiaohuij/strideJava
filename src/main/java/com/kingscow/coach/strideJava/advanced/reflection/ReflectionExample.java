package com.kingscow.coach.strideJava.advanced.reflection;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReflectionExample {
    public static void main(String[] args) throws ClassNotFoundException {
        // Get Class using reflection
        Class<?> concreteClass = ConcreteClass.class;
        concreteClass = new ConcreteClass(5).getClass();
        try {
            concreteClass = Class.forName("com.kingscow.coach.strideJava.advanced.reflection.ConcreteClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(concreteClass.getCanonicalName());

        //for primitive types, wrapper classes and arrays
        Class<?> booleanClass = boolean.class;
        System.out.println(booleanClass.getCanonicalName());

        Class<?> cDouble = Double.TYPE;
        System.out.println(cDouble.getCanonicalName());

        Class<?> cDoubleArray = Class.forName("[D");
        System.out.println(cDoubleArray.getCanonicalName()); //prints double[]

        Class<?> twoDStringArray = String[][].class;
        System.out.println(twoDStringArray.getCanonicalName());

        //superclass
        Class<?> superClass = Class.forName("com.kingscow.coach.strideJava.advanced.reflection.ConcreteClass").getSuperclass();
        System.out.println(superClass);
        System.out.println(Object.class.getSuperclass());
        System.out.println(String[][].class.getSuperclass());


        //public classes only
        Class<?>[] classes = concreteClass.getClasses();
        System.out.println(Arrays.toString(classes));

        //getting all of the classes, interfaces, and enums that are explicitly declared in ConcreteClass
        Class<?>[] explicitClasses = Class.forName("com.kingscow.coach.strideJava.advanced.reflection.ConcreteClass").getDeclaredClasses();
        System.out.println(Arrays.toString(explicitClasses));

        //declaring class
        Class<?> innerClass = Class.forName("com.kingscow.coach.strideJava.advanced.reflection.ConcreteClass$ConcreteClassDefaultClass");
        System.out.println(innerClass.getDeclaringClass().getCanonicalName());
        System.out.println(innerClass.getEnclosingClass().getCanonicalName());

        //package name
        System.out.println(Class.forName("com.kingscow.coach.strideJava.advanced.reflection.BaseInterface").getPackage().getName());

        //modifier
        System.out.println(Modifier.toString(concreteClass.getModifiers()));
        System.out.println(Modifier.toString(Class.forName("com.kingscow.coach.strideJava.advanced.reflection.BaseInterface").getModifiers()));

        //Get Type parameters (generics)
        TypeVariable<?>[] typeParameters = Class.forName("java.util.HashMap").getTypeParameters();
        for(TypeVariable<?> t : typeParameters)
            System.out.print(t.getName()+",");
        System.out.println();

        //Get implemented interface
        Type[] interfaces = Class.forName("java.util.HashMap").getGenericInterfaces();
        System.out.println(Arrays.toString(interfaces));
        System.out.println(Arrays.toString(Class.forName("java.util.HashMap").getInterfaces()));

        //Get public methods
        Method[] publicMethods = Class.forName("com.kingscow.coach.strideJava.advanced.reflection.ConcreteClass").getMethods();
        System.out.println(Arrays.toString(publicMethods));

        //Get All public constructors
        Constructor<?>[] publicConstructors = Class.forName("com.kingscow.coach.strideJava.advanced.reflection.ConcreteClass").getConstructors();
        System.out.println(Arrays.toString(publicConstructors));

        //Get All public fields
        Field[] publicFields = Class.forName("com.kingscow.coach.strideJava.advanced.reflection.ConcreteClass").getFields();
        System.out.println(Arrays.toString(publicFields));

        java.lang.annotation.Annotation[] annotations = Class.forName("com.kingscow.coach.strideJava.advanced.reflection.ConcreteClass").getAnnotations();
        System.out.println(Arrays.toString(annotations));



        //Fields
        try {
            Field field = Class.forName("com.kingscow.coach.strideJava.advanced.reflection.ConcreteClass").getField("interfaceInt");

            Class<?> fieldClass = field.getDeclaringClass();
            System.out.println(fieldClass.getCanonicalName());

            Class<?> fieldType = field.getType();
            System.out.println(fieldType.getCanonicalName());

        } catch (NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }

        try {
            Field field = Class.forName("com.kingscow.coach.strideJava.advanced.reflection.ConcreteClass").getField("publicInt");

            ConcreteClass obj = new ConcreteClass(5);
            System.out.println(field.get(obj));
            field.setInt(obj, 10);
            System.out.println(field.get(obj));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Field privateField = Class.forName("com.kingscow.coach.strideJava.advanced.reflection.ConcreteClass").getDeclaredField("privateString");
            privateField.setAccessible(true);
            ConcreteClass objTest = new ConcreteClass(1);
            System.out.println(privateField.get(objTest));
            privateField.set(objTest, "private string updated");
            System.out.println(privateField.get(objTest));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }


        //Methods
        try {
            Method method = Class.forName("java.util.HashMap").getMethod("put", Object.class, Object.class);
            System.out.println(Arrays.toString(method.getParameterTypes()));
            System.out.println(method.getReturnType());
            System.out.println(Modifier.toString(method.getModifiers()));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            Method method = Class.forName("java.util.HashMap").getMethod("put", Object.class, Object.class);
            Map<String, String> hm = new HashMap<>();
            method.invoke(hm, "key", "value");
            System.out.println(hm);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        //invoking private method
        try {
            Method method = Class.forName("com.kingscow.coach.strideJava.advanced.reflection.BaseClass").getDeclaredMethod("method3", null);
            method.setAccessible(true);
            method.invoke(null, null);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }



        //Constructors
        try {
            Constructor<?> constructor = Class.forName("com.kingscow.coach.strideJava.advanced.reflection.ConcreteClass").getConstructor(int.class);
            System.out.println(Arrays.toString(constructor.getParameterTypes()));

            Object myObj = constructor.newInstance(10);
            Method myObjMethod = myObj.getClass().getMethod("method1", null);
            myObjMethod.invoke(myObj, null);

            Constructor<?> hashMapConstructor = Class.forName("java.util.HashMap").getConstructor(null);
            System.out.println(Arrays.toString(hashMapConstructor.getParameterTypes()));
            HashMap<String,String> myMap = (HashMap<String,String>) hashMapConstructor.newInstance(null);
            myMap.put("good", "world");
            System.out.println(myMap);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
