package org.example.casting;

public abstract class Role {

    abstract void read();
    abstract void update();
    abstract void create();
    abstract void delete();

}

class GeneralUser extends Role {

    @Override
    void read() {
        System.out.println("GeneralUser -> read()");
    }

    @Override
    void update() {
        // no impl
    }

    @Override
    void create() {
        // no impl
    }

    @Override
    void delete() {
       // no impl
    }

    void createOrder(){
        System.out.println("GeneralUser -> read()");
    }
}

class Manager extends Role {

    @Override
    void read() {
        System.out.println("Manager -> read()");
    }

    @Override
    void update() {
        System.out.println("Manager -> update()");
    }

    @Override
    void create() {
        System.out.println("Manager -> create()");
    }

    @Override
    void delete() {
        // no impl
    }

    void addUsers(){
        System.out.println("Manager -> addUsers()");
    }
}

class Admin extends Role {

    @Override
    void read() {
        System.out.println("Admin -> read()");
    }

    @Override
    void update() {
        System.out.println("Admin -> update()");
    }

    @Override
    void create() {
        System.out.println("Admin -> create()");
    }

    @Override
    void delete() {
        System.out.println("Admin -> delete()");
    }

    void readLogs(){
        System.out.println("Admin -> readLogs()");
    }
}

class SuperAdmin extends Admin {
    void canDoAllStuff(){
        System.out.println("canDoAllStuff");
    }
}

