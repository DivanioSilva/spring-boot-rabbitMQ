package com.ds.spring_rabbit_mq.config;

public enum RabbitMQQueues {
    SAVE_FILE("saveFile"),
    DELETE_FILE("deleteFile"),
    SEND_EMAIL("sendEmail"),
    SEND_SMS("sendSMS"),
    EMPLOYEE("employee");

    private String value;

    RabbitMQQueues(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
