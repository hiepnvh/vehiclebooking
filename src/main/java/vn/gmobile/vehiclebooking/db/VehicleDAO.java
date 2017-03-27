package vn.gmobile.vehiclebooking.db;

import java.util.ArrayList;
import java.util.List;

import vn.gmobile.vehiclebooking.model.Vehicle;
import vn.gmobile.vehiclebooking.model.VehicleModel;

import com.bean.base.BeanFilter;

public class VehicleDAO {

	public List<VehicleModel> getBean(BeanFilter filter) throws Exception {
		DbAdapter dba = new DbAdapter();
		List<Vehicle> beans = dba.getBeans(filter);
		List<VehicleModel> drivers = new ArrayList<VehicleModel>();
		for(Vehicle dm : beans){
			VehicleModel d = new VehicleModel();
			d.setId(dm.get(Vehicle.ID));
			d.setNumber(dm.get(Vehicle.NUMBER));
			d.setInfo(dm.get(Vehicle.INFO));
			drivers.add(d);
		}
		dba.close();
		return drivers;
	}
	
	public void update(Vehicle e) throws Exception {
		DbAdapter dba = new DbAdapter();
		dba.processBeans(e);
		dba.close();
	}
	
	public void update(List<Vehicle> list) throws Exception {
		DbAdapter dba = new DbAdapter();
		dba.processBeans(list);
		dba.close();
	}
	
}
