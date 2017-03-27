package vn.gmobile.vehiclebooking.message;

import java.util.List;

import org.json.JSONArray;

import com.bean.json.JsonUtils;
import vn.gmobile.vehiclebooking.conf.JsParams;
import vn.gmobile.vehiclebooking.model.VehicleBookingRecord;


public class VehicleBookingRecordGetResponse extends JsonResponse {

	public VehicleBookingRecordGetResponse() {
	}
	
	public void setResultList(List<VehicleBookingRecord> log) throws Exception {
		JSONArray jArr = JsonUtils.fromBeanListToJsonArray(log);		
		write(JsParams.VEHICLE_BOOKING_RESPONSE.RESULT_LIST, jArr);
	}
	
	public void setResults(Integer results) throws Exception {
		write(JsParams.VEHICLE_BOOKING_RESPONSE.RESULTS, results);
	}

//	public void setUserInfo(User user, List<MenuFunction> functions) throws Exception {
//		JSONObject jsUser = JsonUtils.fromBeanToJson(user);
//		write(JsParams.LOGIN_RESPONSE.USER, jsUser);
//
//		JSONArray  jsonFunctions = JsonUtils.fromBeanListToJsonArray(functions);
//		write(JsParams.LOGIN_RESPONSE.FUNCTION_LIST, jsonFunctions);
//		
//	}
}
