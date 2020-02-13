package com.example.demo.spi;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.ServiceLoader;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.config.spring.ReferenceBean;
import com.alibaba.dubbo.rpc.Protocol;

/**
 * @author: chunmu
 * @Date: 2019/8/17 16:48
 * @Description:
 */
public class Dog implements IShot {

    @Override
    public void shout() {
        System.out.println("wang wang");
    }

    /**
     * java spi
     * @param args
     */
    public static void main(String[] args){
        ServiceLoader<IShot> shotServiceLoader = ServiceLoader.load(IShot.class);
        shotServiceLoader.forEach(IShot::shout);
        // Iterator iterator = shotServiceLoader.iterator();
        // while(iterator.hasNext()){
        //     IShot shot = (IShot) iterator.next();
        //     shot.shout();
        // }
    }

    /**
     * dubbo spi
     * @param args
     */
    // public static void main(String[] args){
    //     //参考文章：https://my.oschina.net/u/2457218/blog/1517866
    //     ExtensionLoader.getExtensionLoader(IShot.class).getExtension("cat").shout();
    //     ExtensionLoader.getExtensionLoader(IShot.class).getExtension("dog").shout();
    //     // ExtensionLoader.getExtensionLoader(IShot.class).getAdaptiveExtension().shout();
    //
    //     // String url = "registry://zktestserver1.wacai.info:22181/com.alibaba.dubbo.registry.RegistryService?application=cm-activity&backup=zktestserver2.wacai.info:22181,zktestserver3.wacai.info:22181&cellinvokemode=sharing&client=zkclient&dubbo=3.2.8.2&group=dubbo_test&owner=tiehua&pid=991&refer=application%3Dcm-activity%26cellinvokemode%3Dsharing%26check%3Dfalse%26default.check%3Dfalse%26dubbo%3D3.2.8.2%26group%3Dtest%26interface%3Dcom.wacai.creditcard.coupon.service.CouponFacadeService%26methods%3DgetDrawCouponNum%2CcouponMatchBank%2CgetAllActivateCoupon%2CisExistUsableCoupon%2CgetByCouponCode%2CunFreeze%2Cfreeze%2CgetAvailableCouponList%2CdisabledCoupons%2CgetDiffActivitiesMaxEffectiveEndTimeCouponRecord%2CdrawCouponWithoutFulfillment%2Cverify%2CgetByUidStatus%2CgetByUidAndBizNo%2CgetAllUseCouponByUidWithCardNo%2CcountActivatedNumByType%2CgetDrawCouponNumByCouponActivityId%2CdrawCoupon%2CgetCouponByCouponCodeUid%2CgetCouponsByStatus%2CgetDrawCoupon%2CgetByUidAndBizType%2CgetBySubTypeListAndStatus%2CgetUntivateUseableCoupons%2CgetByOrderNo%2CgetCouponByCodes%2CactivateCoupon%2CupdateStatusByCouponCode%2CgetActivatedByUidAndBizType%2CgetAllCouponList%2CgetCouponsByActivity%2CcountDayCouponBySchemaIdWithStatus%2CgetByUidStatusAndBizChannel%26owner%3Dtiehua%26pid%3D991%26register.ip%3D172.16.112.138%26retries%3D0%26revision%3D1.4.4%26side%3Dconsumer%26timestamp%3D1572229290333&registry=zookeeper&timestamp=1572229290375";
    //     // Protocol refprotocol = ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();
    //     // refprotocol.refer()
    //
    // }

    // public static void main(String[] args){
    //     ReferenceBean rb = new ReferenceBean();
    // }

    // public static void main(String[] args){
    //     Dog d = new Dog();
    //     IShot i = d.get();
    //     i.shout();
    // }

    private IShot get(){
        // IShot result1 = new Cat();
        IShot result2 = new Dog();
        BigDecimal b1 = BigDecimal.ZERO;
        IShot result3 = new IShot(){

            @Override
            public void shout() {
                b1.toString();
                // result1.shout();
                result2.shout();
            }
        };
        return result3;
    }
}
