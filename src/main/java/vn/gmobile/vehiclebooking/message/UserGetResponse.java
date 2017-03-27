package vn.gmobile.vehiclebooking.message;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.bean.json.JsonUtils;
import vn.gmobile.vehiclebooking.conf.JsParams;
import vn.gmobile.vehiclebooking.model.VehicleBookingRecord;
import com.gtel.gportal.model.MenuFunction;
import com.gtel.gportal.model.User;

public class UserGetResponse extends JsonResponse {

	public UserGetResponse() {
	}

	
//	public void setResults(Integer results) throws Exception {
//		write(JsParams.GET_SMS_HISTORY_RESPONSE.RESULTS, results);
//	}

	public void setUserInfo(User user, List<MenuFunction> functions) throws Exception {
		JSONObject jsUser = JsonUtils.fromBeanToJson(user);
		write(JsParams.LOGIN_RESPONSE.USER, jsUser);
		if(functions!=null){			
			JSONArray  jsonFunctions = JsonUtils.fromBeanListToJsonArray(functions);
			write(JsParams.LOGIN_RESPONSE.FUNCTION_LIST, jsonFunctions);
		}
		
	}
}
