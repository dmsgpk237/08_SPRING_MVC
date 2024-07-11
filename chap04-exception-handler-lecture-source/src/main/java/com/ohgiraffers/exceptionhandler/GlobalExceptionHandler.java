package com.ohgiraffers.exceptionhandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 전역 예외 처리를 담당
@ControllerAdvice
public class GlobalExceptionHandler {
    // 여기에다가 익셉션 핸들러들을 적어놓으면 실행시키면서 발생하는 익셉션 핸들러들을 잡아온다. 그리고 여기에 있는 애들로 실행시켜줌

    @ExceptionHandler(NullPointerException.class)
    public String nullPointExceptionHandler(NullPointerException exception){
        System.out.println("Global 레벨의 exception 처리");

        return "error/nullPointer";
    }

    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandler(Model model, MemberRegistException exception){
        System.out.println("Global 레벨의 exception 처리");
        model.addAttribute("exception", exception);

        return "error/memberRegist";
    }

    /*
    최상위 타입인 Exception 을 이용하면 구체적으로 작성하지 않은 타입의 에러가 발생해도
    처리가 가능하기 때문에 default 처리 용도로 사용할 수 있다.
    @ExceptionHandler(Exception.class)
     */

    @ExceptionHandler(Exception.class)
    public String defaultExceptionHandler(Exception exception) {
        return "error/default";
    }


}
