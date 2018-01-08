Ext.define('MyApp.view.main.Tree', {
    extend: 'Ext.tree.Panel',
    alias : 'widget.MenuTree',
    controller: 'main', 
    listeners: {
    	
        itemclick: function(s,r) {
        	
        	if(r.data.aliasComponent != undefined){
        		        			
        			Ext.getCmp('center').removeAll(true,true);
	   		   	    var component = r.data.aliasComponent;
	   		   	    Ext.getCmp('center').add({xtype:component});

        	}    
        }
    },

    initComponent: function() {
        Ext.apply(this, {
            store: new Ext.data.TreeStore({
            	
                root: {
                    text: 'General options',
                    expanded: true,
                    iconCls:'icon-cog',
                    children:[
                              {
			                      text:'Facturas',
			                      iconCls:'icon-group',
			                      aliasComponent:'GestionarFacturaElectronicaList',
			                      leaf:true
		                      },
		                      {
		                      	  text:'Boletas',
		                      	  iconCls:'icon-information',
		                      	  aliasComponent:'GestionarBoletaElectronicaList',
		                      	  leaf:true
		                      }
                              
                    ]
                },                sorters: [{
                    property: 'text',
                    direction: 'ASC'
                }]
            }),
            viewConfig: {
                plugins: {
                    ptype: 'treeviewdragdrop',
                    containerScroll: true
                }
            }

        });
        this.callParent();
    }
});