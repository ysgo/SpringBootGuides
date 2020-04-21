package com.boot.guides.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BatchController {
	private final JobLauncher jobLauncher;
	private final Job job;

	@Autowired
	private BatchController(JobLauncher jobLauncher, Job job) {
		this.jobLauncher = jobLauncher;
		this.job = job;
	}

	@RequestMapping("/jobLauncher")
	public void handle() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException,
			JobInstanceAlreadyCompleteException {
		Map<String, JobParameter> map = new HashMap<>();
		map.put("create_date", new JobParameter(new Date()));
		jobLauncher.run(job, new JobParameters(map));
	}
}
