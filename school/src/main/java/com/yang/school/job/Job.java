package com.yang.school.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class Job extends QuartzJobBean {
	
	private static volatile boolean isRun = false;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		
		if(!isRun) {
			isRun = true;
			System.out.println("第一次开"+name+this);
			try {
				Thread.sleep(14000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("任务完成");
			isRun = false;
		}else {
			System.out.println("前面的任务还没有完成，不执行");
		}

	}

}
