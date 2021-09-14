package com.backendvulnerabilities.ssti.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {Exception.class})
    public ModelAndView handleError404()   {
        return new ModelAndView("404");
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ModelAndView handleError404(HttpServletRequest request, Exception e)   {
        ModelAndView mv = new ModelAndView("/404");
        return mv;
    }
}
