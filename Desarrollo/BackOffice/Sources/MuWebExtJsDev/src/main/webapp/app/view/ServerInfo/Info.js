Ext.define('MyApp.view.ServerInfo.Info', {
    extend: 'Ext.panel.Panel',
    xtype: 'ServerInfo',

    requires: [
               'MyApp.view.ServerInfo.GameServerList',
               'MyApp.view.ServerInfo.ResetInfoList',
               'MyApp.view.Statistic.CharactersOnlineList'
           ],
    
    title: 'Server Info',
    iconCls:'icon-information',
    initComponent: function () {
        this.items = [
            {
                xtype:'GameServerList'
            },
            {
                xtype:'ResetInfoList'
            },
            {
                xtype:'CharactersOnlineList'
            }
        ];

        this.callParent();
        this.on('render', this.hideLoader, this);
    },
    hideLoader: function() {
        if (Ext.get('page-loader')) {
            Ext.get('page-loader').remove();
        }
    }
    
});