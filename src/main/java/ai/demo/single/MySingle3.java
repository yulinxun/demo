package ai.demo.single;

/**
 * @author yu
 * @date 2019/12/12 0012
 */
//静态内部类实现单例
public class MySingle3 {
    private static class MySingleHolder{
        private static final MySingle3 mySingle3=new MySingle3();
    }
    private MySingle3(){};
    public static MySingle3 getMySingle(){
        return MySingleHolder.mySingle3;
    }
}
