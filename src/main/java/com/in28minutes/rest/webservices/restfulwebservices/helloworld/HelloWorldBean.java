package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {

    private String message;

    HelloWorldBean(String messages){
        this.message =messages;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }


}
