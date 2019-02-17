package com.jzs.bedcard.controller;

import com.jzs.bedcard.entity.BaseRedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 所有控制器的父类
 */
public abstract class BaseController {

    protected final Logger log = LoggerFactory.getLogger(getClass());
}