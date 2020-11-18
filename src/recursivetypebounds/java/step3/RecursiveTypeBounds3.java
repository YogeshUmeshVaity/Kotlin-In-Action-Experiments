package recursivetypebounds.java.step3;
// Introducing type parameter
/*
To restrict comparison of different types, we introduce a type parameter. So that the comparable Fruit<Apple>
cannot be compared to comparable Fruit<Orange>.

Problem: The getSize() method of T is unknown to the compiler. This is because the type parameter T of our
Fruit class doesn't have any bound. So, the T could be any class, it is not possible that every class would
have a getSize() method. So the compiler is right in not recognizing the getSize() method of T.
 */

class Fruit<T> implements Comparable<T> {
    private final Integer size;

    public Fruit(Integer size) {
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }

    @Override public int compareTo(T other) {
//      return size.compareTo(other.getSize());     // Error: getSize() method is not available.
        return 0;   // we return 0 here so, our project stays without errors.
    }
}

class Apple extends Fruit<Apple> {
    public Apple(Integer size) {
        super(size);
    }
}

class Orange extends Fruit<Orange> {
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

//      apple1.compareTo(orange1);  // Error: different types.
    }
}
