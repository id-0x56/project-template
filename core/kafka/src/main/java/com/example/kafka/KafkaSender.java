package com.example.kafka;

public interface KafkaSender {
    /**
     * Send message to default topic with key generation
     * @param value - record message
     */
    <T> void sendDefault(T value);

    /**
     * Send message to default topic
     * @param key - record key
     * @param value - record message
     */
    <T> void sendDefault(String key, T value);

    /**
     * Send message to topic with key generation
     * @param topicName - topic name
     * @param value - record message
     */
    <T> void send(String topicName, T value);

    /**
     * Send message to topic
     * @param topicName - topic name
     * @param key - record key
     * @param value - record message
     */
    <T> void send(String topicName, String key, T value);
}
