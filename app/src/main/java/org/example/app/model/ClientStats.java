package org.example.app.model;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Klasse zur Repräsentation der Client-Statistik
 **/
public class ClientStats {
    private AtomicInteger numOfTasks;
    private AtomicLong sumOfExecutionTime;

    public ClientStats() {
        this.numOfTasks = new AtomicInteger(0);
        this.sumOfExecutionTime = new AtomicLong(0L);
    }

    public void incrementNumOfTasks() {
        this.numOfTasks.incrementAndGet();
    }

    public void addExecutionTime(long executionTime) {
        this.sumOfExecutionTime.addAndGet(executionTime);
    }

    public AtomicInteger getNumOfTasks() {
        return numOfTasks;
    }

    public AtomicLong getSumOfExecutionTime() {
        return sumOfExecutionTime;
    }

    @Override
    public String toString() {
        return "ClientStats{" +
                "numOfTasks=" + numOfTasks +
                ", sumOfExecutionTime=" + sumOfExecutionTime +
                '}';
    }
}