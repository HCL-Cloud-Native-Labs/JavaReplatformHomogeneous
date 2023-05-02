package com.presto.banking.datagram;


import java.io.PrintStream;


public class AdminDataPriority {
    public void run(String[] argv, PrintStream log, PrintStream out) {
        ThreadGroup thg = new ThreadGroup("setMaxPriority0105");
        int prio = thg.getMaxPriority();
        thg.setMaxPriority(((Thread.MIN_PRIORITY) - 1));
        if (prio != (thg.getMaxPriority())) {
            out.println(((("thread group priority is changed:" + prio) + "-") + (thg.getMaxPriority())));
        }
    }

    public static void ThreadPoolSet() {
        String[] args = new String[5];
        new AdminDataPriority().run(args, System.err, System.out);
    }
}

