package com.ds.spring_rabbit_mq.config;

public class Records <T>{
    private T content;
    private String routingKey;

    public Records(T content, String routingKey) {
        this.content = content;
        this.routingKey = routingKey;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }
}
