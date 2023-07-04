package org.example.exceptions;

public class Resource implements AutoCloseable {
    @Override
    public void close()  {
        //...
        System.out.println("Resource has been closed. -> " + this.toString());
    }
}
