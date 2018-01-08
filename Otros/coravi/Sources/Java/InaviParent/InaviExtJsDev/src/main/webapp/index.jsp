<!DOCTYPE HTML>
<html manifest="">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

	<!-- App custom css -->
	<link rel="stylesheet" type="text/css" href="resources/css/icons.css" />

    <title>.:: Modulo - Avicola la Iquena ::.</title>

    <!--
    <script type="text/javascript">
        var Ext = Ext || {}; // Ext namespace won't be defined yet...

        // This function is called by the Microloader after it has performed basic
        // device detection. The results are provided in the "tags" object. You can
        // use these tags here or even add custom tags. These can be used by platform
        // filters in your manifest or by platformConfig expressions in your app.
        //
        Ext.beforeLoad = function (tags) {
            var s = location.search,  // the query string (ex "?foo=1&bar")
                profile;

            // For testing look for "?classic" or "?modern" in the URL to override
            // device detection default.
            //
            if (s.match(/\bclassic\b/)) {
                profile = 'classic';
            }
            else if (s.match(/\bmodern\b/)) {
                profile = 'modern';
            }
            else {
                profile = tags.desktop ? 'classic' : 'modern';
                //profile = tags.phone ? 'modern' : 'classic';
            }

            Ext.manifest = profile; // this name must match a build profile name

            // This function is called once the manifest is available but before
            // any data is pulled from it.
            //
            //return function (manifest) {
                // peek at / modify the manifest object
            //};
        };
    </script>
    -->
    
    <!-- The line below must be kept intact for Sencha Cmd to build your application -->
    <script id="microloader" data-app="a9aab053-df8d-4cd1-95a5-0787658e637d" type="text/javascript" src="bootstrap.js"></script>

	<script type="text/javascript">
		
		//Dev
		var hostAcmeCommonWebApp = '/SeguridadWSRestApp';
// 		//Test
// 		var hostAcmeCommonWebApp = '/AcmeCommonWebApp';
// 		//Prd
// 		var hostAcmeCommonWebApp = '/AcmeCommonWebApp';
		
        //Dev
        var hostSeguridadWSRestApp = '/SeguridadWSRestApp';
//      //Test
//      var hostSeguridadWSRestApp = '/SeguridadWSRestApp';
//      //Prd
//      var hostSeguridadWSRestApp = '/SeguridadWSRestApp';
		
        //Dev
        var hostSeguridadExtJsApp = '/SeguridadAcmeWebApp';
//      //Test
//      var hostSeguridadExtJsApp = '/SeguridadExtJsDev';
//      //Prd
//      var hostSeguridadExtJsApp = '/SeguridadExtJsDev';

        //Dev
        var hostInaviWSRestApp = '/InaviWSRestApp';
//      //Test
//      var hostInaviWSRestApp = '/InaviWSRestApp';
//      //Prd
//      var hostInaviWSRestApp = '/InaviWSRestApp';
        	
	</script>

</head>
<body>

<div id="page-loader">
    <img style="position:absolute;left:50%; top:50%;" src="resources/hourglass.gif" />
</div>

</body>
</html>