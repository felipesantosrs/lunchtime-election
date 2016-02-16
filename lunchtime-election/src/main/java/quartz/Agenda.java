
package quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * This class is responsable to manager a trigger of quartz.
 * @author Felipe
 */
public class Agenda {
	
	/**
	 * This method inicialize and will control a trigger
	 * @throws Exception
	 */
	public static void init() throws Exception {

        JobDetail job = JobBuilder.newJob(TaskQuartz.class).withIdentity(
                "executing job", "group1").build();
        
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(
                "executing trigger", "group1").withSchedule(
                CronScheduleBuilder.cronSchedule("0 15 11 * * ? *")).build();
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
 
    }

}
