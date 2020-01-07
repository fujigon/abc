#!/bin/bash

echo "Input contest type."
read contest_type
echo "Input contest name."
read contest_name
echo "Input task name."
read task_name

BASEDIR=$(dirname "$0")

dir="$contest_type/$contest_name/$task_name"
package_dir="com/solver/atcoder/$contest_type/$contest_name/$task_name"
package_str="com.solver.atcoder.$contest_type.$contest_name.$task_name;"
mkdir -p $BASEDIR/$dir
cp $BASEDIR/.template/_BUILD.bazel $BASEDIR/$dir/BUILD.bazel

mkdir -p $BASEDIR/$dir/src/main/java/$package_dir
echo "package $package_str" > $BASEDIR/$dir/src/main/java/$package_dir/Main.java
cat $BASEDIR/.template/_Main.java >> $BASEDIR/$dir/src/main/java/$package_dir/Main.java

mkdir -p $BASEDIR/$dir/src/test/java/$package_dir
echo "package $package_str" > $BASEDIR/$dir/src/test/java/$package_dir/MainTest.java
cat $BASEDIR/.template/_MainTest.java >> $BASEDIR/$dir/src/test/java/$package_dir/MainTest.java
