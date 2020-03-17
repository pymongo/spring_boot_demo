package spring.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HomeController {
  @RequestMapping("/")
  public String index() {
    return "<h1 style='margin-left: 200px; margin-top: 120px'>Spring Boot Demo By aoxiang</h1>";
  }
}
