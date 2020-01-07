#!/bin/bash

BASEDIR=$(dirname "$0")

echo "Input contest number of abc."
read contest_number

for task_name in a b c d e f; do
sh $BASEDIR/template.sh << !
abc
abc$contest_number
$task_name
!
done