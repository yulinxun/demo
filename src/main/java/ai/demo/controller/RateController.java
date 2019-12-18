package ai.demo.controller;

import ai.demo.annotation.MyAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yu
 * @date 2019/12/12 0012
 */
@Controller
@ResponseBody
public class RateController {
    @MyAnnotation(rate = 1,timeout = 0)
    @RequestMapping("hello")
    public String test(){
        return "success";
    }
}
