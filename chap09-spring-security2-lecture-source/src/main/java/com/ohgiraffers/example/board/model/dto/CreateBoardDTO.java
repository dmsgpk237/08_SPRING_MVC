package com.ohgiraffers.example.board.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateBoardDTO {

    // dto로 받아올 때 이름이 틀리면 제대로 받아올 수 없다.
    private String title;

    private String content;

}
