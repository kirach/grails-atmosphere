<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>Grails Atmosphere Plugin</title>
    <link rel="stylesheet" href="${resource(dir:pluginContextPath+'/forte-blue/styles',file:'design.css')}" type="text/css" media="screen" />
    <!--[if gte IE 6]><link rel="stylesheet" type="text/css" href="${resource(dir:pluginContextPath+'/forte-blue/styles',file:'ie.css')}" media="screen, projection" /><![endif]-->
    <!--[if IE 7.0]><link rel="stylesheet" type="text/css" href="${resource(dir:pluginContextPath+'/forte-blue/styles',file:'ie7.css')}" media="screen, projection" /><![endif]-->
    <g:javascript src="prototype.js" />
    <g:javascript src="behaviour.js" />
    <g:javascript src="moo.fx.js" />
    <g:javascript src="moo.fx.pack.js" />
    <g:javascript src="chat.js" />
    <g:javascript>
      app.url = "${createLink(controller: 'atmosphere')}"
    </g:javascript>
    <style type="text/css">
      #display {
        border: 1px solid #5c8098;
        width: 500px;
        height: 300px;
        margin-bottom: 10px;
        overflow-y: scroll;
      }
      #login-name {
        width: 200px;
      }
      #message {
        width: 500px;
        height: 50px;
      }
    </style>
  </head>
  <body>
    <div id="site">
      <div id="logo">
        <div id="logoimage">
          <h1><a href="http://www.free-css.com/"><span class="color1">Grails</span><span class="color2"> Atmosphere</span><span class="color1"> Plugin</span></a></h1>
        </div>
      </div>
      <ul id="menu">
        <li id="home"><a href="http://www.odelia-technologies.com">odelia technologies</a></li>
        <li id="contact"><a href="http://www.odelia-technologies.com/contact">Contact</a></li>
      </ul>
      <hr />
      <div id="backg">
        <div id="button" title="learn more on the Grails Atmopshere Plugin">
          <h2><a href="http://grails.org/plugin/atmosphere">learn more</a></h2>
        </div>

        <ul id="menu2">
          <li id="info"><a href="#">Chat</a></li>
        </ul>
        <div>
          <div id="contect" >

            <div id="main">
              <div id="display">
              </div>
              <div id="form">
                <div id="system-message">Please input your name:</div>
                <div id="login-form">
                  <input id="login-name" type="text" />
                  <br />
                  <input id="login-button" type="button" value="Login" />
                </div>
                <div id="message-form" style="display: none;">
                  <div>
                    <textarea id="message" name="message" rows="2" cols="40"></textarea>
                    <br />
                    <input id="post-button" type="button" value="Post Message" />
                  </div>
                </div>
              </div>
            </div>

          </div>

          <div id="news">
            <h3>Links</h3>
            <p class="date1">Grails</p>
            <p><a target="_blank" href="http://grails.org/">Grails</a> is an advanced and innovative open source web application platform that delivers new levels of developer productivity by applying principles like Convention over Configuration.<br/>
            It is built on Spring and based on <a target="_blank" href="http://groovy.codehaus.org/">Groovy</a>, the leading dynamic language for the Java platform.</p>
            <p class="date1">Atmosphere</p>
            <p><a target="_blank" href="https://atmosphere.dev.java.net/">Atmosphere</a> is a portable AjaxPush/Comet framework which can run on any Java based web server.</p>
            <p class="date1">odelia technologies</p>
            <p>Please visit the web site <a target="_blank" href="http://www.odelia-technologies.com/">odelia technologies</a>.</p>
          </div>
        </div>
        
      </div>
      <div id="footer1">
        <p class="footer"> designed: <a href="http://www.fakam.sk">fakam.sk</a><br />
          sponsors: <a href="http://www.hrajsa.sk">Free online games</a> </p>
      </div>
    </div>
    <div id="footer_line"> </div>
    <iframe id="comet-frame" style="display: none;"></iframe>
  </body>
</html>
