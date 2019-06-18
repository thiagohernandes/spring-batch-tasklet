package com.br;

import java.io.IOException;

import org.quartz.SchedulerException;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;


@SpringBootApplication
//public class BatchTaskletApplication implements CommandLineRunner {
public class BatchTaskletApplication  {
	
	public static void main(String[] args) {
		SpringApplication.run(BatchTaskletApplication.class, args);
	} 

//    @Autowired
//    JobLauncher jobLauncher;
//     
//    @Autowired
//    Job job;
//     
//    public static void main(String[] args)
//    {
//        SpringApplication.run(BatchTaskletApplication.class, args);
//    }
// 
//    @Override
//    public void run(String... args) throws Exception
//    {
//        JobParameters params = new JobParametersBuilder()
//                    .addString("JobID", String.valueOf(System.currentTimeMillis()))
//                    .toJobParameters();
//        jobLauncher.run(job, params);
//    }
	// OBSERVAR A PROPRIEDADE NO application.properties = true ou false
	
}
