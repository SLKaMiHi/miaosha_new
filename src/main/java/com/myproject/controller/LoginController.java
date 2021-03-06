package com.myproject.controller;

import com.myproject.domain.User;
import com.myproject.redis.RedisService;
import com.myproject.redis.UserKey;
import com.myproject.result.CodeMsg;
import com.myproject.result.Result;
import com.myproject.service.MiaoshaUserService;
import com.myproject.service.UserService;
import com.myproject.util.ValidatorUtil;
import com.myproject.vo.LoginVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private MiaoshaUserService userService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }


    @RequestMapping("/do_login")
    @ResponseBody
    public Result<String>  doLogin(HttpServletResponse response, @Valid LoginVo loginVo) {
        log.info(loginVo.toString());
        // 登录
        String token = userService.login(response, loginVo);

        return Result.success(token);

    }


}