
# Pre-requisites
* Java 1.8/1.11/1.15
* Gradle 6

# How to run the code

We have provided scripts to execute the code. 

Use `run.sh` if you are Linux/Unix/macOS Operating systems and `run.bat` if you are on Windows.

Internally both the scripts run the following commands 

 * `gradle clean build -x test --no-daemon` - This will create a jar file `geektrust.jar` in the `build/libs` folder.
 * `java -jar build/libs/geektrust.jar sample_input/input1.txt` - This will execute the jar file passing in the sample input file as the command line argument

 Use the build.gradle file provided along with this project. Please change the main class entry under the `jar` task

 ```
 manifest {
        attributes 'Main-Class' : 'com.geektrust.backend.App' //Change this to the main class of your program which will be executed
    }
```
in the build.gradle if your main class has changed.

 # How to execute the unit tests

 `gradle clean test --no-daemon` will execute the unit test cases.

# Help

You can refer our help documents [here](https://help.geektrust.in)
You can read build instructions [here](https://github.com/geektrust/coding-problem-artefacts/tree/master/Java)

# Use Case Diagram
* Identify the actors
* Identify the what the different actors can do
* Focus on `what to do` and not `how to do`

### Benefits of Use Case Diagram
* This can directly shift into your `interfaces`.

# Identify the core Entities
* Nouns in requirements are possible candidates for Entities.
* Verbs in the requirements are possible methods.
* Ignore some of the nouns if we feel they won’t hold any vital information related to the problem description.
* You might possibly store the identified entities in Database
* Skip the nouns if they could be an attribute for any entity.
  - “City” could be an entity but in some cases it is more likely to be an attribute. Like attribute to a Address Entity.

[Image Description](image_path.png "Optional Title" =250x)

