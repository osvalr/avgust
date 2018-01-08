Ext.define('MyApp.util.InaviUtil', {
singleton : true,
formatMoney : function (amount, sign, decimals, end) {
    // Save the thousand separator
    var thousandSep = Ext.util.Format.thousandSeparator;
    var decimalSeparator = Ext.util.Format.decimalSeparator;
    Ext.util.Format.thousandSeparator  = ",";
    Ext.util.Format.decimalSeparator  = ".";
    
    var formatted = Ext.util.Format.currency(amount, sign, decimals, end);
    // restore the thousand separator
    Ext.util.Format.thousandSeparator = thousandSep;
    Ext.util.Format.decimalSeparator = decimalSeparator;
    return formatted;
}
});