package proyecto.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class LecturaPagoBancoTarea implements Job{

	public LecturaPagoBancoTarea(){
		
	}
	
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("leyendo");
	}

}
