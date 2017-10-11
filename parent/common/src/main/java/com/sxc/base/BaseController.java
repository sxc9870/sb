package com.sxc.base;

import org.springframework.web.servlet.ModelAndView;

public abstract class BaseController {

    public static class PageBean extends ModelAndView {
    }

    public PageBean getView(String name, PageBean p) {
        p.setViewName(name);
        return p;
    }
}
