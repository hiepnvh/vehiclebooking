package vn.gmobilel.vehiclebooking;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.camunda.bpm.application.PostDeploy;
import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;
import org.camunda.bpm.engine.ProcessEngine;

import vn.gmobile.vehiclebooking.util.DateTimeHelper;
//import vn.gmobile.vehiclebooking.model.SmsTask;
//import vn.gmobile.vehiclebooking.model.SmsTaskWrapper;

/**
 * Process Application exposing this application's resources the process engine.
 */
@ProcessApplication
public class CamundaBpmProcessApplication extends ServletProcessApplication {

	private final Logger LOGGER = Logger.getLogger(CamundaBpmProcessApplication.class.getName());

	private static final String PROCESS_DEFINITION_KEY = "message-approval";

	/**
	 * In a @PostDeploy Hook you can interact with the process engine and access
	 * the processes the application has deployed.
	 */
	@PostDeploy
	public void onDeploymentFinished(ProcessEngine processEngine) {
		
//		LOGGER.info("\nName of process Engine = " + processEngine.getName() +"\n");;
//		
//		// start an initial process instance
//		Map<String, Object> variables = new HashMap<String, Object>();
//
//		SmsTask task = new SmsTask();
//		task.set(SmsTask.TASK_ID, 1);
//		task.set(SmsTask.SOURCE, "Gmobile");
//		task.set(SmsTask.MESSAGE, "chung toi la chien si cong binh");
//
//		SmsTaskWrapper smsTaskWrapper = new SmsTaskWrapper(task);
//		variables.put("task", smsTaskWrapper);
//
//		LOGGER.info("Set value done");
//
//		processEngine.getRuntimeService().startProcessInstanceByKey(PROCESS_DEFINITION_KEY, variables);
	}
}
