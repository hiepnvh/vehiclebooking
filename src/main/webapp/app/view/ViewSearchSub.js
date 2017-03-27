Ext.define(App.path('view.ViewSearchSub'), {
	extend : 'Ext.form.Panel',
	itemId : 'ViewSearchSub',
	bodyStyle : 'background-color: transparent',
	border : false,
	layout : 'fit',
	config : {
		record : null,
		fieldDefaults : {
			margin : '5'
		},
		items : [{
			region : 'center',
			border : false,
			items : [{
				border : false,
				items : [{
							border : false,
							layout : 'hbox',
							defaultType : 'textfield',
							items : [{
										flex : 1,
										itemId : 'user_id',
										hidden : true
									}]
						},{
							border : false,
							layout : 'hbox',
							defaultType : 'textfield',
							items : [{
								flex : 1,
								xtype : 'textfield',
								itemId : 'requester',
								fieldLabel : 'Người yêu cầu'
							}]
						}]
			}]
		}],
		buttons : [{
					text : 'Search',
					handler : function() {
						var form = this.up('form');
						form.Search();
					}
				}]
	},
	activate : function() {
		Ext.get(document.body).mask('Chờ giây lát..');
		var me = this;
		
//		var data = me.record.data;
		
//		this.down('#user_id').setValue(data.user_id);
//		this.down('#number').setValue(data.active);
//		this.down('#content').setValue(data.profile_id);
//		this.down('#subscriber').setValue(data.username);

		Ext.get(document.body).unmask();
	},
	Search : function() {
		Ext.get(document.body).mask('Chờ giây lát..');
		var me = this;
		var requester = this.down('#requester').getValue();
		
		var view_center = Ext.getCmp('CenterView');
		view_center.activateViewItem('ViewEmployeeLate', function() {
					var viewItem = Ext.create(App
							.path('view.ViewEmployeeLate'));
					return viewItem;
				}).activate(requester);

	}
});