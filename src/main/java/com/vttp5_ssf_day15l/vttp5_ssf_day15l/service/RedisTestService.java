package com.vttp5_ssf_day15l.vttp5_ssf_day15l.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vttp5_ssf_day15l.vttp5_ssf_day15l.repo.ListRepo;
import com.vttp5_ssf_day15l.vttp5_ssf_day15l.repo.ValueRepo;

@Service
public class RedisTestService {
    
    @Autowired
    ListRepo lRepo;

    @Autowired
    ValueRepo vRepo;

    // write service functions 
}
