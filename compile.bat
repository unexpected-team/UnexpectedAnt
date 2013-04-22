PATH %JAVA_HOME%;%PATH%
mkdir out
cd src
dir /s /B *.java > sources.txt
javac -d ../out @sources.txt
copy manifest.txt ..\out
del sources.txt
cd ../out
jar -cvfm unexpected_ant.jar manifest.txt *
cd ..