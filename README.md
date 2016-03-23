# Table of Content
* [Contributors](#contributors)
* [Application Architecture](#application-architecture)
* [patch](#patch)
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

## <a name="patch"></a>patch
    thrift-0.9.3-gwt.patch
First, take a look at what changes are in the patch: this only shows you the stats about what it’ll do.
    $ git apply --stat thrift-0.9.3-gwt.patch

You can test the patch before you actually apply it.
    $ git apply --check thrift-0.9.3-gwt.patch

Apply
    $ git am --signoff < thrift-0.9.3-gwt.patch



## <a name="jars"></a>jars
    - libthrift-0.9.3-Gwt.jar
    - gwt-module-thrift-0.9.3.jar used for (<inherits name='GWT' />)
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
