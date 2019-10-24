package com.example.demo.spi;

import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author: chunmu
 * @Date: 2019/8/17 16:46
 * @Description:
 */
@SPI
public interface IShot {

    void shout();

}
