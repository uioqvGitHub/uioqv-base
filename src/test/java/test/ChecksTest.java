package test;

import com.uioqv.base.utils.Checks;
import org.junit.Test;

/**
 * @author LiuGuoQing
 * @since 2018-11-05
 */
public class ChecksTest {

    @Test
    public void testException() {
        Checks.isNotNull(null);
    }
}
