package net.developia.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Component
public class SystemLogAdvice {
	
	@AfterThrowing(
			pointcut = "execution(* net.developia.service.BoardService*.*(..)) || execution(* net.developia.controller.BoardController*.*(..))",
			throwing="exception")
	public void logException(Exception exception) {
		log.error("() ()");
		log.error("(^*^)");
		log.error("(>0<)?");
		log.error("@AfterThrowingadvice....!!!!");
		log.error("exception: "+exception.getMessage());
	}
}
