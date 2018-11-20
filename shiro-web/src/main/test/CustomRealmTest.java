import com.xfb.shiro.realm.CustomRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;

/**
 * className:CustomRealmTest
 * describe:
 * author:邢芳彬
 * createTime:2018-11-14 11:29
 */
public class CustomRealmTest {
    //QAQ`
    CustomRealm customRealm = new CustomRealm();
    @Test
    public void test() {
        //1.构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(customRealm);
        //2.主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        //3.登录认证
        UsernamePasswordToken token = new UsernamePasswordToken("Mark", "123456");
        subject.login(token);

        //4.测试认证及授权是否正确
        System.out.println(subject.isAuthenticated());
        //subject.isAuthenticated();


    }
}
