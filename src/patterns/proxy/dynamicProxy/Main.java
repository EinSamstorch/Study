package patterns.proxy.dynamicProxy;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/12 19:27
 */
public class Main {
    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsService smsServiceImplProxy = (SmsService) JdkProxyFactory.getProxy(smsService);
        smsServiceImplProxy.send("java");
    }
}
