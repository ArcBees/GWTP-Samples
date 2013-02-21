#GWTP Mobile Sample

##[GWTP Home](https://github.com/ArcBees/GWTP)

##Demo
http://gwtp-sample-mobile.appspot.com

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
* Rename *.war to yourname.war.
* Upload yourname.war to remote tomcat server.
* Copy war to a zip and extra zip.
* Delete web-inf and meta-inf folders. No server side folders will be needed for native mobile client.
* Zip up client side files into yourname.zip for uploading to adobe bd.

###Upload to phonegap build
* Goto https://build.phonegap.com/apps
* Zip up app client side source only
* Create development Android key like this. Do not loose your key. Do not forget your password/passphrase. 
keytool -genkey -v -keystore brandon_donnelson.keystore -alias branflake2267@gmail.com -keyalg RSA -keysize 2048 -validity 10000
* Add key to adobe phone gap
* Upload zip file of client side source
* Download and test the apk. Be sure the android sdk is installed locally.

##Contributor Notes
1. run 'mvn generate-sources' - this will generate some of the annotated classes needed
