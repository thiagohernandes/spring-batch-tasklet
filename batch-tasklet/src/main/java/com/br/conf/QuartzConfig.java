package com.br.conf;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.br.job.QuartzJobLauncher;

@Configuration
public class QuartzConfig {

 @Autowired
 private JobLauncher jobLauncher;
 
 @Autowired
 private JobLocator jobLocator;
 
 @Bean
 public JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor(JobRegistry jobRegistry) {
  JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor = new JobRegistryBeanPostProcessor();
  jobRegistryBeanPostProcessor.setJobRegistry(jobRegistry);
  
  return jobRegistryBeanPostProcessor;
 }
 
 @Bean
 public JobDetailFactoryBean jobDetailFactoryBean() {
  JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
  jobDetailFactoryBean.setJobClass(QuartzJobLauncher.class);
  Map<String, Object> map = new HashMap<String, Object>();
  map.put("jobName", "jobCustomTeste");
  map.put("jobLauncher", jobLauncher);
  map.put("jobLocator", jobLocator);
  
  jobDetailFactoryBean.setJobDataAsMap(map);
  
  return jobDetailFactoryBean;
 }
 
 @Bean
 public CronTriggerFactoryBean cronTriggerFactoryBean() {
  CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
  cronTriggerFactoryBean.setJobDetail(jobDetailFactoryBean().getObject());
  //run every 10 seconds
  cronTriggerFactoryBean.setCronExpression("*/3 * * * * ? *");
  
  return cronTriggerFactoryBean;
 }
 
 @Bean
 public SchedulerFactoryBean schedulerFactoryBean() {
  SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
  schedulerFactoryBean.setTriggers(cronTriggerFactoryBean().getObject());
  
  return schedulerFactoryBean;
 }
} 