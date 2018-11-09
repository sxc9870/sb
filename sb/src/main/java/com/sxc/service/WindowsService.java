package com.sxc.service;

import com.sxc.interface1.OSLister;

public class WindowsService implements OSLister {

    private String ms;
    @Override
    public String showCMD() {
        return ms;
    }
    public String getMs() {
        return ms;
    }
    public void setMs(String ms) {
        this.ms = ms;
    }

    

}
