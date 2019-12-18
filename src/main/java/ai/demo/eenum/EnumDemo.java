package ai.demo.eenum;

/**
 * @author yu
 * @date 2019/12/12 0012
 */
public class EnumDemo {
    public static void main(String[] args) {
        System.out.println(Week.TUESDAY.getDesc());
    }
}
enum Week{
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");
    private String desc;
    private Week(String desc){
        this.desc=desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
