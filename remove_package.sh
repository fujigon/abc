files=`find ./ -name *.java`
for file in $files; do
  sed -i '1,2d' $file
done