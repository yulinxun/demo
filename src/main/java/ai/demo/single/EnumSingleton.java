package ai.demo.single;

/**
 * @author yu
 * @date 2019/12/12 0012
 */
public enum  EnumSingleton {
    INSTANCE;
    public EnumSingleton getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        EnumSingleton enumSingleton=EnumSingleton.INSTANCE;
        EnumSingleton enumSingleton2=EnumSingleton.INSTANCE;
        System.out.println(enumSingleton);
        System.out.println(enumSingleton2);
    }
}

