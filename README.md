#GWTP-Samples
Project samples display GWT-Platform features configuration and uses. 

##GWTP Reference
* [GWTP Custom Google Search](http://www.google.com/cse/home?cx=011138278718949652927:5yuja8xc600) - Search GWTP documentation, wiki and thread collections.
* [GWTP Home](https://github.com/ArcBees/GWTP) - Find the GWT-Platform home here.
* [GWTP Documentation](https://github.com/arcbees/gwtp/wiki) - Find out how to use GWT-Platform here.
* [GWTP Archetypes](https://github.com/ArcBees/ArcBees-tools/tree/master/archetypes) - Start a project from a template here.

##Community
* [Join the GWT-Platform G+ Community](https://plus.google.com/communities/113139554133824081251) - See whats happening in the community.
* [GWTP Google Group](https://groups.google.com/forum/?fromgroups#!forum/gwt-platform) - Ask for help here.

##Demos
<table>
  <tr>
    <th>Sample</th>
    <th>Demo</th>
    <th>Source</th>
  </tr>
  <tr>
    <th>Basic</th>
    <td><a href="http://gwtp-sample-basic.appspot.com">AppEngine Demo</a></td>
    <td><a href="https://github.com/ArcBees/GWTP-Samples/tree/master/gwtp-samples/gwtp-sample-basic">Source</a></td>
  </tr>
  <tr>
    <th>Basic Spring</th>
    <td><a href="http://gwtp-sample-basic-spring.appspot.com">AppEngine Demo</a></td>
    <td><a href="https://github.com/ArcBees/GWTP-Samples/tree/master/gwtp-samples/gwtp-sample-basic-spring">Source</a></td>
  </tr>
  <tr>
    <th>Mobile</th>
    <td><a href="http://gwtp-sample-mobile.appspot.com">AppEngine Demo</a></td>
    <td><a href="https://github.com/ArcBees/GWTP-Samples/tree/master/gwtp-samples/gwtp-sample-mobile">Source</a></td>
  </tr>
  <tr>
    <th>Nested</th>
    <td><a href="http://gwtp-sample-nested.appspot.com">AppEngine Demo</a></td>
    <td><a href="https://github.com/ArcBees/GWTP-Samples/tree/master/gwtp-samples/gwtp-sample-nested">Source</a></td>
  </tr>
  <tr>
    <th>Tabs</th>
    <td><a href="http://gwtp-sample-tab.appspot.com">AppEngine Demo</a></td>
    <td><a href="https://github.com/ArcBees/GWTP-Samples/tree/master/gwtp-samples/gwtp-sample-tab">Source</a></td>
  </tr>
</table>

##Phonegap
To run the phonegap profile locally in the Mobile sample you must first compile the sample using:<br />
mvn clean install -Pphonegap<br />
Then run the GAE server using:<br />
mvn gae:run<br />
Then open your browser to localhost:8080

###Phonegap build
Generically speaking the PhoneGap build wraps up the GWT module client side and builds a native version. 
No server side classes will be needed and can be deleted before zipping it and uploading it to Adobe Bd. 
We do this by exploding the war file and deleting the server side and testing the web mode.

* Goto the target directory and locate the build *.war.
* Rename *.war to carsample-v4.war.
* Upload carsample-v4.war to remote tomcat server.
* Copy war to a zip and extra zip.
* Delete web-inf and meta-inf folders. No server side folders will be needed for native mobile client.
* Zip up client side files into carsample.zip for uploading to adobe bd.

###Upload to phonegap build
* Goto https://build.phonegap.com/apps
* Zip up app client side source only
* Create development Android key like this. Do not loose your key. Do not forget your password/passphrase. 
keytool -genkey -v -keystore brandon_donnelson.keystore -alias branflake2267@gmail.com -keyalg RSA -keysize 2048 -validity 10000
* Add key to adobe phone gap
* Upload zip file of client side source
* Download and test the apk. Be sure the android sdk is installed locally. It can be deployed like this via usb. 
~/workspace-sdk/android-sdk/android-sdk-macosx/platform-tools/adb install CarSample-release.apk

##License
* GWTP is freely distributable under the [Apache 2.0 License](http://www.apache.org/licenses/LICENSE-2.0.html)

##Thanks to
[![Arcbees.com](http://arcbees-ads.appspot.com/ad.png)](http://arcbees.com)

[![IntelliJ](https://lh6.googleusercontent.com/--QIIJfKrjSk/UJJ6X-UohII/AAAAAAAAAVM/cOW7EjnH778/s800/banner_IDEA.png)](http://www.jetbrains.com/idea/index.html)
