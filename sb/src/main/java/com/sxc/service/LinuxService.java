package com.sxc.service;

import com.sxc.interface1.OSLister;

public class LinuxService implements OSLister {

    public String showCMD() {
        return "Linux";
    }


}
