package vn.gmobile.vehiclebooking.message;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;








import org.json.JSONObject;

import com.base.filter.FilterCriteria;
import com.base.filter.StringEqualFilter;
import com.base.filter.StringLikeFilter;
import com.bean.base.BeanFilter;

import vn.gmobile.vehiclebooking.conf.JsParams;
import vn.gmobile.vehiclebooking.conf.ServerConfig;
//import vn.gmobile.vehiclebooking;
import vn.gmobile.vehiclebooking.model.VehicleBookingRecord;
import vn.gmobile.vehiclebooking.report.VehicleBookingReportBuilder;



public class ReportGetRequest extends JsonRequest {

	/**
	 * @param jObj
	 * @throws Exception 
	 */
	public ReportGetRequest(JSONObject jObj) throws Exception {
		super(jObj);
		_filter =  new BeanFilter(VehicleBookingRecord.class);
		FilterCriteria dateCriteria = new FilterCriteria();
		
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		
		if (jObj.has(JsParams.VEHICLE_BOOKING.REQUESTER)) {
			String  requester = jObj.getString(JsParams.VEHICLE_BOOKING.REQUESTER);
			_filter.setFilter(VehicleBookingRecord.REQUESTER, new StringLikeFilter(requester));
			_requester = requester;
		}
	}

	BeanFilter _filter;
	String _requester;
	
	@Override
	public JsonResponse execute() {
		ReportGetResponse resp = new ReportGetResponse();
		try {
//			String tiltle_custom = (_requester=="")?"":(" cua " + _requester);
			String filename = "Bao cao dat xe.xlsx";
			VehicleBookingReportBuilder builder = new VehicleBookingReportBuilder(_requester);
			builder.buildExcelReport(ServerConfig.getPhysicalDir() +filename);
			String url = ServerConfig.getVirtualDir()+filename;
			resp.setUrl(url);
			resp.setSuccess(true);
		} catch (Exception exc) {
			exc.printStackTrace();
			resp.setSuccess(false);
			resp.setInfo(exc.getMessage());
			
		}
		return resp;
	}

}
