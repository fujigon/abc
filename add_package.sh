files=`find ./ -name *.java`
for file in $files; do
  echo "package solver;\n" > ${file}_tmp
  cat $file >> ${file}_tmp
  mv ${file}_tmp $file
done