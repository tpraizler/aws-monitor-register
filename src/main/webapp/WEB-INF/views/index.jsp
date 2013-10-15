<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>Servers Monitoring Registration</title>

        <link rel="stylesheet" href="/monitor-register/resources/css/normalize.css">
        <link rel="stylesheet" href="/monitor-register/resources/css/main.css">

        <script src="/monitor-register/resources/js/vendor/jquery-1.10.2.min.js"></script>
        <script src="/monitor-register/resources/js/vendor/modernizr-2.6.2.min.js"></script>
        <script src="/monitor-register/resources/js/main.js"></script>

        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico">

        <link rel="stylesheet" type="text/css" href="/monitor-register/resources/css/demo.css" />
        <link rel="stylesheet" type="text/css" href="/monitor-register/resources/css/style.css" />

    </head>
    <body>
        <div class="container">
            <header>
                <h1>Registration for your servers <span>monitoring</span></h1>
            </header>
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">

                                <h1>please register !</h1>

                                <p>
                                    <label for="username" class="username" data-icon="u"> Friendly Name</label>
                                    <input id="username" name="username" required="required" type="text"  placeholder="Your Name" />
                                </p>
                                <p>
                                    <label for="phone" class="uname" data-icon="u" > Your phone number </label>
                                    <input id="phone" name="phone" required="required" type="text" placeholder="0544444444"/>
                                </p>
                                <p>
                                    <label for="accessKey" class="accessKey" data-icon="p"> Access Key</label>
                                    <input id="accessKey" name="accessKey" required="required" type="text" placeholder="string" />
                                </p>
                                <p>
                                    <label for="secretAccessKey" class="accessKey" data-icon="p"> Secret AccessKey</label>
                                    <input id="secretAccessKey" name="secretAccessKey" required="required" type="text" placeholder="string" />
                                </p>
                                <p class="login button">
                                    <input id="registerBtn" type="button" value="Register" />
								</p>
                                <p class="change_link" style="height:20px;">
								</p>
                        </div>
>
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>