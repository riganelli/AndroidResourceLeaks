# A Benchmark for Resource Leak Detection in Android Apps

Our benchmark is the result of a qualitative work based on the reproduction of resource leaks already reported in other datasets used in state of the art papers. Our work has been manual and focused on the compilation, execution and reproduction of failures. We thus do not have a tool doing this work automatically. 

This benchmark has been submitted to the journal of Software: Practice and Experience .

Please feel free to [contact Oliviero Riganelli](http://www.lta.disco.unimib.it/riganelli/), if you have any questions.

## Contributors

* [Oliviero Riganelli](http://www.lta.disco.unimib.it/riganelli/) 
* [Daniela Micucci](http://www.sal.disco.unimib.it/people/daniela-micucci/)
* [Leonardo Mariani](http://www.lta.disco.unimib.it/lta/personalPages/leonardoMariani/leonardoMariani.php)

# Use

The benchmark can be used to study the effectiveness of techniques to identify, analyze, and fix resource leaks. 
In all the cases, the first step is reproducing the available resource leaks locally. To do this, the recommended procedure is the following one:

1) Clone the benchmark repository in the target computer.

2) If not already present, install:
	- Appium (we used version 1.3.1, https://github.com/appium/appium-desktop/releases/tag/v1.3.1 )
	- Android Studio and SDK tools ( https://developer.android.com/studio/index.html )
	- Eclipse (we used Oxygen version, http://www.eclipse.org/downloads/)
	- Genymotion ( https://www.genymotion.com/fun-zone/)
	
3) Configure and run Appium server. The test cases assume that the app under test runs on the same machine of the Appium client and that the 
	Appium server is available at address 127.0.0.1 on the port 4723. If it is not the case, the test case must be changed accordingly.

4) Set "ANDROID_HOME" and "adb" in the environment variables.

5) Use the apk provided by the benchmark. Alternatively, you can open the project with the Android IDE specified under column "IDE" and build 
	the apk with the Android version indicated under column "Target(Compiled) API" of the "Android_Apps_Leak.csv". 
	
6)	Start the desired emulator/device according to "MobileCapabilityType.VERSION" attribute specified in the test case code.
	We used the following emulators:
	- Genymotion Google Nexus 4, API 16
	- Genymotion Google Nexus 6, API 22

7) Install the apk of the app, launch Appium, and finally launch the test case to reproduce the resource leak.

# License

The projects referenced in the Benchmark are subject to their respective licenses.
