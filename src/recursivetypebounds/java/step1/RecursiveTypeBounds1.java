package recursivetypebounds.java.step1;

/**
 Problem: Repeated code

 Our use case is to be able to compare only the same types. We don't want to compare apples with oranges.
 The code in this sample works. We are able to compare apples with other apples. When we try to compare
 an apple with an orange we get an error as expected.

 But there is a problem: the code for implementing the compareTo method is duplicated in all the classes
 that we extend from the Fruit. The amount of repeated code in our example is less but in real world use
 cases the repeated code can be of thousands of lines.
 */


interface Fruit {
    Integer getSize();
}

class Apple implements Fruit, Comparable<Apple> {
    private final Integer size;

    public Apple(Integer size) {
        this.size = size;
    }

    @Override public Integer getSize() {
        return size;
    }

    @Override public int compareTo(Apple other) {
        return size.compareTo(other.size);
    }
}

class Orange implements Fruit, Comparable<Orange> {
    private final Integer size;

    public Orange(Integer size) {
        this.size = size;
    }

    @Override
    public Integer getSize() {
        return size;
    }

    @Override
    public int compareTo(Orange other) {
        return size.compareTo(other.size);
    }
}

class Main {
    public static void main(String[] args) {
        Apple apple1 = new Apple(3);
        Apple apple2 = new Apple(4);
        apple1.compareTo(apple2);

        Orange orange1 = new Orange(3);
        Orange orange2 = new Orange(4);
        orange1.compareTo(orange2);

//      apple1.compareTo(orange1);  // Error: different types
    }
}
