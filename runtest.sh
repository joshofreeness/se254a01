#!/bin/bash
echo "Compiling..."
javac -cp .:junit.jar:good.jar se254/money/TestMoney.java
echo "... done!"
echo $(date) |tee testresults.txt
echo "Starting tests" | tee -a testresults.txt

for testName in "good.jar" "badA.jar" "badB.jar" "badC.jar" "badD.jar" \
"badE.jar" "badF.jar" "badG.jar" "badH.jar" "badI.jar" "badJ.jar"
do
    echo "Testing $testName" | tee -a testresults.txt
    java -cp .:junit.jar:$testName se254.money.TestMoney >> testresults.txt
done

echo "Done!" | tee -a testresults.txt
