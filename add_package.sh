files=`find ./ -name *.java`
for file in $files; do
  sed '1ipackage solver;' $file
done