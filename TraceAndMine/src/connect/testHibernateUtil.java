package connect;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import com.ccnu.util.HibernateUtil;

public class testHibernateUtil {
	@Test
	public void testConnect() throws Exception{
		assertNotNull(HibernateUtil.currentSession());	
	}
}
