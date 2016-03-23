# Table of Content
* [Contributors](#contributors)
* [Application Architecture](#application-architecture)
* [contribute](#contribute)
* [patch](#patch)
* [install](#install)
* [jars](#jars)
* [exe](#exe)
* [thrift-lib](#thrift-lib)
* [thrift-source](#thrift-source)
* [dependency](#dependency)

## <a name="contributors"></a>Contributors

* [Djamel HAMAS](https://www.linkedin.com/in/jamelhamas)

## <a name="application-architecture"></a>Application Architecture

Based on apache thrift 0.9.3 
(http://www.apache.org/dyn/closer.cgi?path=/thrift/0.9.3/thrift-0.9.3.tar.gz)
(https://github.com/apache/thrift)
Patch (https://github.com/hbs/Thrift-GWT)

## <a name="contribute"></a>contribute
To contribute to thrift > (https://thrift.apache.org/docs/HowToContribute)



## <a name="patch"></a>patch
    thrift-0.9.3-gwt.patch

Generate by the command:

    git diff > thrift-0.9.3-gwt.patch

Clone the project:

    git clone https://git-wip-us.apache.org/repos/asf/thrift.git thrift
    git checkout tags/0.9.3

Take a look at what changes are in the patch: this only shows you the stats about what it’ll do:

    $ git apply --stat thrift-0.9.3-gwt.patch

You can test the patch before you actually apply it:

    $ git apply --check thrift-0.9.3-gwt.patch

Apply:

    $ git am --signoff < thrift-0.9.3-gwt.patch

## <a name="install"></a>install
To make project take a look to (https://thrift.apache.org/docs/install/)

## <a name="jars"></a>jars
    - libthrift-0.9.3-Gwt.jar
    - gwt-module-thrift-0.9.3.jar used for (<inherits name='GWT' />)

To generate jar after install ou have to execute ant file:

    https://github.com/naddame/ThriftGwt/blob/master/thrift-lib/java/build.xml

Execute the target dist to generate libthrift-0.9.3-Gwt.jar

Execute the target thrift-gwtmodule to generate gwt-module-thrift-0.9.3.jar

Not in the file build.xml installation of the jar to the local maven repository, Modify the value of mvn.dir to your local maven installation

    <!-- Package module file and GWT version of generated files into a dummy module -->
    <jar basedir="${src}" destfile="${build.dir}/GWT.1.0.jar" includes="GWT.gwt.xml **/gwt/*.java" />
    <property name="mvn.dir" value="C:\apache-maven-3.1.1\bin\mvn.bat"/>
    <exec dir="${basedir}/" executable="cmd">
        <arg value="/c"/>
        <arg value="${mvn.dir}"/>
        <arg line="install:install-file -Dfile=${build.dir}/GWT.1.0.jar -DgroupId=apache-thrift-gwt -DartifactId=gwt-module-thrift -Dversion=0.9.3 -Dpackaging=jar"/>
    </exec>

you can also intall jars to the local maven repository with command line:

    mvn install:install-file -Dfile=${build.dir}/GWT.1.0.jar -DgroupId=apache-thrift-gwt -DartifactId=gwt-module-thrift -Dversion=0.9.3 -Dpackaging=jar


## <a name="exe"></a>exe
    - thrift-0.9.3.exe

## <a name="thrift-lib"></a>thrift-lib
(https://github.com/naddame/ThriftGwt/tree/master/thrift-lib/java/src/org/apache/thrift/gwt)

## <a name="thrift-source"></a>thrift-source
https://raw.githubusercontent.com/naddame/ThriftGwt/master/thrift-source/compiler/cpp/src/generate/t_java_generator.cc

## <a name="dependency"></a>dependency
    <dependency>
        <groupId>org.apache.commons</groupId>
        <artifactId>commons-lang3</artifactId>
        <version>3.4</version>
    </dependency>
