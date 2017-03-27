package vn.gmobile.vehiclebooking.db;

import java.util.ArrayList;
import java.util.List;

import vn.gmobile.vehiclebooking.model.Driver;
import vn.gmobile.vehiclebooking.model.DriverMobile;

import com.bean.base.BeanFilter;

public class DriverMobileDAO {

	public List<Driver> getBean(BeanFilter filter) throws Exception {
		DbAdapter dba = new DbAdapter();
		List<DriverMobile> beans = dba.getBeans(filter);
		List<Driver> drivers = new ArrayList<Driver>();
		for(DriverMobile dm : beans){
			Driver d = new Driver();
			d.setName(dm.get(DriverMobile.NAME));
			d.setMobile(dm.get(DriverMobile.MOBILE));
			drivers.add(d);
		}
		dba.close();
		return drivers;
	}
	
	public void update(DriverMobile e) throws Exception {
		DbAdapter dba = new DbAdapter();
		dba.processBeans(e);
		dba.close();
	}
	
	public void update(List<DriverMobile> list) throws Exception {
		DbAdapter dba = new DbAdapter();
		dba.processBeans(list);
		dba.close();
	}
	
}
