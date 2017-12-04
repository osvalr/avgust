/**
 * Created by JRaffo on 11/3/15.
 */
Ext.define('AcmeWebApp.view.menu.Tree', {
    extend: 'Ext.tree.Panel',
    alias : 'widget.MenuTree',

    requires: [
        'Ext.tree.*',
        'Ext.data.*'
    ],
    listeners: {
        itemclick: function(s,r) {
            /*if(r.data.value != undefined){
                Ext.getCmp('center').getLayout().setActiveItem(r.data.value);
            }*/
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
                            //iconCls:'folder-horizontal-open',
                            children:[
                                {
                                    text:'Productos',
                                    //iconCls:'application-form',
                                    //value:'GestionarPersonaNaturalList',
                                    leaf:true
                                },
                                {
                                    text:'Otros',
                                    //iconCls:'application-form',
                                    //value:'GestionarPersonaJuridicaList',
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