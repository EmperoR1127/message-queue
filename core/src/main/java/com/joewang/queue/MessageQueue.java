package com.joewang.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MessageQueue<E> {
  private final BlockingQueue<E> messageQueue;
  private static final int CAPACITY = 100;

  private MessageQueue(BlockingQueue<E> queue) {
    this.messageQueue = queue;
  }

  public void put(E task) throws InterruptedException {
    this.messageQueue.put(task);
  }

  public E get() throws InterruptedException {
    return this.messageQueue.take();
  }

  public static class Builder<E> {
    private BlockingQueue<E> messageQueue;

    public Builder<E> newBuilder() {
      this.messageQueue = new ArrayBlockingQueue<>(CAPACITY);
      return this;
    }

    public MessageQueue<E> build() {
      return new MessageQueue<>(this.messageQueue);
    }

    public Builder<E> setCapacity(int capacity) {
      if (capacity > CAPACITY) {
        this.messageQueue = new ArrayBlockingQueue<>(capacity);
      }

      return this;
    }
  }
}
