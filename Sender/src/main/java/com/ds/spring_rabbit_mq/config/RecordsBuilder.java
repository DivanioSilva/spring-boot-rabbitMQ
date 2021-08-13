package com.ds.spring_rabbit_mq.config;

public class RecordsBuilder<T> {
    private T content;
    private String routingKey;

    public RecordsBuilder setContent(T content) {
        this.content = content;
        return this;
    }

    public RecordsBuilder setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
        return this;
    }

    public Records createRecords() {
        return new Records(content, routingKey);
    }
}