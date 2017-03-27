package vn.gmobile.vehiclebooking.listener;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

import vn.gmobile.vehiclebooking.db.DriverMobileDAO;
import vn.gmobile.vehiclebooking.db.LdapDAO;
import vn.gmobile.vehiclebooking.db.VehicleDAO;
import vn.gmobile.vehiclebooking.model.Driver;
import vn.gmobile.vehiclebooking.model.DriverMobile;
import vn.gmobile.vehiclebooking.model.Vehicle;
import vn.gmobile.vehiclebooking.model.VehicleModel;
import vn.gmobile.vehiclebooking.util.DateTimeHelper;

import com.bean.base.BeanFilter;
import com.gtel.ldap.bpmn.GLdapHelper;
import com.gtel.ldap.model.User;

/**
 * @author anhta
 */
public class InitVariables implements ExecutionListener {
    
    private final static Logger LOGGER = Logger.getLogger(InitVariables.class.getName());
   
	/**
	 * @see org.camunda.bpm.engine.delegate.ExecutionListener#notify(org.camunda.bpm.engine.delegate.DelegateExecution)
	 */
	public void notify(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		
		DateTimeHelper dateTimeHelper = new DateTimeHelper();
		execution.setVariable("dateTimeHelper",dateTimeHelper);
		LOGGER.info("Init Variables successful!");
	    
	    String requester = (String) execution.getVariable("owner");
	    GLdapHelper helper = new GLdapHelper();
	    User user = helper.getUserBySAMAccountName(requester);
	    LdapDAO ldapDAO = new LdapDAO();
	    //List drivers and vehicles
	    DriverMobileDAO driverDao = new DriverMobileDAO();
	    BeanFilter dFilter = new BeanFilter(DriverMobile.class);
	    List<Driver> drivers = driverDao.getBean(dFilter);
	    
	    VehicleDAO vDao = new VehicleDAO();
	    BeanFilter vFilter = new BeanFilter(Vehicle.class);
	    List<VehicleModel> vehicles = vDao.getBean(vFilter);
	    
	    execution.setVariable("ldapDAO", ldapDAO);
	    execution.setVariable("requester", user);
	    execution.setVariable("drivers", drivers);
	    execution.setVariable("vehicles", vehicles);
//	    drivers.get(0).get(DriverMobile.MOBILE)
	    
//	    SmsTaskWrapper task = new SmsTaskWrapper();
//	    dateTimeHelper.dateToString(task.getSchedule_date());
	    
	    
	}
  }
