Ext.define(App.path('view.ViewEmployeeLate'), {
			extend : 'Ext.grid.Panel',
			border : false,
			itemId : 'ViewEmployeeLate',
			xtype : 'ViewEmployeeLate',
			id : 'ViewEmployeeLate',
			autoScroll : true,
			initComponent : function(arguments) {
				var store = Ext.getStore(App.path('store.EmployeeRecord'));
				var date = null;
//				var status = null;
				var me = this;
				Ext.apply(this, {
							border : false,
							store : store,
							stripeRows : true,
							columnLines : true,
							columns : [{
										text : 'STT',
										xtype : 'rownumberer',
										width : 30
									}, {
										text : 'Người yêu cầu',
										flex : 1.5,
										sortable : true,
										name:'requester',
										dataIndex : 'requester'
									}, {
										text : 'Khởi hành',
										flex : 1.5,
										sortable : true,
										name:'start_time',
										dataIndex : 'start_time'
									}, {
										text : 'Kết thúc',
										flex : 1.5,
										sortable : true,
										name:'end_time',
										dataIndex : 'end_time'
								}, {
									text : 'Mục đích',
									flex : 2,
									sortable : true,
									name:'purpose',
									dataIndex : 'purpose'
								}, {
									text : 'Chú thích',
								flex : 2,
								sortable : true,
								name:'note',
								dataIndex : 'note'
								}, {
									text : 'Loại xe',
									flex : 1,
									sortable : true,
									name:'vehicle_type',
									dataIndex : 'vehicle_type'
								}, {
									text : 'Biển số',
									flex : 1,
									sortable : true,
									name:'vehicle_number',
									dataIndex : 'vehicle_number'
								}, {
									text : 'Lái xe',
									flex : 1,
									sortable : true,
									name:'driver_name',
									dataIndex : 'driver_name'
								}, {
									text : 'Thông tin xe',
									flex : 2,
									sortable : true,
									name:'vehicle_contact_info',
									dataIndex : 'vehicle_contact_info'
								}, {
									text : 'Khởi hành thực tế',
									flex : 1.5,
									sortable : true,
									name:'actual_start_time',
									dataIndex : 'actual_start_time'
								}, {
							         text : 'Kết thúc thực tế',
							         flex : 1.5,
							         sortable : true,
							         name:'actual_end_time',
							         dataIndex : 'actual_end_time'
							    }, {
							         text : 'Chi phí',
							         flex : 1.5,
							         sortable : true,
							         name:'actual_extra_fee',
							         dataIndex : 'actual_extra_fee'
							     }, {
								         text : 'Diễn giải chi phí',
								         flex : 1.5,
								         sortable : true,
								         name:'actual_extra_justification',
								         dataIndex : 'actual_extra_justification'
								 }
								], dockedItems: [{
	                    dock: 'bottom',
                    height: 50,
                    border: false,
                    bodyStyle: 'background-color: transparent',
                    items: [{
                            xtype: 'button',
                            text: 'Xuất báo cáo',
                            itemId: 'buttonExport',
                            handler: function() {
                                me.exportXls();
                            }
                        }]
                }],bbar: Ext.create('Ext.PagingToolbar', {
					                store: store,
					                displayInfo: true,
					                pageSize: App.Constant.myPageSize,
					                displayMsg: '',
					                emptyMsg: "Không có dữ liệu để hiển thị"
					        })
						});
				this.callParent(arguments);
			},listeners: {
				cellclick: function(selModel, record, index, options){
//    			this.choosenMsisdn = this.getSelectionModel().getSelection()[0].data.msisdn;
//    			this.choosenLimit = this.getSelectionModel().getSelection()[0].data.new_limit;
//    			var status = this.getSelectionModel().getSelection()[0].data.status;
    			
    		}
    
			},
			activate : function(requester) {
				console.log('ss');
				var me = this;
				Ext.get(document.body).unmask();

				var store = this.getStore();
//				console.log(store);
				var user_id = App.Session.user_id;
				store.removeAll();
				
				store.setProxy({
					type : 'ajax',
					url : 'getvehiclebookingrecords',
					actionMethods : {
						create : 'POST',
						read : 'POST',
						update : 'POST',
						destroy : 'POST'
					},
					extraParams : {
//						user_id : user_id,
						requester: requester
					},
					reader : {
						type : 'json',
						root : 'result_list',
						totalProperty : 'results'
					}
				});
				store.load({
					params:{
				        start:0,
				        limit: App.Constant.myPageSize
				    },
					callback : function(records, options, success){
						if (success) {
							Ext.get(document.body).unmask();
//							response = Ext.decode(response.responseText);
//							console.log(response.user.username);
//							App.Session.setUsername(response.user.username);
//	                        App.Session.setName(response.user.displayname);
////	                        App.Session.setPassword(response.user.password);
//	                        App.Session.setFunctionlist(response.function_list);
						}
					}
				});
//				this.down('#buttonExport').setDisabled(true);
//				this.down('#buttonEdit').setDisabled(true);
				for(var i=0;i<App.Session.functionlist.length;i++) {
					this.FunctionMap(App.Session.functionlist[i].function_id);
				}
			},
			FunctionMap : function(itemId) {
//				console.log(itemId);
				switch(itemId)
				{
//					case 11 : this.down('#buttonExport').setDisabled(false); break;
//					case 12 : this.down('#buttonExport').setDisabled(false); break;
//					case 22 : this.down('#buttonExport').setDisabled(false); break;
//					case 21 : this.ShowBoolean('lookupmsisdn',true);  break;
				}
			},
			FunctionMapForEditBtn : function(itemId,status) {
				console.log(itemId);
				console.log(status);
				if(status=='pending'){
					switch(itemId)
					{
						case 11 : this.down('#buttonEdit').setDisabled(false); break;
						case 12 : this.down('#buttonEdit').setDisabled(false); break;
						case 22 : this.down('#buttonEdit').setDisabled(false); break;
					}
				}
				else
					this.down('#buttonEdit').setDisabled(true);
			},
			exportXls : function(){
				Ext.get(document.body).mask('Chờ giây lát..');
				var me = this;
				var user_id = App.Session.user_id;
				var start_date = this.start_date;
				var end_date = this.end_date;
				
				Ext.Ajax.request({
					url : 'getreport',
					actionMethods : {
					create : 'POST',
					read : 'POST',
					update : 'POST',
					destroy : 'POST'
					},
					params : {
						user_id : user_id,
						start_date: App.ActionMe.DateToDBExactly(start_date),
						end_date: App.ActionMe.DateToDBExactly(end_date)
					},
					scope : this,
					timeout : 60000,
					callback : function(options, success, response) {
						if (success) {
							Ext.get(document.body).unmask();
							response = Ext.decode(response.responseText);
							console.log(response.url);
							if (response.success) {
								//Download
								var hiddenIFrameID = 'hiddenDownloader',
						        iframe = document.getElementById(hiddenIFrameID);
							    if (iframe === null) {
							        iframe = document.createElement('iframe');
							        iframe.id = hiddenIFrameID;
							        iframe.style.display = 'none';
							        document.body.appendChild(iframe);
							    }
							    iframe.src = response.url;
							} else {
								Ext.MessageBox.alert('Thông báo',
										'Tải file thất bại '+ response.info);
							}
						} else {
							Ext.get(document.body).unmask();
							Ext.MessageBox.alert('Thông báo',
									'Tải file thất bại. Vui lòng thử sau '+ response.info);
						}
					}
				
				});
				},
				renderDate : function (value){
				    return Date.parseDate(value,"Y-m-d h:i:s").format('d.m.Y H:i:s');
				} 
		});
