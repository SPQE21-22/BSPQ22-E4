<h1 align="center">Welcome to BSPQ22-E4 :globe_with_meridians: Supermarket 👋</h1>
<p>
  <img alt="Version" src="https://img.shields.io/badge/version-1.0.0-blue.svg?cacheSeconds=2592000" />
</p>


## Description
This is a Supermarket Web Service with server side and client side application. We have create a Web Supermarket where firstly you will need to register/login with an account to enter the website. Once you are loged in your profile will be charged and it can be checked at any time in the profile tab, but most importantly you can simulate to buy in the supermarket, adding/deleting products to your cart, selecting the :money_with_wings:payment method:credit_card: and even extracting a pdf with the ticket :receipt:.


## Prerequisites

### Installing JDK on Linux/Ubuntu

 1. Download the JDK Binaries 
  ```sh
  $ wget https://download.java.net/java/GA/jdk13.0.1/cec27d702aa74d5a8630c65ae61e4305/9/GPL/openjdk-13.0.1_linux-x64_bin.tar.gz
  $ tar -xvf openjdk-13.0.1_linux-x64_bin.tar.gz
  $ mv jdk-13.0.1 /opt/
  ```
 2. Setting JAVA_HOME and Path Environment Variables
  ```sh
  JAVA_HOME='/opt/jdk-13.0.1'
  PATH="$JAVA_HOME/bin:$PATH"
  export PATH
  ```
 3. Verify the Java Installation
   ```sh
  $ java -version
  openjdk version "13.0.1" 2019-10-15
  OpenJDK Runtime Environment (build 13.0.1+9)
  OpenJDK 64-Bit Server VM (build 13.0.1+9, mixed mode, sharing)
  ```


### Installing Maven on Linux/Ubuntu

 1.  Download the Maven Binaries 
  ```sh
  $ wget https://mirrors.estointernet.in/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz
  $ tar -xvf apache-maven-3.6.3-bin.tar.gz
  $ mv apache-maven-3.6.3 /opt/
  ```
 2.  Setting M2_HOME and Path Variables
  ```sh
  M2_HOME='/opt/apache-maven-3.6.3'
  PATH="$M2_HOME/bin:$PATH"
  export PATH
  ```
 3.  Verify the Maven installation
  ```sh
  $ mvn -version
  Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
  Maven home: /opt/apache-maven-3.6.3
  Java version: 13.0.1, vendor: Oracle Corporation, runtime: /opt/jdk-13.0.1
  Default locale: en, platform encoding: UTF-8
  OS name: "linux", version: "4.15.0-47-generic", arch: "amd64", family: "unix"
  ```
### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/SPQE21-22/BSPQ22-E4.git
   ```

<p align="right"><a href="#top">:arrow_up:</a></p>


<!-- USAGE EXAMPLES -->
### Usage

We will divide this section in two different command terminals. In the first one we will be running the server and in the other one we will run the client. All the commands must be executed inside the project folder. After running the server we must wait till the server says that the process is finish and that the server is alredy opened before run the client command.

#### 1 Terminal

  1.  Compile the project with maven.
  ```sh
  $ mvn compile
  ```
  
  2.  Run the server.
  ```sh
  $ mvn jetty:run
  ```
  
#### 2 Terminal

  1.  Run the client.
  ```sh
  $ mvn exec:java -Pclient
  ```

<p align="right"><a href="#top">:arrow_up:</a></p>


## Documentation

  https://spqe21-22.github.io/BSPQ22-E4/
  
### Built With

This section includes languages, frameworks and libraries used in this project.

* [Java](https://nextjs.org/)
* [Maven](https://maven.apache.org/)
* [GitHub Actions](https://docs.github.com/es/actions)
* [Log4j](https://logging.apache.org/log4j/2.x/)
* [Jacoco](https://www.jacoco.org/jacoco/trunk/doc/)
* [Doxygen](https://www.doxygen.nl/)
* [Graphviz](https://graphviz.org/)
* [VisualVM](https://visualvm.github.io/)


## Authors

👤 **Sergio Salgado <ssc1099@opendeusto.es>**

👤 **Pablo Sagredo <pablo.sagredo@opendeusto.es>**

👤 **Alejandra Arche <alejandra.arche@opendeusto.es>**

👤 **Konstantinos Ntanas <konstantinos.ntanas@opendeusto.es>**


## Show your support

Give a ⭐️ if this project helped you!

<p align="right"><a href="#top">:arrow_up:</a></p>
