package patterns.proxy.staticProxy2;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/1 0:15
 */
public class Client {

    public static void main(String[] args) {
        //UserManager userManager=new UserManagerImpl();
        UserManager userManager = new UserManagerImplProxy(new UserManagerImpl());
        userManager.addUser("1111", "张三");
        userManager.delUser("wangwu");
    }
}
