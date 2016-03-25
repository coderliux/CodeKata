#Requirements Analysis

## 1. What kind of completed input would be accepted? 
    Key enter as default.
## 2. Are operators case sensitive? 
    Assumption only lowercase support.
## 3. Can undo operator cancel clear? 
    No example provided, suppose not, only cancel operators and operands.
## 4. What should show to console if input error? 
    For example, input a text string "abcd". Assumptions it show the position and error messages.
## 5. What is the position index of wrap line input when there is a insufficient?
    Start from the new line.
    
#Design 
## 1. Any design pattern fits into the problem?
    Simple Factory to create operation that execute the calculation.
## 2. What data structure should be used?
    The best is Stack, Deque is usable.
## 3. How robust is the program?
## 4. How complex is the code and how about its readability?


#How To Use
Make sure you have install a JVM that can run java application.
The JVM version 1.8 is required, otherwise you should build it from source code.
## 1. Build it from github
    git clone https://github.com/coderliux/CodeKata.git
    cd CodeKata/nrpcalculator
    ./gradlew clean deploy
    cd bin
    ./run.sh
## 2. Build it from zip file. Make sure you have installed gradle.
    Unzip the file, execute command in the root directory of it. 
     gradle clean deploy
     cd bin
     ./run.sh
 
  
