package com.syscho.boot.config;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RequestInterceptor implements HandlerInterceptor {

    private static final String START = "START";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        ZonedDateTime startTime = ZonedDateTime.now();

        Long start = startTime.toInstant().toEpochMilli();
        MDC.put(START, start);
        log.info("RequestInterceptor : executing preHandle method  :started at {}",
                startTime.format(DateTimeFormatter.ISO_TIME));
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        if (null != MDC.get(START)) {
            Long start = Long.parseLong((String) MDC.get(START));
            ZonedDateTime endTime = ZonedDateTime.now();
            Long end = endTime.toInstant().toEpochMilli();

            log.info("RequestInterceptor : executing afterCompletion method :ended at {}  : took  {} ms",
                    endTime.format(DateTimeFormatter.ISO_TIME), (end - start));
        }
        MDC.clear();

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        log.info("RequestInterceptor : executing postHandle method ");
    }

}
