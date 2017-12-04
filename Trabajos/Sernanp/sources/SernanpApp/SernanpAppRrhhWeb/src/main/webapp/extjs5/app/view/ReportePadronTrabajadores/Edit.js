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
* DATE CREATE : 03/06/2015 07:19:09
* VERSION : 1.0 
*/

Ext.define('MyApp.view.ReportePadronTrabajadores.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.ReportePadronTrabajadoresEdit',

    requires: ['Ext.form.Panel','Ext.ux.statusbar.StatusBar'],

    layout: 'fit',
    autoShow: true,
    modal: true,
    floating: true,
    resizable: false,
    width: 350,

    glyph:'xf044@FontAwesome',

    initComponent: function() {
        this.items = [
            {
                xtype: 'tabpanel',
                activeTab: 0,
                items: [
							{
				                xtype: 'form',
				                id: 'form_crud_ReportePadronTrabajadores',
				                padding: '5 5 0 5',
				                border: false,
				                style: 'background-color: #fff;',
				                title: 'Información del Trabajador',
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
											    xtype : 'textfield',
											    name : 'int_anio',
											    fieldLabel : 'int_anio'
											}
											,{
											    xtype : 'textfield',
											    name : 'int_id_periodo_mes',
											    fieldLabel : 'int_id_periodo_mes'
											}
											,{
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'srl_id_nomina_anio_periodo_personal',
											    fieldLabel : 'srl_id_nomina_anio_periodo_personal'
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    name : 'srl_id_regimen_contractual',
											    fieldLabel : 'srl_id_regimen_contractual'
											}
											,{
											    xtype : 'textfield',
											    name : 'idpersonal',
											    fieldLabel : 'idpersonal'
											}
											,{
											    xtype : 'textfield',
											    name : 'numerodoc',
											    fieldLabel : 'numerodoc'
											}
											,{
											    xtype : 'textfield',
											    name : 'apepat',
											    fieldLabel : 'apepat'
											}
											,{
											    xtype : 'textfield',
											    name : 'apemat',
											    fieldLabel : 'apemat'
											}
											,{
											    xtype : 'textfield',
											    name : 'nombre',
											    fieldLabel : 'nombre'
											}
											,{
											    xtype : 'textfield',
											    name : 'nombre_completo',
											    fieldLabel : 'nombre_completo'
											}
											,{
											    allowBlank : true,
											    xtype : 'textfield',
											    name : 'int_estado',
											    fieldLabel : 'int_estado'
											}
											,{
											    xtype : 'textfield',
											    name : 'direccion',
											    fieldLabel : 'direccion'
											}
											,{
											    xtype : 'textfield',
											    name : 'nompais',
											    fieldLabel : 'nompais'
											}
											,{
											    xtype : 'textfield',
											    name : 'sexo',
											    fieldLabel : 'sexo'
											}
											,{
											    xtype : 'textfield',
											    name : 'fechanacimiento',
											    fieldLabel : 'fechanacimiento'
											}
											,{
											    xtype : 'textfield',
											    name : 'ruc',
											    fieldLabel : 'ruc'
											}
											,{
											    xtype : 'textfield',
											    name : 'telefono',
											    fieldLabel : 'telefono'
											}
											,{
											    allowBlank : true,
											    maxLength : 250,
											    minLength : 1,
											    xtype : 'textfield',
											    name : 'mailpersonal',
											    fieldLabel : 'mailpersonal'
											}
											,{
											    xtype : 'textfield',
											    name : 'estado',
											    fieldLabel : 'estado'
											}
											,{
											    xtype : 'textfield',
											    name : 'idarea',
											    fieldLabel : 'idarea'
											}
											,{
											    xtype : 'textfield',
											    name : 'desarea',
											    fieldLabel : 'desarea'
											}
											,{
											    xtype : 'textfield',
											    name : 'inicio_contrato',
											    fieldLabel : 'inicio_contrato'
											}
											,{
											    xtype : 'textfield',
											    name : 'termino_contrato',
											    fieldLabel : 'termino_contrato'
											}
											,{
											    xtype : 'textfield',
											    name : 'var_desc_grupo_ocupacional',
											    fieldLabel : 'var_desc_grupo_ocupacional'
											}
											,{
											    xtype : 'textfield',
											    name : 'var_nom_cargo',
											    fieldLabel : 'var_nom_cargo'
											}
											,{
											    xtype : 'textfield',
											    name : 'var_descripcion_regimen_pensionario',
											    fieldLabel : 'var_descripcion_regimen_pensionario'
											}
											,{
											    allowBlank : true,
											    maxLength : 50,
											    minLength : 1,
											    xtype : 'textfield',
											    name : 'var_nombre_afp',
											    fieldLabel : 'var_nombre_afp'
											}
											,{
											    allowBlank : true,
											    maxLength : 20,
											    minLength : 1,
											    xtype : 'textfield',
											    name : 'var_codigo_afiliacion',
											    fieldLabel : 'var_codigo_afiliacion'
											}
											,{
											    allowBlank : true,
											    xtype : 'datefield',
											    name : 'dte_fecha_afiliacion',
											    format : 'd/m/Y',
											    fieldLabel : 'dte_fecha_afiliacion'
											}
											,{
											    allowBlank : true,
											    maxLength : 50,
											    minLength : 1,
											    xtype : 'textfield',
											    name : 'var_numero_cuenta_bancaria',
											    fieldLabel : 'var_numero_cuenta_bancaria'
											}
											,{
											    xtype : 'textfield',
											    name : 'c_meta',
											    fieldLabel : 'c_meta'
											}
											,{
											    xtype : 'textfield',
											    name : 'c_fte_fto',
											    fieldLabel : 'c_fte_fto'
											}
											,{
											    xtype : 'textfield',
											    name : 'ubicacion',
											    fieldLabel : 'ubicacion'
											}
											,{
											    xtype : 'textfield',
											    name : 'dec_total_ingresos',
											    fieldLabel : 'dec_total_ingresos'
											}
											,{
											    xtype : 'textfield',
											    name : 'var_cod_nivel_estudio',
											    fieldLabel : 'var_cod_nivel_estudio'
											}
											,{
											    xtype : 'textfield',
											    name : 'var_descripcion_nivel_estudio',
											    fieldLabel : 'var_descripcion_nivel_estudio'
											}
											,{
											    xtype : 'textfield',
											    name : 'int_cod_tipo_profesion',
											    fieldLabel : 'int_cod_tipo_profesion'
											}
											,{
											    xtype : 'textfield',
											    name : 'var_descripcion_tipo_profesion',
											    fieldLabel : 'var_descripcion_tipo_profesion'
											}
											,{
											    xtype : 'textfield',
											    name : 'int_cod_profesion',
											    fieldLabel : 'int_cod_profesion'
											}
											,{
											    xtype : 'textfield',
											    name : 'var_descripcion_profesion',
											    fieldLabel : 'var_descripcion_profesion'
											}
											,{
											    xtype : 'textfield',
											    name : 'var_descripcion_institucion',
											    fieldLabel : 'var_descripcion_institucion'
											}
											,{
											    xtype : 'textfield',
											    name : 'dte_fecha_ingreso',
											    fieldLabel : 'dte_fecha_ingreso'
											}
											,{
											    xtype : 'textfield',
											    name : 'dte_fecha_culminacion',
											    fieldLabel : 'dte_fecha_culminacion'
											}
											,{
											    xtype : 'textfield',
											    name : 'int_sigue_estudios',
											    fieldLabel : 'int_sigue_estudios'
											}
											,{
											    xtype : 'textfield',
											    name : 'descrip_periodo',
											    fieldLabel : 'descrip_periodo'
											}
											,{
											    xtype : 'textfield',
											    name : 'quinta_categoria',
											    fieldLabel : 'quinta_categoria'
											}
											,{
											    xtype : 'textfield',
											    name : 'cuarta_categoria',
											    fieldLabel : 'cuarta_categoria'
											}
											,{
											    xtype : 'textfield',
											    name : 'essalud',
											    fieldLabel : 'essalud'
											}
											,{
											    allowBlank : true,
											    hidden : true,
											    xtype : 'textfield',
											    name : 'tokenField',
											    fieldLabel : 'tokenField'
											}
										]
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
            id: 'form_crud_ReportePadronTrabajadores_statusbar'
        })];

        this.callParent(arguments);      
    }
});
