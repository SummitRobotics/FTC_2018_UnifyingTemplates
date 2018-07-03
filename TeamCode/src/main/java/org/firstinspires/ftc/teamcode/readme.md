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
