contest_types="abc agc others"
for contest_type in $contest_types; do
  contests=`ls $contest_type`
  for contest in $contests; do
    tasks=`ls $contest_type/$contest/src/main/java/$contest`
    for task in $tasks; do
      ls $contest_type/$contest/src/main/java/$contest/$task/Main.java
      ls $contest_type/$contest/src/test/java/$contest/$task/MainTest.java
      mkdir -p $contest_type/$contest/$task/src/main/java
      mkdir -p $contest_type/$contest/$task/src/test/java
      cp $contest_type/$contest/src/main/java/$contest/$task/Main.java $contest_type/$contest/$task/src/main/java/Main.java
      cp $contest_type/$contest/src/test/java/$contest/$task/MainTest.java $contest_type/$contest/$task/src/test/java/MainTest.java
    done
    rm -rf $contest_type/$contest/src
  done
done