package vn.gmobile.vehiclebooking.conf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bean.base.BeanFilter;

import vn.gmobile.vehiclebooking.db.DbAdapter;
import vn.gmobile.vehiclebooking.model.SystemParam;



public class SystemParamGroup {
	private static Map<String,String> SYSTEM_PARAMS;
	static {
		try {
			SYSTEM_PARAMS =  new HashMap<String,String>();
			DbAdapter dba = new DbAdapter();
			BeanFilter paramFilter = new BeanFilter(SystemParam.class); 
			List<SystemParam> params =  dba.getBeans(paramFilter);
			for (SystemParam param: params) {
				SYSTEM_PARAMS.put(param.get(SystemParam.NAME),param.get(SystemParam.VALUE));
			}

			dba.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static final String DEFAULT_PASSWORD = SYSTEM_PARAMS.get("DEFAULT_PASSWORD");
	// PROCESS_DEFINITION_KEY ~ PROCESS_ID
	public static final String PROCESS_ID = SYSTEM_PARAMS.get("PROCESS_ID");
	public static final String SMS_GMOBILE_SUFFIX = SYSTEM_PARAMS.get("SMS_GMOBILE_SUFFIX");
}
