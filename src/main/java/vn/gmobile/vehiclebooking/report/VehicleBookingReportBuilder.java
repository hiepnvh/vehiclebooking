package vn.gmobile.vehiclebooking.report;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Logger;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import com.base.filter.Filter;
import com.base.filter.StringEqualFilter;
import com.bean.base.BeanFilter;

import vn.gmobile.vehiclebooking.db.VehicleBookingRecordDAO;
import vn.gmobile.vehiclebooking.model.VehicleBookingRecord;

public class VehicleBookingReportBuilder extends ReportBuilder {
	
	String _requester;
	
	public VehicleBookingReportBuilder(String _requester) {
		this._requester = _requester;
	}

	protected static final Logger LOGGER = Logger.getLogger(VehicleBookingReportBuilder.class.getName());

	@Override
	protected JRDataSource createDataSource() {
		try {
			
			BeanFilter _emFilter = new BeanFilter(VehicleBookingRecord.class);
			if (_requester!=null)
			
			_emFilter.setFilter(VehicleBookingRecord.REQUESTER, new StringEqualFilter(_requester));
			
			VehicleBookingRecordDAO dao = new VehicleBookingRecordDAO();
			List<VehicleBookingRecord> emRCs = dao.getBean(_emFilter);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			List<Data> dataList = new ArrayList<Data>();
			
			for(VehicleBookingRecord emRC : emRCs){
								
				Data data = new Data();
				
				data.requester = emRC.get(VehicleBookingRecord.REQUESTER);
				data.purpose = emRC.get(VehicleBookingRecord.PURPOSE);
				data.start_time = sdf.format(emRC.get(VehicleBookingRecord.START_TIME));
				data.end_time = sdf.format(emRC.get(VehicleBookingRecord.END_TIME));
				data.note = emRC.get(VehicleBookingRecord.NOTE);
				data.vehicle_type = emRC.get(VehicleBookingRecord.VEHICLE_TYPE);
				data.vehicle_number = emRC.get(VehicleBookingRecord.VEHICLE_NUMBER);
				data.vehicle_contact_info = emRC.get(VehicleBookingRecord.VEHICLE_CONTACT_INFO);
				data.actual_end_time = sdf.format(emRC.get(VehicleBookingRecord.ACTUAL_END_TIME));
				data.actual_start_time = sdf.format(emRC.get(VehicleBookingRecord.ACTUAL_START_TIME));
				data.actual_extra_fee = emRC.get(VehicleBookingRecord.ACTUAL_EXTRA_FEE);
				data.actual_extra_justification = emRC.get(VehicleBookingRecord.ACTUAL_EXTRA_JUSTIFICATION);
				data.actual_extra_justification = emRC.get(VehicleBookingRecord.ACTUAL_EXTRA_JUSTIFICATION);
				data.driver_name = emRC.get(VehicleBookingRecord.DRIVER_NAME);


				dataList.add(data);
			}
			
			return new JRBeanCollectionDataSource(dataList);
		} catch (Exception exc) {
			exc.printStackTrace();
			return null;
		}
	}

	public class Data {
		private String requester;
		private String purpose;
		private String employee_name;
		private String start_time;
		private String end_time;
		private String note;
		
		private String vehicle_type;
		private String actual_start_time;
		private String actual_end_time;
		
		private Double actual_extra_fee;
		private String actual_extra_justification;
		private String vehicle_number;
		
		private String vehicle_contact_info;
		
		private String driver_name;

		public String getDriver_name() {
			return driver_name;
		}

		public void setDriver_name(String driver_name) {
			this.driver_name = driver_name;
		}

		public String getRequester() {
			return requester;
		}

		public void setRequester(String requester) {
			this.requester = requester;
		}

		public String getPurpose() {
			return purpose;
		}

		public void setPurpose(String purpose) {
			this.purpose = purpose;
		}

		public String getEmployee_name() {
			return employee_name;
		}

		public void setEmployee_name(String employee_name) {
			this.employee_name = employee_name;
		}

		public String getStart_time() {
			return start_time;
		}

		public void setStart_time(String start_time) {
			this.start_time = start_time;
		}

		public String getEnd_time() {
			return end_time;
		}

		public void setEnd_time(String end_time) {
			this.end_time = end_time;
		}

		public String getNote() {
			return note;
		}

		public void setNote(String note) {
			this.note = note;
		}

		public String getVehicle_type() {
			return vehicle_type;
		}

		public void setVehicle_type(String vehicle_type) {
			this.vehicle_type = vehicle_type;
		}

		public String getActual_start_time() {
			return actual_start_time;
		}

		public void setActual_start_time(String actual_start_time) {
			this.actual_start_time = actual_start_time;
		}

		public String getActual_end_time() {
			return actual_end_time;
		}

		public void setActual_end_time(String actual_end_time) {
			this.actual_end_time = actual_end_time;
		}

		public Double getActual_extra_fee() {
			return actual_extra_fee;
		}

		public void setActual_extra_fee(Double actual_extra_fee) {
			this.actual_extra_fee = actual_extra_fee;
		}

		public String getActual_extra_justification() {
			return actual_extra_justification;
		}

		public void setActual_extra_justification(String actual_extra_justification) {
			this.actual_extra_justification = actual_extra_justification;
		}

		public String getVehicle_number() {
			return vehicle_number;
		}

		public void setVehicle_number(String vehicle_number) {
			this.vehicle_number = vehicle_number;
		}

		public String getVehicle_contact_info() {
			return vehicle_contact_info;
		}

		public void setVehicle_contact_info(String vehicle_contact_info) {
			this.vehicle_contact_info = vehicle_contact_info;
		}
		
		
	}
	
	@Override
	protected JasperReportBuilder buildReport() { 
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		DynamicReports.report();
		return  report()
				.setTemplate(ReportTemplates.reportTemplate)
				.ignorePagination()
				.ignorePageWidth()
				  .columns(
				  	col.column("Người yêu cầu", "requester", type.stringType()).setWidth(80),
				  	col.column("Khởi hành", "start_date", type.stringType()).setWidth(80),
				  	col.column("Kết thúc",   "end_date",  type.stringType()).setWidth(80),
				  	col.column("Mục đích", "purpose", type.stringType()).setWidth(100),
				  	col.column("Chú thích", "note", type.stringType()).setWidth(50),
				  	col.column("Loại xe", "vehicle_type", type.stringType()).setWidth(80),
				  	col.column("Biển số", "vehicle_number", type.stringType()).setWidth(80),
				  	col.column("Thông tin xe", "vehicle_contact_info", type.stringType()).setWidth(80),
				  	col.column("Lái xe", "driver_name", type.stringType()).setWidth(80),
				  	
				  	col.column("Khởi hành thực tế", "actual_start_time", type.stringType()).setWidth(100),
				  	col.column("Kết thúc thực tế", "actual_end_time", type.stringType()).setWidth(80),
				  	col.column("Chi phí", "actual_extra_fee", type.stringType()).setWidth(80),
				  	
				  	col.column("Diễn giải chi phí", "actual_extra_justification", type.stringType()).setWidth(50)
				  	)
				    .title(ReportTemplates.createTitleComponent("Báo cáo lịch trình đặt xe"));
	}
}