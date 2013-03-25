mkdir out
cd src
dir /s /B *.java > sources.txt
javac -d ../out @sources.txt
cp manifest.txt ../out
rm sources.txt
cd ../out
jar -cvfm unexpected_ant.jar manifest.txt *
cd ..