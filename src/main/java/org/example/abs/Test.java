package org.example.abs;

public interface Test {

    public static final int A  = 10;
    int B = 20;

    void testMe();
    public abstract void testMe2();

}

interface  A {
    void a();
}

interface B{
    void b();
}

class C {
    void b() {
    }

}

class TestClient extends  C implements Test, A, B {

    public void testMe() {

    }

    public void testMe2() {

    }

    public void a() {

    }

    public void b() {

    }
}
