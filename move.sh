contest_types="abc agc others"
for contest_type in $contest_types; do
  contests=`ls $contest_type`
  for contest in $contests; do
    tasks=`ls $contest_type/$contest`
    for task in $tasks; do
      mkdir -p $contest_type/$contest/$task/src/main/java/com/solver/atcoder/$contest_type/$contest/$task
      mv $contest_type/$contest/$task/src/main/java/$contest_type/$contest/$task/Main.java $contest_type/$contest/$task/src/main/java/com/solver/atcoder/$contest_type/$contest/$task/Main.java
      gsed -i '1,1d' "$contest_type/$contest/$task/src/main/java/com/solver/atcoder/$contest_type/$contest/$task/Main.java"
      echo "package com.solver.atcoder.$contest_type.$contest.$task;" > $contest_type/$contest/$task/src/main/java/com/solver/atcoder/$contest_type/$contest/$task/Main.java_
      cat $contest_type/$contest/$task/src/main/java/com/solver/atcoder/$contest_type/$contest/$task/Main.java >> $contest_type/$contest/$task/src/main/java/com/solver/atcoder/$contest_type/$contest/$task/Main.java_
      mv $contest_type/$contest/$task/src/main/java/com/solver/atcoder/$contest_type/$contest/$task/Main.java_ $contest_type/$contest/$task/src/main/java/com/solver/atcoder/$contest_type/$contest/$task/Main.java

      mkdir -p $contest_type/$contest/$task/src/test/java/com/solver/atcoder/$contest_type/$contest/$task
      mv $contest_type/$contest/$task/src/test/java/$contest_type/$contest/$task/MainTest.java $contest_type/$contest/$task/src/test/java/com/solver/atcoder/$contest_type/$contest/$task/MainTest.java
      gsed -i '1,1d' "$contest_type/$contest/$task/src/test/java/com/solver/atcoder/$contest_type/$contest/$task/MainTest.java"
      echo "package com.solver.atcoder.$contest_type.$contest.$task;" > $contest_type/$contest/$task/src/test/java/com/solver/atcoder/$contest_type/$contest/$task/MainTest.java_
      cat $contest_type/$contest/$task/src/test/java/com/solver/atcoder/$contest_type/$contest/$task/MainTest.java >> $contest_type/$contest/$task/src/test/java/com/solver/atcoder/$contest_type/$contest/$task/MainTest.java_
      mv $contest_type/$contest/$task/src/test/java/com/solver/atcoder/$contest_type/$contest/$task/MainTest.java_ $contest_type/$contest/$task/src/test/java/com/solver/atcoder/$contest_type/$contest/$task/MainTest.java
    done
  done
done