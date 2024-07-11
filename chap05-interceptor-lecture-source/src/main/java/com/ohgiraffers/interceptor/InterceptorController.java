package com.ohgiraffers.interceptor;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class InterceptorController {

    @GetMapping("stopwatch")
    public String handlerMethod() throws InterruptedException {
        System.out.println("핸들러 메소드 호출함");

        // 1초 동안 멈춰있다가 다음 코드 실행
        Thread.sleep(1000);

         return "result";
    }
}
