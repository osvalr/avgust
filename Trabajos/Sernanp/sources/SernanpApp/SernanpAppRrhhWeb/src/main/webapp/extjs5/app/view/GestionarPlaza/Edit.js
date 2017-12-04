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
* DATE CREATE : 20/04/2015 01:10:00
* VERSION : 1.0 
*/

Ext.define('MyApp.view.GestionarPlaza.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.GestionarPlazaEdit',

    requires: ['Ext.form.Panel','Ext.ux.statusbar.StatusBar'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: '85%',

    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
            {
                xtype: 'tabpanel',
                activeTab: 0,
                items: [
							{
				                xtype: 'form',
				                id: 'form_crud_GestionarPlaza',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'Información de Plaza',
				                glyph:'xf022@FontAwesome',
				                
				                fieldDefaults: {
					    			anchor: '100%',
				                    labelAlign: 'left',
				                    allowBlank: false,
				                    combineErrors: true,
				                    msgTarget: 'qtip',
                    				labelWidth: 125
			                	},

		                		items: [
											{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : true,
											    editable : true,
											    fieldLabel : 'Id',
											    name : 'srl_id_conv_area_org',
											    disabled : false,
											    readOnly : false
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Convocatoria',
											    name : 'var_num_convocatoria',
											    disabled : false,
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : true,
											    editable : true,
											    fieldLabel : 'Requerimiento',
											    name : 'var_numero_requerimiento',
											    disabled : false,
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Requerimiento',
											    name : 'var_numero_requerimiento_corto',
											    disabled : false,
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Código Postulación',
											    minLength : 1,
											    name : 'var_codigo_postulacion',
											    disabled : false,
											    readOnly : true,
											    maxLength : 200
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Vacantes',
											    name : 'int_num_puestos',
											    disabled : false,
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textareafield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Lugar Prestación',
											    minLength : 1,
											    name : 'var_lugar_prestacion',
											    disabled : false,
											    readOnly : true,
											    maxLength : 5000
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Area Responsable',
											    name : 'descrip_area_responsable',
											    disabled : false,
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Responsable',
											    name : 'nombres_completos',
											    disabled : false,
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Estado',
											    name : 'descrip_estado',
											    disabled : false,
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'datefield',
											    hidden : false,
											    editable : true,
											    fieldLabel : 'Fecha Registro',
											    name : 'tsp_fecha_registro',
											    format : 'd/m/Y',
											    disabled : false,
											    readOnly : true
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    hidden : true,
											    fieldLabel : 'tokenField',
											    name : 'tokenField'
											}
										]
							}
							

							,{
					    		title: 'Etapas',
					    		glyph:'xf022@FontAwesome',
					    		items: [{id:'subModel_SubEtapaPlazaQuery', xtype:'SubEtapaPlazaQueryList'}]
							}
							,{
					    		title: 'Postulantes',
					    		glyph:'xf022@FontAwesome',
					    		items: [{id:'subModel_PostulantePlazaQuery', xtype:'PostulantePlazaQueryList'}]
							}
							,{
					    		title: 'Archivos Adjuntos',
					    		glyph:'xf022@FontAwesome',
					    		items: [{id:'subModel_ArchivoPlazaQuery', xtype:'ArchivoPlazaQueryList'}]
							}

                ]
            }
        ];
        
        this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'bottom',
            //id:'buttons',
            ui: 'footer',
            items: ['->', {
            	glyph:'xf0c7@FontAwesome',
                itemId: 'save',
                text: 'Grabar',
                action: 'save'
            },{
            	glyph:'xf00d@FontAwesome',
                text: 'Cancelar',
                scope: this,
                handler: this.close
            }]
        }, 
        Ext.create('Ext.ux.StatusBar', {
            dock: 'bottom',
            id: 'form_crud_GestionarPlaza_statusbar'
        })];

        this.callParent(arguments);      
    }
});