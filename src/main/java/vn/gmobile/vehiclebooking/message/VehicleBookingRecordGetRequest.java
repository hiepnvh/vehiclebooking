package vn.gmobile.vehiclebooking.message;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.json.JSONObject;

import com.base.filter.FilterCriteria;
import com.base.filter.StringEqualFilter;
import com.base.filter.StringLikeFilter;
import com.bean.base.BeanFilter;

import vn.gmobile.vehiclebooking.conf.JsParams;
import vn.gmobile.vehiclebooking.db.VehicleBookingRecordDAO;
import vn.gmobile.vehiclebooking.model.VehicleBookingRecord;

import com.gtel.gportal.db.UserDAO;

public class VehicleBookingRecordGetRequest extends JsonRequest {

	/**
	 * @param jObj
	 * @throws Exception 
	 */
//	Integer _webapp_id;
//	String _username;
//	String _displayName;
	
	private static Logger LOGGER = Logger.getLogger(VehicleBookingRecordGetRequest.class.getName());
	
	public VehicleBookingRecordGetRequest(JSONObject jObj) throws Exception {
		super(jObj);
//		_webapp_id = jObj.getInt(JsParams.GET_HRWORKS_EMPLOYEE_RECORD_REQUEST.WEBAPP_ID);
//		_username = jObj.getString("username").replaceAll("\\[\"", "").replaceAll("\"\\]", "");
//		_displayName = jObj.getString("displayName").replaceAll("\\[\"", "").replaceAll("\"\\]", "");
		
		//get functions, profiles of user
//		UserDAO uDao = new UserDAO();
//		List<MenuFunction> functions = uDao.getFunctionOfUser(uDao.getUser(_username), _webapp_id);
//		Profile profile = uDao.getProfileOfUser(uDao.getUser(_username), _webapp_id);
		
		//set filter
		_filter =  new BeanFilter(VehicleBookingRecord.class);
		FilterCriteria dateCriteria = new FilterCriteria();
		
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		
		if (jObj.has(JsParams.VEHICLE_BOOKING.REQUESTER)) {
			String  requester = jObj.getString(JsParams.VEHICLE_BOOKING.REQUESTER);
			_filter.setFilter(VehicleBookingRecord.REQUESTER, new StringLikeFilter(requester));
		}
		_start = Integer.parseInt(jObj.getString(JsParams.VEHICLE_BOOKING.START));
		_limit = Integer.parseInt(jObj.getString(JsParams.VEHICLE_BOOKING.LIMIT));
	}
	
	Integer _start,_limit,_profile_id;
	BeanFilter _filter;
	
	@Override
	public JsonResponse execute() {
		VehicleBookingRecordGetResponse resp = new VehicleBookingRecordGetResponse();
		UserDAO uDao = new UserDAO();
		
		try {
//			User user = uDao.getUser(_username);
//			List<MenuFunction> functions = uDao.getFunctionOfUser(user, _webapp_id);
			VehicleBookingRecordDAO dao = new VehicleBookingRecordDAO();
			List<VehicleBookingRecord> beans = dao.getBean(_filter);	
			int res = beans.size();
			List<VehicleBookingRecord> list = new ArrayList<VehicleBookingRecord>(_limit);
			for(int i = _start; i<_start + _limit; i++){
				if(i<res)
					list.add(beans.get(i));
				else
					break;
			};
			resp.setResultList(list);
			resp.setSuccess(true);
			resp.setResults(beans.size());
//			resp.setUserInfo(user,functions);
	} catch (Exception exc) {
		exc.printStackTrace();
		resp.setSuccess(false);
		resp.setInfo(exc.getMessage());
		
	}
	return resp;
	}

}
