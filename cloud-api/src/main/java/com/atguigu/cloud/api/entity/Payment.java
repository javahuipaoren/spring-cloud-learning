package com.atguigu.cloud.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Payment {
    private Long id;
    private String serial;
}
