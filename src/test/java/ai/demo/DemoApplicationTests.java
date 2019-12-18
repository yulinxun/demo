package ai.demo;

import ai.demo.annotation.MyAnnotation;

import ai.demo.mapper.BookMapper;
import ai.demo.util.DynamicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoApplicationTests {
    @Autowired
    private BookMapper bookMapper;

    @Test
    public void contextLoads() {
        System.out.println(bookMapper.selectByPrimaryKey(5).getBookName());
    }

    @Test
    public void test2() {
        try {
            DynamicDataSource.setDataSource("first");
            System.out.println(DynamicDataSource.getDataSource());
            // TODO 查询编号为二的数据库
            System.out.println(bookMapper.selectByPrimaryKey(5).getBookName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //TODO 结束，修改数据源，将其变回默认数据源
            DynamicDataSource.setDataSource("first");
        }

    }

}
