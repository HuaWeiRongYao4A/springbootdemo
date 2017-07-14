package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.redis.RedisCache;
import com.example.demo.service.HelloService;
import com.example.demo.service.Shape;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/6/21.
 */
@RestController
@RequestMapping("hello")
@Api(value = "HelloController", description = "hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private UserService userService;

    @Autowired
    private Shape shape;

    @Autowired
    private RedisCache redisCache;

    @ApiOperation(value = "sayHello", httpMethod = "POST", notes = "hello")
    @RequestMapping("sayHello")
    public int hello(String patentId, String patentType) {
        redisCache.put("root", "666");
        return helloService.update(patentId, patentType);
    }

    @RequestMapping(value = "indexPage", method = RequestMethod.GET, produces = MediaType.ALL_VALUE)
    public ModelAndView jspPage(ModelMap modelMap) {
        modelMap.addAttribute("info", "33re rwetreer");
        modelMap.addAttribute("info2", "新增信息");
        PageInfo<User> pageInfo = userService.list(1);
        return new ModelAndView("index", "pageInfo", pageInfo);
    }

    @RequestMapping(value = "shape")
    public String shape() {
        return shape.getType();
    }
}
