Ext.define('MyApp.view.main.Tree', {
    extend: 'Ext.tree.Panel',
    alias : 'widget.MenuTree',
        
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
            	
            	proxy: {
                    type: 'ajax',
                    url: hostAcmeCommonWebApp + '/api/seguridad/funcionalidadPorIdSession'
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
                iconCls:'icon-bullet_toggle_plus',
                handler: this.onExpandAllClick
            }, {
                text: 'Colapsar',
                scope: this,
                iconCls:'icon-bullet_toggle_minus',
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