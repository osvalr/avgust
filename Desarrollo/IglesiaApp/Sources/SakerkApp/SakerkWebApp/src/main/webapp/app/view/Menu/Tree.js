Ext.define('MyApp.view.Menu.Tree', {
    extend: 'Ext.tree.Panel',
    alias : 'widget.MenuTree',

    requires: [
        'Ext.tree.*',
        'Ext.data.*'
    ],
    listeners: {
        itemclick: function(s,r) {
        	if(r.data.value != undefined){
        		Ext.getCmp('center').getLayout().setActiveItem(r.data.value);
        	}    
        }
    },

    initComponent: function() {
        Ext.apply(this, {
            store: new Ext.data.TreeStore({

                root: {
                    text: 'Modulos',
                    expanded: true,
                    iconCls:'application-detail',
                    children:[
                              {
		                        text:'Personas',
		                        iconCls:'folder-horizontal-open',
		                        children:[
		                          {
			                      	  text:'Persona Natural',
			                      	  iconCls:'application-form',
			                      	  value:'GestionarPersonaNaturalList',
			                      	  leaf:true
		                          },
		                          {
			                      	  text:'Persona Juridica',
			                      	  iconCls:'application-form',
			                      	  value:'GestionarPersonaJuridicaList',
			                      	  leaf:true
		                          }
		                        ]
                    		  },
                              {
  		                        text:'Generales',
  		                        iconCls:'folder-horizontal-open',
  		                        children:[
  		                          {
  			                      	  text:'Tabla General',
  			                      	  iconCls:'application-form',
  			                      	  value:'GestionarTablaGeneralList',
  			                      	  leaf:true
  		                          }
  		                        ]
                      		  },
                              {
    		                        text:'Congregaciones',
    		                        iconCls:'folder-horizontal-open',
    		                        children:[
    		                          {
    			                      	  text:'Congregación General',
    			                      	  iconCls:'application-form',
    			                      	  value:'GestionarCongregacionList',
    			                      	  leaf:true
    		                          },
    		                          {
    			                      	  text:'Congregacion Local',
    			                      	  iconCls:'application-form',
    			                      	  value:'GestionarCongregacionLocalList',
    			                      	  leaf:true
    		                          }
    		                        ]
                              },
                              {
    		                        text:'Academicos',
    		                        iconCls:'folder-horizontal-open',
    		                        children:[
    		                          {
    			                      	  text:'Estudios',
    			                      	  iconCls:'application-form',
    			                      	  value:'GestionarEstudioList',
    			                      	  leaf:true
    		                          }
    		                        ]
                        		  }
                    ]
                },
                folderSort: true,
                sorters: [{
                    property: 'text',
                    direction: 'ASC'
                }]
            }),
            viewConfig: {
                plugins: {
                    ptype: 'treeviewdragdrop',
                    containerScroll: true
                }
            },
            tbar: [{
                text: 'Expandir Todo',
                scope: this,
                handler: this.onExpandAllClick
            }, {
                text: 'Colapsar Todo',
                scope: this,
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