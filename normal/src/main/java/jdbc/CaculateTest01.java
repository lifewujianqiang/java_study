package jdbc;

import org.junit.Assert;
import org.junit.Test;

/**
 * author:MarryCheck
 * create 2018-11-20 21:39
 * comment:
 */

public class CaculateTest01 {

    /**
     * junit注意事项：
     * 1.方法不能有返回值
     * 2.方法不能有参数
     */
    @Test
    public void test() {
        System.out.println("this is junit test code ");
    }

    @Test
    public void test02() {
        System.out.println("this is test code again");
    }

    @Test
    public void test03() {
        Caculate c = new Caculate();
        Assert.assertEquals(15, c.add(10, 5));
        assert 15 == c.add(10,5);
        System.out.println("断言成功");
    }


}
