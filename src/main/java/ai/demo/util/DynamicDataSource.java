package ai.demo.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author yu
 * @date 2019/12/15 0015
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSources) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("此时获取到的数据源为："+contextHolder.get());
        return getDataSource();
    }
    // 设置数据源类型
    public static void setDataSource(String dataSource) {
        contextHolder.set(dataSource);
    }
    // 获取数据源类型
    public static String getDataSource() {
        return contextHolder.get();
    }
    // 清除数据源类型
    public static void clearDataSource() {
        contextHolder.remove();
    }
}

