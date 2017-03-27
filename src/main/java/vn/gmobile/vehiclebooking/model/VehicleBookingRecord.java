package vn.gmobile.vehiclebooking.model;

import java.util.Date;

import com.bean.annot.Attribute;
import com.bean.annot.Entity;
import com.bean.base.Bean;
import com.bean.base.BeanProperty;

@Entity(name = "vehicle_booking_record")
public class VehicleBookingRecord  extends Bean{
	
	@Attribute(name = "requester")
	public static final BeanProperty<String> REQUESTER =  BeanProperty.stringType();
	@Attribute(name = "start_time")
	public static final BeanProperty<Date> START_TIME = BeanProperty.dateType();
	@Attribute(name = "end_time")
	public static final BeanProperty<Date> END_TIME = BeanProperty.dateType();
	@Attribute(name = "purpose")
	public static final BeanProperty<String> PURPOSE =  BeanProperty.stringType();
	@Attribute(name = "note")
	public static final BeanProperty<String> NOTE =  BeanProperty.stringType();
	@Attribute(name = "vehicle_type")
	public static final BeanProperty<String> VEHICLE_TYPE =  BeanProperty.stringType();
	@Attribute(name = "vehicle_number")
	public static final BeanProperty<String> VEHICLE_NUMBER =  BeanProperty.stringType();
	@Attribute(name = "vehicle_contact_info")
	public static final BeanProperty<String> VEHICLE_CONTACT_INFO =  BeanProperty.stringType();
	@Attribute(name = "actual_start_time")
	public static final BeanProperty<Date> ACTUAL_START_TIME = BeanProperty.dateType();
	@Attribute(name = "actual_end_time")
	public static final BeanProperty<Date>  ACTUAL_END_TIME = BeanProperty.dateType();
	@Attribute(name = "actual_extra_fee")
	public static final BeanProperty<Double>  ACTUAL_EXTRA_FEE =  BeanProperty.doubleType();
	@Attribute(name = "actual_extra_justification")
	public static final BeanProperty<String>  ACTUAL_EXTRA_JUSTIFICATION =  BeanProperty.stringType();
	@Attribute(name = "driver_name")
	public static final BeanProperty<String>  DRIVER_NAME =  BeanProperty.stringType();
	
}

