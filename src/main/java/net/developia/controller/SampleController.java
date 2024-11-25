package net.developia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Controller
@Log
@RequestMapping("/sample/*")
public class SampleController {

   @GetMapping("/all")
   public void doAll() {
      log.info("do all can access everybody");
   }
   @GetMapping("/member")
   public void doMember() {
      log.info("login member");
   }
   @GetMapping("/admin")
   public void doAdmin() {
      log.info("admin only");
   }
}