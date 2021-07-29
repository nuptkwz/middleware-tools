package com.spring.springcharacteristic.aop.impl;

import com.spring.springcharacteristic.aop.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Description
 * Date 2020/5/20 22:34
 * Created by kwz
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public String login() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            log.info("login...");
        }
        return "success";
    }
}
