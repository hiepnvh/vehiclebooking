package vn.gmobile.vehiclebooking.delegate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import vn.gmobile.vehiclebooking.db.VehicleBookingRecordDAO;
import vn.gmobile.vehiclebooking.model.VehicleBookingRecord;
import vn.gmobile.vehiclebooking.util.DateTimeHelper;


public class UpdateDatabaseDelegate implements JavaDelegate {

	private static final Logger LOGGER = Logger.getLogger(UpdateDatabaseDelegate.class.getName());
			
	public void execute(DelegateExecution execution) throws Exception {
		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		
		
		LOGGER.info("Update HR Database ...");
//		LOGGER.info((String) execution.getVariable("purpose"));
		DateTimeHelper helper = new DateTimeHelper();
		
		String requester = (String) execution.getVariable("owner");
		String purpose = (String) execution.getVariable("purpose");
		String _startTime = (String) execution.getVariable("startTime");
		Date startTime = helper.stringToDate(_startTime);
		String _stopTime = (String) execution.getVariable("stopTime");
		Date stopTime =  helper.stringToDate(_stopTime);
		String note = (String) execution.getVariable("note");
		String _actualStartTime = (String) execution.getVariable("actualStartTime");
		Date actualStartTime =  helper.stringToDate(_actualStartTime);
		String _actualStopTime = (String) execution.getVariable("actualStopTime");
		Date actualStopTime =  helper.stringToDate(_actualStopTime);
		String _actualExtraFee = (String) execution.getVariable("actualExtraFee");
		Double actualExtraFee = Double.parseDouble(_actualExtraFee);
		String actualExtraFeeJustification = (String) execution.getVariable("actualExtraFeeJustification");
		String vehicleType = (String) execution.getVariable("vehicleType");
		String vehicleNumber = (String) execution.getVariable("vehicleNumber");
		String vehicleContactInfo = (String) execution.getVariable("vehicleContactInfo");
		String driverName = (String) execution.getVariable("driverName");
		
		VehicleBookingRecordDAO dao = new VehicleBookingRecordDAO();
		VehicleBookingRecord r = new VehicleBookingRecord();
		r.set(VehicleBookingRecord.REQUESTER, requester);
		r.set(VehicleBookingRecord.START_TIME,startTime);
		r.set(VehicleBookingRecord.END_TIME,stopTime);
		r.set(VehicleBookingRecord.PURPOSE,purpose);
		r.set(VehicleBookingRecord.NOTE,note);
		r.set(VehicleBookingRecord.ACTUAL_START_TIME,actualStartTime);
		r.set(VehicleBookingRecord.ACTUAL_END_TIME,actualStopTime);
		r.set(VehicleBookingRecord.ACTUAL_EXTRA_FEE,actualExtraFee);
		r.set(VehicleBookingRecord.ACTUAL_EXTRA_JUSTIFICATION,actualExtraFeeJustification);
		r.set(VehicleBookingRecord.VEHICLE_TYPE,vehicleType);
		r.set(VehicleBookingRecord.VEHICLE_NUMBER,vehicleNumber);
		r.set(VehicleBookingRecord.VEHICLE_CONTACT_INFO,vehicleContactInfo);
		r.set(VehicleBookingRecord.DRIVER_NAME,driverName);

		dao.update(r);
		
	}

}
