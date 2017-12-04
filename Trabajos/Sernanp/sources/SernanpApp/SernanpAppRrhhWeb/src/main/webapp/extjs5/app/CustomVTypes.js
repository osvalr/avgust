Ext.define('MyApp.CustomVTypes', {
	 loadVTypes : function() {

		  Ext.apply(Ext.form.VTypes, {
             
			metaNumeros : function(value, field) {
					return /^\d{3}-\d{3}$|^\d{3}$|,\d{3}-\d{3}|,\d{3}$/.test(value);
			},
			metaNumerosText : 'meta',
//			metaNumerosMask : /[0-9,-]/i,
			metaNumerosMask : /[0-9,-]/i,

			soloNumeros : function(value, field) {
				return /[0-9]/.test(value);
			},
			soloNumerosText : 'Solo números',
			soloNumerosMask : /[0-9]/i,

			soloLetras : function(value, field) {
				return /[A-Za-z]/.test(value);
			},
			soloLetrasText : 'Solo letras',
			soloLetrasMask : /[A-Za-z]/,

			fileUpload : function(val, field) {
				var fileName = /^.*\.(png|jpg|jpeg)$/i;
				return fileName.test(val);
			},
			fileUploadText : 'Image must be in .png,.jpg,.jpeg format',
			fileUploadMask : /^.*\.(png|jpg|jpeg)$/i,

			soloNumeroDecimales : function(value, field) {
				return /(?=.)^\$?(([1-9][0-9]{0,2}(,[0-9]{3})*)|[0-9]+)?(\.[0-9]{1,2})?$/.test(value);
			},
			soloNumeroDecimalesText : 'Solo números y decimales',
			soloNumeroDecimalesMask : /[0-9.]/,
			
			numeroRuc : function(value, field) {
				 var valor = value;
						if (valor.length == 8) {
							suma = 0;
							for (var i = 0; i < valor.length - 1; i++) {

								digito = valor.charAt(i) - '0';

								if (i == 0)
									suma += (digito * 2);
								else
									suma += (digito * (valor.length - i));
							}
							resto = suma % 11;
							if (resto == 1)
								resto = 11;
							if (resto + (valor.charAt(valor.length - 1) - '0') == 11) {
								return true;
							}
						} else if (valor.length == 11) {
							suma = 0;
							x = 6;
							for (var i = 0; i < valor.length - 1; i++) {
								if (i == 4)
									x = 8;
								digito = valor.charAt(i) - '0';
								x--;
								if (i == 0)
									suma += (digito * x);
								else
									suma += (digito * x);
							}
							resto = suma % 11;
							resto = 11 - resto;

							if (resto >= 10)
								resto = resto - 10;
							if (resto == valor.charAt(valor.length - 1) - '0') {
								return true;
							}
						}
					
					return false;
			},
			numeroRucText : 'R.U.C Invalido',
			numeroRucMask : /[0-9.]/,
			
			fileDocUpload : function(val, field) {
				var fileName = /^.*\.(png|jpg|jpeg|pdf)$/i;
				return fileName.test(val);
			},
			fileDocUploadText : 'Solo archivos con extensión .png,.jpg,.jpeg,.pdf',
			fileDocUploadMask : /^.*\.(png|jpg|jpeg)$/i,
			
			daterange: function(val, field) {
	            var date = field.parseDate(val);

	            if (!date) {
	                return false;
	            }
	            if (field.startDateField && (!this.dateRangeMax || (date.getTime() != this.dateRangeMax.getTime()))) {
	                var start = field.up('form').down('#' + field.startDateField);
	                start.setMaxValue(date);
	                start.validate();
	                this.dateRangeMax = date;
	            }
	            else if (field.endDateField && (!this.dateRangeMin || (date.getTime() != this.dateRangeMin.getTime()))) {
	                var end = field.up('form').down('#' + field.endDateField);
	                end.setMinValue(date);
	                end.validate();
	                this.dateRangeMin = date; 
	            }
	            
	            return true;
	        },

	        daterangeText: 'La fecha de inicio debe ser menor que la fecha de término',

		  });
	 }
});
