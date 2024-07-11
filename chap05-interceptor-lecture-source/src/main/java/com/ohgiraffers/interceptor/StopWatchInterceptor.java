package com.ohgiraffers.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component

/*
* default method 이전에는 모두 오버라이딩 해야하는 책임을 가지기 때문에
* HandlerInterceptorAdaptor 를 이용해 부담을 줄여 사용했었다.
* default method 가 인터페이스에서 사용 가능하게 된 1.8 이후 부터는
* 인터페이스만 구현하여 필요한 메소드만 오버라이딩해서 사용할 수 있다.
*
* 실질적으로 사용하려면 configuration 에서 설정이 필요하다.
* */
public class StopWatchInterceptor implements HandlerInterceptor {

    private final MenuService menuService;

    public StopWatchInterceptor(MenuService menuService){
        this.menuService = menuService;
    }

    // 전처리 메소드
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandler 호출함...");
        long startTime = System.currentTimeMillis();

        request.setAttribute("startTime", startTime);


        // true이면 컨트롤러를 이어서 호출한다. false면 컨트롤러를 호출하지 않는다.
        return true;
    }

    // 후처리 메소드
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandler 호출함...");

        long startTime = (long) request.getAttribute("startTime");
        request.removeAttribute("startTime");

        long endTime = System.currentTimeMillis();
        modelAndView.addObject("interval", endTime - startTime);

    }

    // 마지막에 호출하는 메소드
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion 호출함...");

        menuService.method();
    }
}
