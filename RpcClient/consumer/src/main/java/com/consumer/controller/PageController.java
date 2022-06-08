package com.consumer.controller;

import com.User;
import com.consumer.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: liuyong
 * @Date: 2022 - 06 - 08 - 22:19
 * @Description: com.consumer.controller
 * @Version: 1.0
 */
@RestController
public class PageController {

    @Autowired
    private PageService pageService;

    @RequestMapping("/show")
    public List<User> show() {
        return pageService.show();
    }

}
