package com.quinit.aaaa.pojo.queryparam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogQueryParam {
    private Integer page;
    private Integer pageSize;
}
