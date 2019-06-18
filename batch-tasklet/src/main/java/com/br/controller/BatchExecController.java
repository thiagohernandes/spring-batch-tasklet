package com.br.controller;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.conf.BatchConfig;

@RestController
@RequestMapping("/api-job")
public class BatchExecController {

	@Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;
    
    @Autowired
    BatchConfig batchConfig;
    
    @RequestMapping("/run")
    public void handle() throws Exception{
        jobLauncher.run(job, new JobParameters());
    }
    
    @RequestMapping("/run2")
    public void handle2() throws Exception{
    	jobLauncher.run(batchConfig.jobCustomTeste(), new JobParameters());
    }
    
    @RequestMapping("/run3")
    public void handle3() throws Exception{
    }
    
}
