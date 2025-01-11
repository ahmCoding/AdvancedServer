package org.example.cacheModule;

import org.example.command.Command;

/**
 * Representiert ein Element im Cache.
 */
public class CacheItem<C> {
    private C command;
    private String result;
    private long createdAt;
    private long lastAccessedAt;

    public CacheItem(C command, String result) {
        this.command = command;
        this.result = result;
        this.createdAt = System.currentTimeMillis();
        this.lastAccessedAt = System.currentTimeMillis();
    }

    public C getCommand() {
        return command;
    }

    public String getResult() {
        return result;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getLastAccessedAt() {
        return lastAccessedAt;
    }

    public void setCommand(C command) {
        this.command = command;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public void setLastAccessedAt(long lastAccessedAt) {
        this.lastAccessedAt = lastAccessedAt;
    }
}
