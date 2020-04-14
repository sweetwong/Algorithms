package java.reflect;

import java.reflect.bean.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Reflect {

    public static void main(String[] args) {
        try {
            Student person = new Student("Sweet", 18, 180);

            // Class, 1. 这种方法不需要获得Student的类的
            Class<Student> clazz = (Class<Student>) Class.forName("java.reflect.bean.Student");

            // Class, 2. 这种方法需要Student的类
            Class<Student> class2 = Student.class;

            // Class, 3. 这种方法需要Student的实例
            Class<Student> class3 = (Class<Student>) person.getClass();

            System.out.println(clazz.getName() + "\n" + class2.getName() + "\n" + class3.getName());
            System.out.println();

            // Field, 获取所有的字段, 包括私有
            Field[] allFields = clazz.getDeclaredFields();
            for (Field field : allFields) {
                System.out.println("getDeclaredFields: " + field.getName() + " = " + field.toString());
            }
            System.out.println();
            try {
                // Field, 获取指定的字段
                Field ageField = clazz.getDeclaredField("grade");
                System.out.println("getDeclaredField: " + ageField.toString());
                System.out.println();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

            // Method, 获取所有方法, 包括私有, 不包含其父类
            Method[] allMethods = clazz.getDeclaredMethods();
            for (Method method : allMethods) {
                System.out.println("getDeclaredMethods: " + method.toString());
            }
            System.out.println();
            // Method, 获取所有非私有方法, 包括其父类
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                System.out.println("getMethods: " + method.toString());
            }
            System.out.println();
            try {
                // Method, 获取单独的方法
                Method method = clazz.getDeclaredMethod("setGrade", int.class);
                System.out.println("getDeclaredMethod: " + method);
                System.out.println();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

            // Constructor, 获取所有的构造函数
            Constructor<?>[] allConstructors = clazz.getDeclaredConstructors();
            for (Constructor<?> constructor : allConstructors) {
                System.out.println(constructor.toString());
            }
            System.out.println();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}
