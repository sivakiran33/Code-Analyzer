# Code-Analyzer
Work by Siva Kiran and Nataraj

We categorised the files which follows the standard IntelliJ IDEA project sturcture.
The file named "CodeAnalyzer.java" has the 'main()' method. If IntelliJ IDEA is not available,
just use this class to run the project, without changing the file locations.
Changing locations will lead to errors, as we have set the packages accordingly.

This code has 2 rules set.
For 'test.java', the development must be test driven. 
For ReturnRule, make sure that all the methods have a space before opening the brackets.
For IdentifierReuseRule, we considered only a part of Java literature.

This code works perfectly on jdk 1.7 and above (will support few older versions as well)


Setting up the project:

Select the option "download zip" which is available at https://github.com/sivakiran33/Code-Analyzer.git
That should download a zip file to the computer. Unzip the file to view files.


How to run:

In the project files, go to src\com\company
Run the file named CodeAnalyzer.java
The code should compile with no errors and display the output.
The results displayed are based on the 'test.java' file. Changing the content in this file results in different outputs.
The suggestions that are obtained are for the file 'test.java'

On the occasion of problems, contact sivakiran.bhamidimarri@ttu.edu
