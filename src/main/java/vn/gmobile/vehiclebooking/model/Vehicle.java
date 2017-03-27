package vn.gmobile.vehiclebooking.model;

import com.bean.annot.*;
import com.bean.base.Bean;
import com.bean.base.BeanProperty;



@Entity(name = "vehicle")
public class Vehicle extends Bean {
	@ExternalKey
	@Attribute(name = "id")
	public static final BeanProperty<Integer> ID =  BeanProperty.integerType();
	@Attribute(name = "number")
	public static final BeanProperty<String> NUMBER =  BeanProperty.stringType();
	@Attribute(name = "info")
	public static final BeanProperty<String> INFO =  BeanProperty.stringType();
	
}
