## Summit High School Robotics --- FTC Team 6833, 8151 --- FRC team 5468
Welcome to the 2018 example code library, developed by Jamey Luckett and Aidan Beery. 
This library is meant to get individuals who are completely new to programming started with coding their FTC robot. 
Please keep in mind when using this code that it's intended to explain robot coding for those with absolutely no java experience. 
So, these classes are heavy on commenting and explanation, and we generally do not recommend having such extensive comments in your code, though it never hurts. 

## Intro to FTC Java Code Deployment
In FTC, there are 2 main ways of writing code. The first is OnBotJava, a web-browser based text editor which uses a WiFi-Direct web server between the Robot Controller FTC phone and any computer. 
OnBotJava is a very simple text editor, and lacks many of the code development features that you would find in a dedicated IDE (Integrated Development Environment).
However, it allows you to deploy code remotely, and is the only way of deploying code to your robot without plugging the Robot Controller into your computer. 
This makes OnBotJava great for deploying hotfixes or other small, rapid changes to your code, or for coding at a competition. 
However, because of a lack of robust features, it's not recommended that you do most of your coding in OnBotJava.

The second major way of deploying code is using Android Studio, a flavor of IntelliJ which is specifically tuned for Android development. 
Android Studio is the official supported IDE of FTC, and has many complex features and development tools which OnBotJava lacks. 
In order to deploy code that you write in Android Studio, you have to build the FTC Robot Controller app on the phone.
This can make deployment slow and somewhat complicated to do your first time, and doing this will be explained later in this readme. 
So, because of the features that Android Studio gives you, it's recommended that you use it for most of your code development. 
However, for small code changes or hotfixes, doing a rebuild through Android Studio is slow and unnecessary, use OnBotJava.

(NOTE: For the 2019 season, Summit Robotics is migrating to IntelliJ instead of Android Studio. Please ask a controls team lead for instructions on installing IntelliJ)

## Getting Started with OnBotJava
In order to use OnBotJava, you will need 2 things: your Android robot controller phone, and a Windows/Mac/Linux computer.
First, power on your Robot Controller and open the "FTC Robot Controller" app on the home screen.
From here, click the drop-down menu (The three vertical dots in the upper right-hand corner) in the app, and select "Program and Manage".
This will open a file server on the phone, allowing for code to be pushed. Take note of 3 things on this screen; the password/passphrase, and the IP.

Now, open up a computer and look at WiFi networks. On Windows 10, you can do this by clicking the "Network" button in the lower right-hand corner of the task bar.
You should see a network with the name "DIRECT-" followed by a string of letters and numbers. Make sure this network matches the one you found on your Robot Controller.
Connect to this network using the password you found earlier.
Now, open a web browser (Recommended that you use Google Chrome or Mozilla Firefox), and in the address bar, enter the IP that you found earlier.
This should take you to the OnBotJava configuration page. In the top bar on the webpage, select "OnBotJava" to go to your programming interface.

From here, if you're starting a brand new OpMode or robot code project, select "New", follow the on-screen instructions, and start coding!
However, if you want to take advantage of the powerful features in Android Studio, or deploy this example codebase on your robot, please see "Getting Started with Android Studio"

## Getting Started with Android Studio
(NOTE: Summit Robotics is migrating to IntelliJ for the 2019 season. Please see a controls team lead for instructions on installing and using IntelliJ)
(It is recommended that you do not install Android Studio at this time, but continue if you need to start developing immediately.)

First, you need the Java Development Kit (JDK). This software allows IDE's (In this case, Android Studio) to build and compile Java source code.
At the time of writing this, Java 8 is the supported Java version for FTC. Do NOT install Java 9, it will break your code and you will have a bad time.
The JDK can be found here: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
Accept the licence agreement near the top of the page and click the link to download the installer that corresponds to your operating system (For Windows 10, this will be "Windows x64" 99% of the time.)
Run the installer, and accept all the default settings.

Next, you'll want to download Android Studio. It can be found here: https://developer.android.com/studio/
Download the installer. If you grabbed the "Windows x64" version of the JDK, feel free to click the big green "Download" button, the first one that you see on this webpage.
If you installed a different version of the JDK, get the version of Android Studio that corresponds with your JDK.
Run the installer for Android Studio and follow the on-screen instructions. Make sure to un-check the "Android Virtual Device" under "Components to Install", as we don't need the AVD for FTC purposes.
Install Android Studio in the default install location. Once it's installed, select "Do not import settings", and go through the Welcome/First launch setup.
Here, select "Custom installation", and select your prefered UI theme. On the next screen, make sure "Android SDK", "Android SDK Platform", "API 28", and "Performance" are all checked.
Ignore the "Emulator Settings" window, press next. Double-check your settings on the next screen, and select "Finish" to download and install all the components of Android Studio. This may take a while.

Now, you'll need to download the actual code for the FTC Robot Controller. If you want to start a new robot code project, download the FTC SDK here:
https://github.com/ftctechnh/ftc_app
If you want to use the FTC SDK with the Summit Robotics sample code that comes with this Readme, download the Summit Robotics FTC Unifying Library here:
https://github.com/SummitRobotics/FTC_2018_UnifyingTemplates
There are two options for installing this repository. You can clone it directly from Github, or use GitKraken to "push" and "pull" from the repository.
GitKraken (or some other form of Git) is extremely recommended, as it allows you to make changes to the repository, make branches, etc. However, for the sake of this example, we will be cloning the repository directly from Github.

Click the "Clone or Download" green button on the Github webpage, and then select "Download ZIP". Once this file is downloaded, move it to whatever directory you want to code out of (or keep it in Downloads, just remember NOT to delete it).
You then want to extract the .zip file into it's own folder. Your FTC code will live in this folder, make sure to back it up regularly and not to delete it!

Now, we want to import the FTC SDK into Android Studio. On Android Studio's launch page, select "Import Project".
You then want to navigate to the directory that you stored the FTC SDK folder in. For example, if you kept it in "Downloads", point the import to "C:/Users/[your username here]/Downloads/[name_of_FTC_folder]".
A first-time Gradle build will run in order to configure the package to your IDE. Once it has run, make sure to deny any "update Android Studio" requests you get.

Now for a few tweaks to Android Studio to make your life easier.
First, you will want to enable auto-imports. This will make it so parts of the FTC SDK will be automatically imported into your Opmode, so that you don't have to manually import these classes every time you want to access an different feature.
To do this, go into "File - Prefrences - Editor - General - Auto Import." Here you will want to check "Add unambiguous imports" and "Optimize on-the-fly imports for this project".

Now, in preferences, disable Instant Run. Instant Run is a nice feature to have when developing an Android app, as it allows relatively small changes (such as adding one or two classes, like we do to the Robot Controller app) to be deployed to the phone without stopping or uninstalling the app.
In short, Instant Run deploys code changes on-the-fly, without doing a full reinstall and rebuild of the Robot Controller app.
However this is known to break the Robot Controller app, as it was never intended to support Instant Run. So, it's advised to turn it off for FTC use.
To do this, in prefrences, go to "Build, Execution, and Deployment - Instant Run" and make sure "Enable Instant Run" is unchecked.

Android Studio is now set up and ready for you to start coding! If you're using the Summit Robotics Unified Templates, you should have access to some opmodes and a library already set up for you.
You can find your robot code in the "Teamcode" module "Teamcode - Java - Org.Firstinspires.Ftc.Teamcode". This teamcode package is where all your robot code will go. 
