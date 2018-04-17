package redis.test;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:spring-*.xml" })
public class TestRedis {
	@Autowired
	private RedisTemplate redisTemplate=new RedisTemplate<>();

	private static final Logger log = Logger.getLogger(TestRedis.class.getName());

	@Test
	public void test() {
		redisTemplate.opsForValue().set("chen", "³Âè÷Æ½");
		log.info("value£º" + redisTemplate.opsForValue().get("chen"));
	}

}
