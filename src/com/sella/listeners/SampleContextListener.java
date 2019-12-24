package com.sella.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SampleContextListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("contextInitialized method called :" + sce);
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("contextDestroyed method called :" + sce);
  }

}
