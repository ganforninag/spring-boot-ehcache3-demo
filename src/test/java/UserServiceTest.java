import com.itclj.ItcljApplication;
import com.itclj.model.UserBean;
import com.itclj.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by clj on 2017/6/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItcljApplication.class)
public class UserServiceTest {

    Logger logger= LoggerFactory.getLogger(UserServiceTest.class);

    @Resource
    private UserService userService;

    @Resource
    private CacheManager cacheManager;

    @Test
    public void getByName(){
        for(int n=0;n<5;n++){
            UserBean userBean=userService.getByName("王五");
            logger.info("========get result:{}",userBean.toString());
            logger.info("====================cacheManager:"+cacheManager.getClass().getName());
        }
    }

}
