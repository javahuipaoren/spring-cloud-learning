package com.atguigu.cloud.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Storage {

    private Long id;
    private Long productId;
    private Integer total;//总库存
    private Integer used;//已用库存
    private Integer residue;//剩余库存
}
