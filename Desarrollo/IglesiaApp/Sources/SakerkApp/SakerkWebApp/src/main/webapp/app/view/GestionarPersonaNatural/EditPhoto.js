/**
* Copyright «©» 2014, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SakerkApp.
*
* SakerkApp is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SakerkApp is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SakerkApp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 03/12/2014 03:40:10
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarPersonaNatural.EditPhoto', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarPersonaNaturalEditPhoto',

    requires: ['Ext.form.Panel'],

    title : 'Fotografia',
    layout: 'fit',
    autoShow: false,
    closable:false,
    modal: true,
    floating: true,
    width: '400px',
    glyph:'xf083@FontAwesome',

    initComponent: function() {
        this.items = [
                      {
                
		                xtype: 'form',
		                id:'form_photo',
		                padding: '5 5 0 5',
		                border: false,
		                style: 'background-color: #fff;',
		                
		                fieldDefaults: {
		                    anchor: '100%',
		                    labelAlign: 'left',
		                    allowBlank: false,
		                    combineErrors: true,
		                    msgTarget: 'side'
		                },
		
				        items: [
									{
										xtype: 'filefield',
										emptyText: 'Seleccione una imagen',
										vtype:'fileUpload',
//										allowBlank: true,
										fieldLabel: 'Foto',
										name: 'file',
										buttonConfig: {
											glyph: 'xf03e@FontAwesome'
										}
									},
									{
										xtype: 'hidden',
										name: 'fileNameSession',
										value: 'PHOTO_PERSONA_NATURAL',
										hide : true
									}
				        ]
                      }
            ];
        this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'bottom',
            ui: 'footer',
            items: ['->',{
            	glyph:'xf00c@FontAwesome',
                text: 'Ok',
                scope: this,
                handler: this.hide
            }]
        }];

        this.callParent(arguments);      
    }
});
