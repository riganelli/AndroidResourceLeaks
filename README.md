# A Benchmark for Resource Leak Detection in Android Apps

Our benchmark is the result of a qualitative work based on the reproduction of resource leaks already reported in other datasets used in state of the art papers. Our work has been manual and focused on the compilation, execution and reproduction of failures. We thus do not have a tool doing this work automatically. 

This benchmark has been submitted to the journal of Software: Practice and Experience .

Please feel free to [contact Oliviero Riganelli](http://www.lta.disco.unimib.it/riganelli/), if you have any questions.

## Contributors

* [Oliviero Riganelli](http://www.lta.disco.unimib.it/riganelli/) 
* [Daniela Micucci](http://www.sal.disco.unimib.it/people/daniela-micucci/)
* [Leonardo Mariani](http://www.lta.disco.unimib.it/lta/personalPages/leonardoMariani/leonardoMariani.php)


## Requirements
1) If not already present, install:
	- [Andorid SDK](https://developer.android.com/)
	- [Appium](http://appium.io), [Eclipse](http://www.eclipse.org/downloads/) for test case execution
	- [Android Studio](https://developer.android.com/studio/) or [Eclipse with AD](https://marketplace.eclipse.org/content/android-development-tools-eclipse) if you want to compile and debug apps
	- An Android device or emulator like [Genymotion](https://www.genymotion.com/fun-zone/) to run apps

2) Set "ANDROID_HOME" and "adb" in the environment variables.


## Use

The benchmark can be used to study the effectiveness of techniques to identify, analyze, and fix resource leaks. 
In all the cases, the first step is reproducing the available resource leaks locally. I will show you how to use and understand the benchmark dataset. 

1) If you open the file *Android\_App\_Leaks.htm*, a web page will be displayed containing all the information and artifacts produced for each resource leak as shown below. 
![*Android\_App\_Leaks.htm* file](imgs/Android_App_Leaks.png)

2) The first column, called *App*, contains a reference to the software project to which the resource leak is connected. For example, if you click on [AnkiDroid](https://github.com/ankidroid/Anki-Android) you will see the following GitHub page.

![](imgs/AnkiDroid.png)

3) The second column, called *Resource class*, shows the Android API class that identifies the resource that is leaked. For example, if you click on [SQLiteDatabase](https://developer.android.com/reference/android/database/sqlite/SQLiteDatabase), you will see the following Android documentation for the *SQLiteDatabase class*.

![](imgs/SQLiteDatabase.png)

4) The third column (*Fixed Version*) refers to the version of the app in which the resource leak has been corrected. For example, clicking on [b27f423f73](https://github.com/ankidroid/Anki-Android/commit/b27f423f73a7e940b31fae3dce8722c0866abca0) shows the fix commit as shown below.

![](imgs/FixedVersion.png)

5) The *Fixed APK* column is a link to the APK of the fixed version of the app, that you can install for example using the *adb install* command as shown below.

![](imgs/adbinstall.png)

6) The *Fixed Source Code* column shows a link to the zip file containing a copy of the project sources with the fix.  The contents of the zip file were used to build the APK.

![](imgs/projectsource.png)

7) The *Fixed Source* column shows a link to the zip file containing a copy of the project sources with the fix.  The contents of the zip file were used to build the APK.

8) Similar to the version with fix, the *Faulty version* column links the faulty version of the app in the version control system of the app.

![](imgs/buggyVersion.png)

9) The column *Faulty APK* links the apk file of the faulty app.

10) The *Faulty Source Code* column links the zip file containing the source code of the faulty version that is available in our benchmark under the folder of the app used to build the APK.

11) The *Faulty file* is the name of the file with the class that misses to invoke the release method, while the *Faulty method* is the name of the method in the *Faulty file* which misses to release the leaked resource. Clicking on the name opens the file in the version control system of the app as shown below.

![](imgs/faultyFile.png)
 12) *Test case* column links the zip file that contains an  Appium automatic test case that reveals the fault, it is available in our benchmark under the folder of the app. To runa the test case you have to configure and run Appium server. The server address should be 127.0.0.1 on the port 4723 (If it is not the case, the test case must be changed accordingly). To run it, you can click the Start Server button inside of Appium Desktop shown below ([more info about Appium](https://appium.io/docs/en/about-appium/getting-started/?lang=en#running-your-first-test)). 
![](imgs/appiumServer.png)

If the server is running you should see the following window.

![](imgs/appiumServerRunning.png)

Then you have to install the APK you want to test. For example we install the APK *AnkiDroid 362fa48a25.apk* affected by a resource leak:

![](imgs/installFaultyAPK.png)

Then you have to unzip the file containing the test case project:

![](imgs/unzipTestCase.png)

The project can be opened in Eclipse IDE (alternatively, you can compile it and run it from the command line):

![](imgs/testCaseEclipse.png)

The test case must be run as a JUnit Test.

![](imgs/testCaseOnFaultyAPK.png)

If desired, you can perform the same test case on the version with the fix. To do this, uninstall the version with the fault and install the version with the fix (e.g. AnkiDroid b27f423f73.apk):

![](imgs/installFixedAPK.png)

Then rerun the same test case:

![](imgs/testCaseOnFixedAPK.png)

 
13) *Target (Compiled) API* is the version of the Android API declared as target in the manifest file and the version of the Android API that we used to reproduce the failure, respectively.

14) *IDE* is the Android IDE that we used to compile and debug the app.

15) *Emulator/Device* column indicates whether the emulator is sufficient to reproduce the failure, or a device is required.

16) *Oracle* indicates if the test case includes an oracle.


## License

The projects referenced in the Benchmark are subject to their respective licenses.
