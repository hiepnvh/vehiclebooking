function convert_to_ShortDate(v, record){
	return v.substring(0, 10); 
}

function convert_to_ShortTime(v, record){
	return v.substring(0, 5); 
}

function convert_come_reason_id(v, record){
	return App.Constant.ReasonValue(v);
}

function convert_leave_reason_id(v, record){
	return App.Constant.ReasonValue(v);
}

Ext.define(App.path('model.EmployeeRecord'), {
    extend: 'Ext.data.Model',
    fields:[
//			'action_date',
			'requester',
			'purpose',
			'start_time',
			'end_time',
			'note',
			'vehicle_type',
			'vehicle_number',
			'driver_name',
			'vehicle_contact_info',
			'actual_start_time',
			'actual_end_time',
			
			'actual_extra_fee',
			'actual_extra_justification'
			]
});

