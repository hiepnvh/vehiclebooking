package vn.gmobile.vehiclebooking.conf;



public class JsParams {

	public static class GENERAL_REQUEST {
		public static final String USER_ID = "user_id";
		public static final String WEBAPP_ID = "webapp_id";
	}

	public static class GENERAL_RESPONSE {
		public static final String SUCCESS = "success";
		public static final String INFO = "info";
		public static final String ERR_CODE = "err_code";
	}

	public static class GET_USER_REQUEST extends GENERAL_REQUEST {
		public static final String USERNAME = "username";
		public static final String PROFILE_ID = "profile_id";
		public static final String START = "start";
		public static final String LIMIT = "limit";
	}

	public static class GET_USER_RESPONSE extends GENERAL_RESPONSE {
		public static final String USER_LIST = "user_list";
		public static final String PROFILE_LIST = "profile_list";
		public static final String FUNCTION_LIST = "function_list";
		public static final String TOTAL_COUNT = "totalCount";

	}

	public static class GET_FUNCTION_REQUEST extends GENERAL_REQUEST {
		public static final String PROFILE_ID = "profile_id";
	}

	public static class GET_FUNCTION_RESPONSE extends GENERAL_RESPONSE {
		public static final String FUNCTION_LIST = "function_list";
	}

	public static class UPDATE_USER_REQUEST extends GENERAL_REQUEST {
		public static final String USER = "user";
	}

	public static class UPDATE_USER_RESPONSE extends GENERAL_RESPONSE {

	}

	public static class GET_PROFILE_REQUEST extends GENERAL_REQUEST {
		public static final String PROFILE_ID = "profile_id";
	}

	public static class GET_PROFILE_RESPONSE extends GENERAL_RESPONSE {
		public static final String PROFILE_LIST = "profile_list";
	}

	public static class LOGIN_REQUEST {
		public static final String USERNAME = "username";
		public static final String PASWORD = "password";

	}

	public static class LOGIN_RESPONSE extends GENERAL_RESPONSE {
		public static final String USER = "user";
		public static final String FUNCTION_LIST = "function_list";
		public static final String PROFILE = "profile";
	}

	public static class UPDATE_PROFILE_REQUEST extends GENERAL_REQUEST {
		public static final String FUNCTION_LIST = "function_list";
		public static final String PROFILE = "profile";
	}

	public static class UPDATE_PROFILE_RESPONSE extends GENERAL_RESPONSE {

	}

	/* ####################################################################3 */

	public static class OTP_GET_REQUEST extends GENERAL_REQUEST {
		public static final String USERNAME = "username";
	}

	public static class OTP_GET_RESPONSE extends GENERAL_RESPONSE {
		public static final String OTP = "otp";
	}

	public static class FILE_GET_REQUEST extends GENERAL_REQUEST {
		public static final String USERNAME = "username";
	}

	public static class FILE_GET_RESPONSE extends GENERAL_RESPONSE {
		public static final String FILE_LIST = "file_list";
	}

	public static class FILE_DOWNLOAD_REQUEST extends GENERAL_REQUEST {
		public static final String USERNAME = "username";
		public static final String FILENAME = "filename";
	}

	public static class FILE_DOWNLOAD_RESPONSE extends GENERAL_RESPONSE {
	}

	public static class RECHARGE_HISTORY_GET_REQUEST extends GENERAL_REQUEST {
		public static final String MSISDN = "msisdn";
		public static final String AMOUNT = "amount";
		public static final String DATE = "date";
	}

	public static class RECHARGE_HISTORY_GET_RESPONSE extends GENERAL_RESPONSE {
		public static final String RESULT = "result";
	}

	public static class VEHICLE_BOOKING extends GENERAL_REQUEST {
		public static final String REQUESTER = "requester";
		public static final String LIMIT = "limit";
		public static final String START = "start";
	}

	public static class VEHICLE_BOOKING_RESPONSE extends GENERAL_RESPONSE {
		public static final String RESULT_LIST = "result_list";
		public static final String RESULTS = "results";
	}

	public static class SMS_TASK_GET_REQUEST extends GENERAL_REQUEST {
		public static final String FROM_DATE = "from_date";
		public static final String TO_DATE = "to_date";
		public static final String TASK_ID = "task_id";
		public static final String TASK_STATUS = "task_status";
	}

	public static class SMS_TASK_GET_RESPONSE extends GENERAL_RESPONSE {
		public static final String TASK_LIST = "task_list";
	}
	
	public static class SMS_TASK_UPDATE_REQUEST extends GENERAL_REQUEST {
		public static final String TASK = "task";
	}
	public static class GET_REPORT_RESPONSE extends GENERAL_RESPONSE{
		public static final String URL = "url";
	}

	public static class SMS_TASK__UPDATE_RESPONSE extends GENERAL_RESPONSE {
	}
	/*USER LOGIN INFO*/
	public static class USER_LOGIN_INFO_GET_REQUEST extends GENERAL_REQUEST  {
		public static final String USERNAME = "userName";
		public static final String DISPLAYNAME = "displayName";
		public static final String MOBILE = "mobile";
		public static final String MAIL = "mail";
	}
}
