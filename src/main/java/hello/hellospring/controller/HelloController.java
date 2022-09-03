package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "태윤!");
        return "byebye";
    }

    // MVC, 템플릿 엔진(thymeleaf)
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    // API 방식(데이터를 그대로 내림)
    @GetMapping("hello-string")
    @ResponseBody // http body에 데이터를 직접 넣어주겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    // 객체 반환을 하는 API 방식
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello(); // 객체 생성
        hello.setName(name);
        return hello; // 객체 반환
    }
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
