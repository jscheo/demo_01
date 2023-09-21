package com.example.demo.controller;

import com.example.demo.dto.DemoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ReqController {
    @GetMapping("/req1")
    public String req1(@RequestParam("p1") String p1,
                       @RequestParam("p2") int p2){
        System.out.println("p1 = " + p1 + ", p2 = " + p2);
        return "index";
    }

    // /req2/aaa
    @GetMapping("/req2/{p3}")
    // {p3} 는 변수이름(파라미터이름) 받아온 값을 변수에 담아주자는 의미
    public String req2(@PathVariable("p3") String p3){
        System.out.println("p3 = " + p3);
        return "index";
    }

    @PostMapping("/req3")
    public String req3(@RequestParam("name") String name, @RequestParam("age") int age){
        System.out.println("name = " + name + ", age = " + age);
        return "index";
    }

    @GetMapping("/req4")
    public String req4(Model model){
        model.addAttribute("a1", "안녕하세요");
        model.addAttribute("a2", "반갑습니다.");
        return "req4";
    }

    @GetMapping("/req5")
    public String req5(Model model){
        DemoDTO demoDTO = new DemoDTO();
        demoDTO.setId(1L);
        demoDTO.setName("이름1");
        demoDTO.setAge(11);
        model.addAttribute("demo", demoDTO);
        return "req5";
    }

    @GetMapping("/req6")
    public String req6(Model model){
        List<DemoDTO> demoDTOList = new ArrayList<>();
        for(int i = 1; i <= 10; i++){
            DemoDTO demoDTO = new DemoDTO();
            demoDTO.setId((long) i);
            demoDTO.setName("name" + i);
            demoDTO.setAge(10 +i);
            demoDTOList.add(demoDTO);
        }
        model.addAttribute("demoList", demoDTOList);
        return "req6";
    }
}
