Ext.define('MyApp.view.main.Tree', {
    extend: 'Ext.tree.Panel',
    alias : 'widget.MenuTree',
        
    listeners: {
    	
        itemclick: function(s,r) {
        	
        	if(r.data.aliasComponent != undefined){
        		
//        			var controllerNames = r.data.controllerComponent.split(',');
//        			var arrayLength = controllerNames.length;
//        	    	
//        			if(arrayLength === 0){
//        				var controllerName = r.data.controllerComponent;
//        				var iController = managerControllers.get(controllerName);
//            		   	
//	       		   	     // If the controller was never loaded before
//	       		   	     if ( !iController )
//	       		   	     {    
//         		   	        // Dynamically load the controller
//         		   	    	var iController = managerApp.getController(controllerName);
//	       		   	     }
//        				
//        			}else{
//        				
//        				//Agregamos los controles dinamicamente
//            	    	for (var i = 0; i < arrayLength; i++) {
//            	    		 // See if the controller was already loaded
//            		   	     var iController = managerControllers.get(controllerNames[i]);
//            		   	
//            		   	     // If the controller was never loaded before
//            		   	     if ( !iController )
//            		   	     {    
//            		   	        // Dynamically load the controller
//            		   	    	var iController = managerApp.getController(controllerNames[i]);
//            		   	     }
//            		   	     
//            	    	}
//        				
//        			}
        			
        			Ext.getCmp('center').removeAll(true,true);
	   		   	    var component = r.data.aliasComponent;
	   		   	    Ext.getCmp('center').add({xtype:component});

        	}    
        }
    },

    initComponent: function() {
        Ext.apply(this, {
            store: new Ext.data.TreeStore({
            	
            	proxy: {
                    type: 'ajax',
                    url:  '/SeguridadWSRestApp/api/seguridad/funcionalidadPorIdSession'
                },
                root: {
                    text: 'Opciones Disponibles',
                    id: 'src',
                    expanded: true
                },
            	
                folderSort: false,
                sorters: [{
                    property: 'text',
                    direction: 'DESC'
                }],
                listeners:{
                	'beforeload': function(n) 
                    {
                        this.getProxy().extraParams = {id_session: localStorage.getItem('id_session')};
                    }
                }
            }),
            viewConfig: {
                plugins: {
                    ptype: 'treeviewdragdrop',
                    containerScroll: true
                }
            },
            tbar: [{
                text: 'Expandir',
                scope: this,
                iconCls:'fa fa-plus-square',
                handler: this.onExpandAllClick
            }, {
                text: 'Colapsar',
                scope: this,
                iconCls:'fa fa-minus-square-o',
                handler: this.onCollapseAllClick
            }]
        });
        this.callParent();
    },

    onExpandAllClick: function(){
        var me = this,
            toolbar = me.down('toolbar');

        me.getEl().mask('Expanding tree...');
        toolbar.disable();

        this.expandAll(function() {
            me.getEl().unmask();
            toolbar.enable();
        });
    },

    onCollapseAllClick: function(){
        var toolbar = this.down('toolbar');

        toolbar.disable();
        this.collapseAll(function() {
            toolbar.enable();
        });
    }
});