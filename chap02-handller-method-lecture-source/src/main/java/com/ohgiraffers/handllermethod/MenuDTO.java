package com.ohgiraffers.handllermethod;

import lombok.*;

/*
* DTO를 커멘드 객체로 이용하기 위해서는 form에 있는 name과 값이 일치하게 만들어야 한다.
* */
@NoArgsConstructor // 커멘드 객체는 기본생성자를 이용해서 인스턴스를 만들기 때문에 기본생성자가 반드시 필요하다.
@Getter
@Setter // 요청 파라미터 name과 일치하는 필드의 setter를 이용하기 때문에 네이밍룰에 맞는 setter메소드를 작성 시켜줘야 한다.
@ToString

public class MenuDTO {

    private String name;
    private int price;
    private int categoryCode;
    private String orderableStatus;
}
