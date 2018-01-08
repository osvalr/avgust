Ext.define('MyApp.util.GuiaUtil', {
singleton : true,
setGuiaTotales: function() {
	Ext.Ajax.request({
        method: 'GET',
        url: '/InaviWSRestApp/api/GestionarGuia/guiaTotales',
        success: function( result, request ){
        	
        	var json = Ext.JSON.decode(result.responseText);
        	var formTotales = Ext.getCmp('form_totales');
        	
        	total_peso_bruto = formTotales.getForm().findField('total_peso_bruto');
        	total_peso_tara = formTotales.getForm().findField('total_peso_tara');
        	total_peso_devolucion = formTotales.getForm().findField('total_peso_devolucion');
        	total_peso_neto = formTotales.getForm().findField('total_peso_neto');

        	total_peso_bruto.setValue(json.record.total_peso_bruto);
        	total_peso_tara.setValue(json.record.total_peso_tara);
        	total_peso_devolucion.setValue(json.record.total_peso_devolucion);
        	total_peso_neto.setValue(json.record.total_peso_neto);
        }
    });
}
});