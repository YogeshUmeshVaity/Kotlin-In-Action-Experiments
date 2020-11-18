package recursivetypebounds.java.step2;
// Moving the repeated code to a common class.

/**
 Problem: Able to compare different types.

 Here, we move the repeated code to a common class. The repeated code problem solves but we have another
 problem. We are not able to achieve our objective of restricting the comparison of different types. Here
 we are able to compare apples with oranges which is not what we want.
 */


class Fruit implements Comparable<Fruit> {
    private final Integer size;

    public Fruit(Integer size) {
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }

    @Override
    public int compareTo(Fruit other) {
        return size.compareTo(other.getSize());
    }
}

class Apple extends Fruit {
    public Apple(Integer size) {
        super(size);
    }
}

class Orange extends Fruit {
    public Orange(Integer size) {
        super(size);
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

        apple1.compareTo(orange1);  // No Error: we are able to compare different types.
    }
}
