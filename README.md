The code for the calculator section is from a combination of:

https://github.com/fabriziocucci/natural-language-calculator/tree/master/src/main/java/com/coolworks

and

http://eddmann.com/posts/shunting-yard-implementation-in-java/

Both of which are more and less advanced versions of the shunting algorithm as created by Edsger Dijkstra. There aren't too many variations on these.

**

The enum unit tests focus on testing the methods within the enumerations rather than the values.

**

Tests are far from exhaustive due to time limitations but the outlined methods in the sheet are tested.

**

Case-insensitivity here is a hack as it would have been better to support variants like 'Add' and etc... which would probably have meant using translation
methods rather than enum values ONE("One", "ONE", "oNe"... ) would have been exhaustive. It's good enough for this implementation. For anything more serious
a lazy-matcher would have been fun to write.

**

I did introduce one maven dependency on jUnit which may or may not be necessary depending on the version of Java and platform being used. Mea culpa.