# Install Java on Mac

```
brew install openjdk@11
brew install openjdk@17

sudo ln -sfn  $HOMEBREW_PREFIX/opt/openjdk@11/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk-11.jdk
sudo ln -sfn  $HOMEBREW_PREFIX/opt/openjdk@17/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk-17.jdk

echo 'alias java11="export JAVA_HOME=$(/usr/libexec/java_home -v11)"' >> ~/.zshrc
echo 'alias java17="export JAVA_HOME=$(/usr/libexec/java_home -v17)"' >> ~/.zshrc

source ~/.zshrc

java11

java -version

java17

java -version

```
