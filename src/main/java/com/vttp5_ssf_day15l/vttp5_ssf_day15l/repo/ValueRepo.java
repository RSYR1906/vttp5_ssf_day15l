package com.vttp5_ssf_day15l.vttp5_ssf_day15l.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.vttp5_ssf_day15l.vttp5_ssf_day15l.utility.Util;

@Repository
public class ValueRepo {

    // slide 20
    @Autowired
    @Qualifier(Util.template01)
    RedisTemplate<String, String> template;

    // slide 24 - create/update a value
    public void createValue(String key, String value) {
        template.opsForValue().set(key, value); // set() --> overwrite and allow duplicates

        // setIfPresent() --> (Only when key is present then set. This is update function)
        // setIfAbsent() --> (Only if key is not present, then set. This is create function)
    }

    // slide 25 - retrieve a value
    public String getValue(String key) {
        return template.opsForValue().get(key);
    }

    // slide 27 - delete
    public Boolean deleteBalue(String key) {
        return template.delete(key);
    }

    // slide 26 - only works for key with integer value
    public void incrementValue(String key) {
        template.opsForValue().increment(key);
    }

    public void incrementByValue(String key, Integer value) {
        template.opsForValue().increment(key, value);
    }

    public void decrementValue(String key) {
        template.opsForValue().decrement(key);
    }

    public void decrementByValue(String key, Integer value) {
        template.opsForValue().decrement(key, value);
    }

    // slide 28
    public Boolean checkExists(String key) {
        return template.hasKey(key);
    }

}
