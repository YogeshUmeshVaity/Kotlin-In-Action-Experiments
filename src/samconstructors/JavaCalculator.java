package samconstructors;

public class JavaCalculator {
    public void setAdder(JavaAdder adder) {
        this.adder = adder;
    }

    public JavaAdder adder;

    public int add(int number1, int number2) {
        return adder.add(number1, number2);
    }
}