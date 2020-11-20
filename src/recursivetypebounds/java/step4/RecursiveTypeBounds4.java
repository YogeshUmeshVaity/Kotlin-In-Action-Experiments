package recursivetypebounds.java.step4;

// Introducing recursive type bound
/*

Solution: So, we tell the compiler that our T is a subtype of Fruit. In other words, we specify
the upper bound T extends Fruit<T>. This makes sure that only subtypes of Fruit are allowed as type arguments.
Now the compiler knows that the getSize() method can be found in
the subtype of Fruit class because the Comparable<T> also receives our type(Fruit<T>) that contains the getSize() method.

This allows us to get rid of the repeated code of compareTo() method and also allows us to compare the fruits
of the same types, apples with apples and oranges with oranges.

This is called recursive type bound because we pass the bound of the same type(Fruit<T>) as a type argument for the
type parameter of that type(Fruit<T>). The concept of recursion is similar to the recursive functions when call
the same function from that very function.

A recursive type is one that includes a function that uses that type itself as a type for some argument or its
return value. In our example, compareTo(T other) is the function of the recursive type that takes the same
recursive type as an argument.

 */
class Fruit<T extends Fruit<T>> implements Comparable<T> {
    private final Integer size;

    public Fruit(Integer size) {
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }

    @Override public int compareTo(T other) {
        return size.compareTo(other.getSize());     // No more error.
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

//      apple1.compareTo(orange1);  // Error: different types
    }
}
