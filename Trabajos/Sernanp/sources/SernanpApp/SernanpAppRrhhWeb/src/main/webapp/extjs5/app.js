/*
 * This file is generated and updated by Sencha Cmd. You can edit this file as
 * needed for your application, but these edits will have to be merged by
 * Sencha Cmd when upgrading.
 */
Ext.application({
    name: 'MyApp',

    extend: 'MyApp.Application',
    
//    autoCreateViewport: 'MyApp.view.main.Main'
    autoCreateViewport: false
	
    //-------------------------------------------------------------------------
    // Most customizations should be made to MyApp.Application. If you need to
    // customize this file, doing so below this section reduces the likelihood
    // of merge conflicts when upgrading to new versions of Sencha Cmd.
    //-------------------------------------------------------------------------
});

Ext.apply(Ext.form.VTypes, {
    fileUpload: function(val, field) {                              
                        var fileName = /^.*\.(png|jpg|jpeg)$/i;
                        return fileName.test(val);
    },                 
    fileUploadText: 'Image must be in .png,.jpg,.jpeg format'
});