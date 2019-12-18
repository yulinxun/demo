package ai.demo.single;

/**
 * @author yu
 * @date 2019/12/12 0012
 */
//单例懒汉式加载
public class MySingle2 {
    private static MySingle2 mySingle2;
    private MySingle2(){};
    public static MySingle2 getMySingle(){
        if (mySingle2==null){
            synchronized (MySingle2.class){
                if (mySingle2==null){
                    mySingle2=new MySingle2();
                }
            }
        }
        return mySingle2;
    }
}
