Ext.define(App.path('controller.Home'), {
    extend: 'Ext.app.Controller',
    refs: [{
            ref: 'MainView',
            selector: '#MainView' //  id:MainView 

        },{
            ref: 'WestView',
            selector: '#west' //  id:west 

        }],
    init: function() {
        this.control({
//            Quản trị hệ thống // Controller User, Profile
        	'#user' : {click: this.onMenuSimClick},
        	'#profile' : {click: this.onMenuSimClick},
			
			'#changelimit' : {click: this.onMenuSimClick},
			'#msghistory':{click: this.onMenuSimClick},
        	'#employeelate':{click: this.onMenuSimClick},
            '#userinformation' : {click: this.onMenuSimClick},
            '#changepassword' : {click: this.onMenuSimClick}
        });
    },
    onMenuSimClick: function(btn) {

        Ext.Router.redirect(btn.itemId === 'home' ? 'home' : btn.itemId);

    },
    
    showHome: function() {
        if (App.Session.isLoggedIn()) {
            this.getMainView().activateViewItem('ViewIndex100', function() {
             var viewItem = Ext.create(App.path('view.ViewIndex100'));
             viewItem.activate();
                return viewItem;
            }, this,function(viewItem){
//    viewItem.activate();
   }).showWhat('ViewBlank', App.path('view.ViewBlank'));
        } else {
            Ext.Router.redirect('');
        }
    }
});