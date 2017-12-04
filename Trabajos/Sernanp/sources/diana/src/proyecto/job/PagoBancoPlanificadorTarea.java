package proyecto.job;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;


public class PagoBancoPlanificadorTarea {

	
	public void run() throws Exception {
		
		
			SchedulerFactory schedfact=new StdSchedulerFactory();
			Scheduler sched=schedfact.getScheduler();
			//sched.start();
			JobDetail jobd = newJob(LecturaPagoBancoTarea.class).withIdentity("job1", "group1").build();
			Trigger trigger = newTrigger().withIdentity("trigger1", "group1").withSchedule(cronSchedule("0 15 10 ? * *")).build();
			sched.scheduleJob(jobd, trigger);
			
			
//			JobDetail job = newJob(LecturaPagoBancoTarea.class)
//            .withIdentity("job1", "group1")
//            .build();
			//JobDetail jobdet=new JobDetail("LaTarea",null,LecturaPagoBancoTarea.class);
//			JobDetail job = newJob(LecturaPagoBancoTarea.class)
//		      .withIdentity("myJob", "group1") // name "myJob", group "group1"
//		      .build();
//			JobDetail jobsk = newJob(SimpleJob.class)
//            .withIdentity("job1", "group1")
//            .build();
			//JobDetail jobdet=new JobDetail("LaTarea",null,LecturaPagoBancoTarea.class);
		
		
	}

}
