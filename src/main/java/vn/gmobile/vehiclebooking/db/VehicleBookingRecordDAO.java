package vn.gmobile.vehiclebooking.db;

import java.util.List;

import vn.gmobile.vehiclebooking.model.VehicleBookingRecord;

import com.bean.base.BeanFilter;

public class VehicleBookingRecordDAO {

	public List<VehicleBookingRecord> getBean(BeanFilter filter) throws Exception {
		DbAdapter dba = new DbAdapter();
		List<VehicleBookingRecord> beans = dba.getBeans(filter);
		dba.close();
		return beans;
	}
	
	public void update(VehicleBookingRecord e) throws Exception {
		DbAdapter dba = new DbAdapter();
		dba.processBeans(e);
		dba.close();
	}
	
	public void update(List<VehicleBookingRecord> list) throws Exception {
		DbAdapter dba = new DbAdapter();
		dba.processBeans(list);
		dba.close();
	}
	
}
