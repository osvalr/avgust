<!DOCTYPE HTML>
<html manifest="">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

	<!-- App custom css -->
	<link rel="stylesheet" type="text/css" href="resources/css/icons.css" />

	<link href="resources/favicon.ico" rel="icon" type="image/x-icon" />
	<meta name="description" content="Server Low AnkerMu Season 6 Ep 3, Exp: x100, Drop: 65%, PvP, MuHelper 100%, Reset lvl: 400, 24/7.">
	<meta name="keywords" content="Mu Online,mu online, muonline, mu server, low, fast , mu, private mu, anker mu, mu anker, MU ANKER, ANKER MU, private server">
    <title>:: Anker MU ::</title>

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
    <script id="microloader" data-app="49b0664a-fb68-4202-96ba-8495f4a20197" type="text/javascript" src="bootstrap.js"></script>
	

		
</head>
<body style="background-repeat:no-repeat; background-size:cover;">

<div id="app-container" class="inner"></div>

<div id="page-loader">  
    <img style="position:absolute;left:50%; top:50%;" src="resources/hourglass.gif" />
</div>

</body>
	<script type="text/javascript">
		var num = Math.floor((Math.random() * 5) + 1);
		document.body.style.backgroundImage = "url('resources/images/bg/"+num+".jpg')";   	
	</script>
</html>
