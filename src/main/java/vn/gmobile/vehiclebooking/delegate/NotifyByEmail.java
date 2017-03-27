package vn.gmobile.vehiclebooking.delegate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
//import com.gtel.hrworks.model.EmployeeRecord;





import org.joda.time.DateTime;

import com.gtel.ldap.model.User;

import vn.gmobile.vehiclebooking.delegate.Email;
import vn.gmobile.vehiclebooking.model.VehicleBookingRecord;

//import vn.gmobile.vehiclebooking.db.TaskApprovalMappingDAO;
//import vn.gmobile.vehiclebooking.model.SmsTaskWrapper;
//import vn.gmobile.vehiclebooking.model.TaskApprovalMapping;

public class NotifyByEmail implements JavaDelegate {

	private static final Logger LOGGER = Logger.getLogger(NotifyByEmail.class.getName());
			
	/** Notifying email to employees when they have task 
	 * @see org.camunda.bpm.engine.delegate.JavaDelegate#execute(org.camunda.bpm.engine.delegate.DelegateExecution)
	 */
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		

//		User requester = (User) execution.getVariable("requester");
//		String recipient =  requester.getMail();
//		LOGGER.info(" purpose " + (String) execution.getVariable("purpose"));
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//		Date _startTime = (Date) execution.getVariable("startTime");
////		Date startTime = dateFormat.parse(_startTime);
//		
//		LOGGER.info("date " + _startTime);
		Email.sendEmail(execution);
	}
}