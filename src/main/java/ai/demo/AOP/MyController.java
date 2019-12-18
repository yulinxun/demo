package ai.demo.AOP;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yu
 * @date 2019/12/5 0005
 */
@RestController
@RequestMapping("aop")
public class MyController {

    @RequestMapping("test")
    public String test(String name,String id){
        System.out.println(123);
        return id;
    }
}
