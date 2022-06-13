package com.myproject.redis;

public interface KeyPrefix {

    public int expireSeconds();

    public String getPrefix();
}
