package vehiclebooking;

import java.text.Normalizer;
import java.util.List;

import org.joda.time.DateTime;

import com.bean.base.BeanFilter;

import vn.gmobile.vehiclebooking.conf.SystemParamGroup;
import vn.gmobile.vehiclebooking.db.DriverMobileDAO;
import vn.gmobile.vehiclebooking.db.VehicleDAO;
import vn.gmobile.vehiclebooking.model.Driver;
import vn.gmobile.vehiclebooking.model.DriverMobile;
import vn.gmobile.vehiclebooking.model.Vehicle;
import vn.gmobile.vehiclebooking.model.VehicleModel;
import vn.gmobile.vehiclebooking.util.DateTimeHelper;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		String _to ="hiep@gmobile.vnsms";
//		String to="";
////		String _to = execution.getVariable("to").toString();
//		if(_to.endsWith("sms"))
//			to = _to.replace("@gmobile.vnsms", SystemParamGroup.SMS_GMOBILE_SUFFIX);
//		
//		System.out.println(to);
//		DriverMobileDAO dao = new DriverMobileDAO();
//		BeanFilter filter = new BeanFilter(DriverMobile.class);
//		List<Driver> ds = dao.getBean(filter);
//		
//		VehicleDAO vDao = new VehicleDAO();
//	    BeanFilter vFilter = new BeanFilter(Vehicle.class);
//	    List<VehicleModel> vehicles = vDao.getBean(vFilter);
//	    
//	    for(VehicleModel d : vehicles)
//			System.out.println(d.getInfo());
//	    
//		for(Driver d : ds)
////			System.out.println(d.getName());
//		String s = "11/04/2016 18:20:39";
//		DateTime dt = new DateTime();
//		dt.plus(1).toDate();
//		DateTimeHelper h = new DateTimeHelper();
//		System.out.println(h.jodaDateToString(h.stringToJodaDate(s).plusDays(1)));
////		dateTimeHelper.stringToDate(str)
//		${dateTimeHelper.jodaDateToString(dateTimeHelper.stringToJodaDate(stopTime).plusDays(1))}
		
		String s = "Thông tin được gửi đến Email & SMS cho người YC sd xe (khi Quản lý trực tiếp ko phê duyệt xe)";
		System.out.println(stripAccents(s));
	}
	
	private static String stripAccents(String s) {
		
		// strip except 2 special accents in vietnamese
		s = Normalizer.normalize(s, Normalizer.Form.NFD);
	    s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
	    
	    // strip 2 special accents in vietnamese
	    s = s.replace('\u0111', 'd');
        s = s.replace('\u0110', 'd');
        
        // return string
        return s;
	}

}
