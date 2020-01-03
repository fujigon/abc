contest_types="abc agc others"
for contest_type in $contest_types; do
  contests=`ls $contest_type`
  for contest in $contests; do
    tasks=`ls $contest_type/$contest`
    for task in $tasks; do
      cp BUILD.bazel $contest_type/$contest/$task/BUILD.bazel
    done
  done
done