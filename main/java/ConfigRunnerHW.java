import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

public class ConfigRunnerHW {

    public static void main(String[] args) throws IllegalAccessException {
        RandomIntExample example = new RandomIntExample();
        configure(example);
        System.out.println(example.toString());
    }


    public static ArrayList<Class> findSuperclass(ArrayList<Class> superclasses, Class classOfT) {

        Class superclass = classOfT.getSuperclass();
        if (superclass != null) {
            superclasses.add(superclass);
            findSuperclass(superclasses, superclass);
        }
        return superclasses;
    }



    public static void configure(RandomIntExample example) throws IllegalAccessException {
        Class ourClass = example.getClass();
        ArrayList<Class> superclasses = new ArrayList<>();
        findSuperclass(superclasses, ourClass);
        superclasses.add(ourClass);
        for (Class superclass : superclasses) {
            Field[] declaredFields = superclass.getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                Annotation[] annotations = field.getAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation.annotationType().equals(RandomInt.class)) {
                        Random random = new Random();
                        field.set(example, random.nextInt(100));
                    }
                }
            }
        }
    }
}