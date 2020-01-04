contest_types="abc agc others"
for contest_type in $contest_types; do
  contests=`ls $contest_type`
  for contest in $contests; do
    tasks=`ls $contest_type/$contest`
    for task in $tasks; do
      mkdir -p $contest_type/$contest/$task/src/main/java/$contest_type/$contest/$task
      sed -i '1,1d' $contest_type/$contest/$task/src/main/java/$contest_type/$contest/$task/Main.java
      cat $contest_type/$contest/$task/src/main/java/$contest_type/$contest/$task/Main.java >> $contest_type/$contest/$task/src/main/java/$contest_type/$contest/$task/Main.java_
      mv $contest_type/$contest/$task/src/main/java/$contest_type/$contest/$task/Main.java_ $contest_type/$contest/$task/src/main/java/$contest_type/$contest/$task/Main.java

      mkdir -p $contest_type/$contest/$task/src/test/java/$contest_type/$contest/$task
      sed -i '1,1d' $contest_type/$contest/$task/src/test/java/$contest_type/$contest/$task/MainTest.java
      echo "package $contest_type.$contest.$task;" > $contest_type/$contest/$task/src/test/java/$contest_type/$contest/$task/MainTest.java_
      cat $contest_type/$contest/$task/src/test/java/$contest_type/$contest/$task/MainTest.java >> $contest_type/$contest/$task/src/test/java/$contest_type/$contest/$task/MainTest.java_
      mv $contest_type/$contest/$task/src/test/java/$contest_type/$contest/$task/MainTest.java_ $contest_type/$contest/$task/src/test/java/$contest_type/$contest/$task/MainTest.java
    done
  done
done