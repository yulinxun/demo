package ai.demo.single;

/**
 * @author yu
 * @date 2019/12/12 0012
 */
//单例饿汉式加载
public class MySingle {
    private static MySingle mySingle=new MySingle();
    private MySingle(){};
    public static MySingle getMySingle(){
        return mySingle;
    }
}
