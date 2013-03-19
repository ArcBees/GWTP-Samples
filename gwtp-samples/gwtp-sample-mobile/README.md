#GWTP Mobile Sample

##[GWTP Home](https://github.com/ArcBees/GWTP)

##Demo
http://gwtp-sample-mobile.appspot.com

##PhoneGap Debugging Build
To run the phonegap profile locally in the mobile sample you must first compile the sample using:

* Run `mvn clean install -Pphonegap-local`
* Then run the GAE server using: `mvn gae:run`
* Then open your browser to `http://localhost:8080`

###PhoneGap Device Build
Generically speaking the PhoneGap build wraps up the GWT module client side and builds a native version. 
No server side classes will be needed and can be deleted before zipping it and uploading it to Adobe Bd. 
We do this by exploding the war file and deleting the server side and testing the web mode.

* Run `mvn clean package -Pphonegap-remote`
* Goto the target/[build dir]
* Delete web-inf and meta-inf folders. No server side folders will be needed for native mobile client.
* Zip up client side files into yourname.zip for uploading to adobe bd.

###Deploy using Adobe Build
* Goto https://build.phonegap.com/apps
* Zip up app client side source only
* Create development Android key like this. Do not loose your key. Do not forget your password/passphrase. 
keytool -genkey -v -keystore brandon_donnelson.keystore -alias branflake2267@gmail.com -keyalg RSA -keysize 2048 -validity 10000
* Add key to adobe phone gap
* Upload zip file of client side source
* Download and test the apk. Be sure the android sdk is installed locally.

##Contributor Notes
1. run 'mvn generate-sources' - this will generate some of the annotated classes needed
