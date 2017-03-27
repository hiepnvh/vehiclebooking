package vn.gmobile.vehiclebooking.message;

import vn.gmobile.vehiclebooking.conf.JsParams;


public class ReportGetResponse extends JsonResponse {
	
	public ReportGetResponse() {
	}
	
	public void setUrl(String url) throws Exception {
		write(JsParams.GET_REPORT_RESPONSE.URL, url);
	}
}
