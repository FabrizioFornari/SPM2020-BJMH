import com.amrengp.web.AmrenApplication;
import com.amrengp.web.m_dao.UserMongoDao;
import com.amrengp.web.pojo.UserMongo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AmrenApplication.class})
public class AmrenApplicationTests {
	private static final Logger logger = LoggerFactory.getLogger(AmrenApplicationTests.class);


	@Autowired
	UserMongoDao userMongoDao;
	@Test
	public void contextLoads() {
		UserMongo userMongo = new UserMongo();
		userMongo.setCarcolor("asdasd");
		userMongo.setId("123123l");
		userMongo.setCarplate("asdas");
//		userMongoDao.insertUser(userMongo);
		List<UserMongo> userMongos = userMongoDao.selectUserList(new UserMongo());
		System.out.println(userMongos);
	}

}
