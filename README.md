1.What is the major difference between an abstract class and an interface ?
Ans:	Interface supports multiple inheritance and abstract class does not support multiple inheritance.
2. Why is Java 7’s class inheritance flawed?
Ans:	I don't know
3. What are the major differences between Activities and Fragments ?
Ans: 	An Activity provides a screen where user can interact and interface can be a portion of a screen. In other words an Activity is like a box and fragment is like something you put in the box,
4. When using Fragments , how do you communicate back to their hosting Activity ?
Ans:	By creating a base fragment in which we get the hosting activity instance, and we extend our all fragments with this base fragment.
5. Can you make an entire app without ever using Fragments ? Why or why not?
Ans:	Yes we can, because activity is the major part and to create a fragment in an activity that is upto us
Are there any special cases when you absolutely have to use or should use
Fragments?
Ans: When you have an app with the same footer and header navigations and want to control everything from one place then it is preferrable and best approach to use fragments
6. What makes an AsyncTask such an annoyance to Android developers? Detail
some of the issues with AsyncTask , and how to potentially solve them.
Ans: Well the problems can occur when the asynch task has not been properly closed or completed for example during runnin async task if screen orientation changes
then the task that was running in background may require a value that is no more available and app crashes, so to avoid these things is to examine
all the possible scenarios that can occur during ansycTask, it should be properly destroyed.
