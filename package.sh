files=`find ./ -name *.java`
for file in $files; do
  dir=`dirname $file`
  base=`basename $file`
  echo $dir $base
  mkdir -p $dir/solver
  mv $file $dir/solver/$base
done