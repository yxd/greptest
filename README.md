GrepTest User Guide
===================

### Software Installation
Install Scala related packages on a clean Unbuntu using the following command:

```
su -
apt-get install -y curl git vim
apt-get install -y openjdk-7-jdk
apt-get install -y scala
wget http://www.scala-lang.org/files/archive/scala-2.11.1.deb
dpkg -i scala-2.11.1.deb
wget http://repo.scala-sbt.org/scalasbt/sbt-native-packages/org/scala-sbt/sbt/0.13.0/sbt.deb --no-verbose
dpkg -i sbt.deb
```

### Get Source Code

```
git clone https://github.com/yxd/greptest.git
```

### Build
```
sbt package
```

### Run

```
sbt 'run <term> <folder>'
or
scala target/scala-2*/sgrep*.jar <term> <folder>
```
Here:

* term - the term you want to search
* folder - a existing folder to be searched into
	
### Test

```
sbt test
```
