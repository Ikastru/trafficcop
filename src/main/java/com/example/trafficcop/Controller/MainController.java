package com.example.trafficcop.Controller;

import com.example.trafficcop.util.NextUtil;
import com.example.trafficcop.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping("number")
public class MainController {

    @Autowired
    private final RandomUtil randomUtil;

    @Autowired
    private final NextUtil nextUtil;

    public MainController(RandomUtil randomUtil, NextUtil nextUtil) {
        this.randomUtil = randomUtil;
        this.nextUtil = nextUtil;
    }

    @GetMapping("random")
    public void random(HttpServletResponse randomResponse) {
        randomResponse.setContentType("text/plain;charset=UTF-8");
        randomResponse.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
            out = randomResponse.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String content = randomUtil.getContents();
        try {
            out.print(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("next")
    public void next(HttpServletResponse nextResponse) {
        nextResponse.setContentType("text/plain;charset=UTF-8");
        nextResponse.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
            out = nextResponse.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String content = nextUtil.getContents();
        try {
            out.print(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
