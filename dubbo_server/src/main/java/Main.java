import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hongjian.chen on 2017/3/31.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationProvider.xml"});
        context.start();
        System.out.println("按任意键退出");
        System.in.read();
    }
}
