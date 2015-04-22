*Murderize* is a script that will completely remove the given file or folder.
It isn't hindered by "too-long" paths. It will just straight-up murderize the target.
It probably won't work if the folder or something in it is open in another program.

# Usage

    Murderize "path/to/the/thing/to/delete"

# Building

*Murderize* is set up to use [`sbt-native-packager`](https://github.com/sbt/sbt-native-packager) to generate the a runnable script or batch file.

    sbt stage
    target/universal/stage/bin/urderize "some/directory"

If you have [WiX](http://wixtoolset.org/) installed, you can also package a Windows `.msi` installer.

    sbt windows:packageBin

This creates `target/windows/Murderize.msi`, which you can run to install *Murderize* on a Windows machine.