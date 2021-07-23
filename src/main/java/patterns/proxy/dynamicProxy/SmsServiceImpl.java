package patterns.proxy.dynamicProxy;


/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/12 17:28
 */
public class SmsServiceImpl implements SmsService {
    @Override
    public void send(String message) {
        System.out.println("send message:" + message);
    }
}
