package com.joewang;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MessageQueueTest {
    @Test
    void testPutSuccessful() throws InterruptedException {
        MessageQueue<String> queue = new MessageQueue.Builder<String>().newBuilder().build();
        queue.put("a string");
        assertEquals("a string", queue.get());
    }
}