package com.yang.springboot.demo.model;


import com.yang.springboot.demo.util.CommonConstants;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author admin
 */
@Builder
@ToString
@Accessors(chain = true)
@AllArgsConstructor
public class ResultVO<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private int code = CommonConstants.SUCCESS;

    @Getter
    @Setter
    private String msg = "success";


    @Getter
    @Setter
    private T data;

    public ResultVO() {
        super();
    }

    public ResultVO(T data) {
        super();
        this.data = data;
    }

    public ResultVO(T data, String msg) {
        super();
        this.data = data;
        this.msg = msg;
    }

    public ResultVO(Throwable e) {
        super();
        this.msg = e.getMessage();
        this.code = CommonConstants.FAIL;
    }
}
