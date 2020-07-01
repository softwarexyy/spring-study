package com.yancy.marriageAgentDemo;

import java.util.logging.Logger;

/* 一个姑娘 */
public class Woman implements Marriage{

    Logger logger = Logger.getLogger("Woman");

    public void getMarriage() {
        logger.info("这位姑娘同意相处试试。");
    }
}
