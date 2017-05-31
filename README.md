# AlertFX

[ ![Download](https://api.bintray.com/packages/cbrnrd/AlertFX/AlertFX/images/download.svg) ](https://bintray.com/cbrnrd/AlertFX/AlertFX/_latestVersion)
[![Code Climate](https://codeclimate.com/github/cbrnrd/AlertFX/badges/gpa.svg)](https://codeclimate.com/github/cbrnrd/AlertFX)

A JavaFX library to make working with Dialogs simpler.

## Downloading

### Precompiled (recommended for now)
Grab the `alertfx.jar` file from `./bin` or from GitHub releases

For now, the project uses `mavenCentral()` and `jCenter()` is hopefully coming soon (if it's accepted)

#### Maven

```
<dependency>
  <groupId>org.cbrnrd</groupId>
  <artifactId>alertfx</artifactId>
  <version>1.0-c</version>
  <type>pom</type>
</dependency>
```

#### Gradle

`compile 'org.cbrnrd:alertfx:1.0-c'`

or 

(maybe)
```
repositories {
    maven {
        url  "http://dl.bintray.com/cbrnrd/AlertFX" 
    }
}
```

#### Ivy

```
<dependency org='org.cbrnrd' name='alertfx' rev='1.0-c'>
  <artifact name='alertfx' ext='pom' />
</dependency>
```

## Usage

1. `import org.cbrnrd.alertfx.*;`
2. Declare a new MsgBox (or whatever else you want) `MsgBox msgBox = new MsgBox("Message here");`
3. Apply any additional properties you want
4. Show the alert with `msgBox.show()`

## Documentation

Available [here](http://cbrnrd.github.io/AlertFX). (Still working on it)

## Bugs

If you find any bugs, please report them on GitHub issues.

## Contributing

If you feel that something you created will fit in in this library,
feel free to open a Pull Request on GitHub. I'll do a quick review
and we'll be all good!

## Thank you

Thank you for using AlertFX 👏.
If you're feeling generous, donations are always appreciated:

```
19XiyrvqyYNLehf89ckBjPQYCfW77F9rx7 (Ƀ, BTC)
0xf6f247e4a929890926F88144111f5E27d87bD07a (ETH)
LQRUJUpSkmi5BfT6nyPVNKKoLWbnpZ64sL (Ł, LTC)
```
