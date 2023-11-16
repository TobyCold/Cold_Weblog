package top.tobycold.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Home {

    @RequestMapping("/a")
    @ResponseBody
    public String getAbc(){
        return "HelloWorld";
    }



}
