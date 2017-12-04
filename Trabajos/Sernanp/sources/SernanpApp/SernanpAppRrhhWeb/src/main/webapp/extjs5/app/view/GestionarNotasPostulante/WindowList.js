/**
* Copyright «©» 2015, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SernanpApp.
*
* SernanpApp is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SernanpApp is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SernanpApp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 20/04/2015 14:52:17
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarNotasPostulante.WindowList', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarNotasPostulanteWindowList',

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
//    closable: false,
    width: '50%',
    title:'Registro de Notas',

    glyph:'xf044@FontAwesome',
    
    bbar: [
           {
        	   glyph:'xf00d@FontAwesome',
               text: 'Cerrar',
               handler: function () { 
            	   this.up('.window').close();
            	   var store = Ext.getStore('GestionarPlaza.PostulantePlazaQueryStore');
            	   store.load({params: {srl_id_conv_area_org: null}});
               }
           }
       ],

    initComponent: function() {
        
    	this.items = [
                        {
                        	xtype:'GestionarNotasPostulanteList'
                        }
        ];
    	        
        this.callParent(arguments);      
    }
});
