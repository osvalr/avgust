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
			                      text:'Characters',
			                      iconCls:'icon-group',
			                      aliasComponent:'CharacterList',
			                      leaf:true
		                      },
		                      {
		                      	  text:'Server Info',
		                      	  iconCls:'icon-information',
		                      	  aliasComponent:'ServerInfo',
		                      	  leaf:true
		                      },
		                      {
		                      	  text:'Statistic',
		                      	  iconCls:'icon-chart_bar',
		                      	  children:[
												{
													  text:'Characters Ranking',
													  iconCls:'icon-award_star_gold_3',
													  aliasComponent:'CharactersForResetsList',
													  leaf:true
												},
												{
													  text:'Guilds Ranking',
													  iconCls:'icon-shield_silver',
													  aliasComponent:'GuildsForScoreList',
													  leaf:true
												},
												{
													  text:'Characters Online',
													  iconCls:'icon-world_connect',
													  aliasComponent:'CharactersOnlineList',
													  leaf:true
												}
		                      	          ]
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
            },
            tbar: [{
                text: 'Sign Up',
                scope: this,
                iconCls:'icon-user_add',
                handler: function (){
                	var edit = Ext.create('MyApp.view.MttoMembInfo.Edit').show();
                	edit.setTitle('Sign Up');
                }
            },
            '-', {
                text: 'Sign In',
                scope: this,
                iconCls:'icon-door_in',
                handler: function (){
                	Ext.create('MyApp.view.login.Login').show();
                }
            },
            '-',
            {
                text: 'Log Out',
                scope: this,
                iconCls:'icon-door_out',
                handler: function(){
                    Ext.Msg.confirm('Confirmar','Are you sure to continue?',function (btn) {
                        
                        if (btn == 'yes') {
                        	
                        	Ext.Ajax.request({
                        	    url: '/MuWSRestApp/api/Autenticacion/logOut',
                        	    params: {
                        	    	id_session: localStorage.getItem('id_session')
                        	    },
                        	    success: function(response){
                        	    	Ext.getCmp('center').removeAll(true,true);
                        	    	Ext.getCmp('center').add({xtype:'ServerInfo'});
                        	    }
                        	});
                        	
                        }
                    });
                }
            }]
        });
        this.callParent();
    }
});