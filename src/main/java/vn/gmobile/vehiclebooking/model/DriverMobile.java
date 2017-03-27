package vn.gmobile.vehiclebooking.model;

import com.bean.annot.*;
import com.bean.base.Bean;
import com.bean.base.BeanProperty;



@Entity(name = "driver_mobile")
public class DriverMobile extends Bean {
	@Attribute(name = "name")
	public static final BeanProperty<String> NAME =  BeanProperty.stringType();
//	@Attribute(name = "car_number")
//	public static final BeanProperty<String> CAR_NUMBER =  BeanProperty.stringType();
	@Attribute(name = "mobile")
	public static final BeanProperty<String> MOBILE =  BeanProperty.stringType();
	
}
