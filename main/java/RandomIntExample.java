public class RandomIntExample extends ExtendedClass {

    @RandomInt(min = 14, max = 177)
    private int value = -1;

    @RandomInt(min = 5)
    private int valueWithoutMax = -2;


    private int valueWithoutAnnotation = -7;

    @AnotherAnnotation(parameter2 = 11)
    private int valueWithAnotherAnnotation = -8;

    public RandomIntExample() {}

    @Override
    public String toString() {
        return "RandomIntExample {" + "value= " + value + ", valueWithoutMax = " +
                valueWithoutMax + ", valueWithoutAnnotation = "
                + valueWithoutAnnotation + ", valueWithAnotherAnnotation =  "
                + valueWithAnotherAnnotation +
                ", anotherValueWithoutAnnotation = " + anotherValueWithoutAnnotation +
                ", anotherValueWithAnnotation = " + anotherValueWithAnnotation + "}";
    }
}
