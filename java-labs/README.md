# java-labs: Creating the environment for Java development and Git - 2020-2021

## Netcat (nc)
- Windows OS
    - Download MobaXterm from [here] (https://download.mobatek.net/2062020111930940/MobaXterm_Portable_v20.6.zip) and extract the content. No installation is needed. Netcat is available if you click on "Start local terminal".

- Linux OS
    - Netcat should already be installed on your system.

## IntelliJ IDEA Community Edition

- Download IntelliJ IDEA from [here](https://www.jetbrains.com/es-es/idea/download/) and install it using default options.

## Git 

- Download Git from [here](https://git-scm.com/downloads) and install it using default options

> Note that for instance in Ubuntu systems you could download and install it by simply executing the following:
  
```shell
    sudo apt-get install git
```

- Basic configuration
    - In Windows OS, the following commands should be executed inside git-bash (`$GIT_HOME/git-bash.exe`):
    
```shell
    git config --global user.email "<user-login>@udc.es"
    git config --global user.name "<user-name>"
```

> The following line illustrates how to set Sublime as the Git default editor, but you can use any other editor installed in your OS (you can download Sublime Text editor from [here](https://www.sublimetext.com/3))
      
```shell
    >Windows OS
	git config --global core.editor "'C:\Program Files\Sublime Text 3\sublime_text.exe' -w"
	
    >Linux OS
	git config --global core.editor "subl -w"
```

- [Optional]  Autocompletion utility for Git in Linux OS systems:
    - Follow instructions from [https://github.com/bobthecow/git-flow-completion/wiki/Install-Bash-git-completion](https://github.com/bobthecow/git-flow-completion/wiki/Install-Bash-git-completion)

### Creation and configuration of SSH Keys

- From the git-bash interpreter in Windows OS systems
> Generate SSH keys in the default path ($HOME/.ssh) and with default names
      
```shell
    ssh-keygen -t rsa -b 4096 -C "<user-login>@udc.es"
```    
    
- Open the browser and navigate to [https://github.com/settings/keys](https://github.com/settings/keys)
- In the "Key" field, copy the public key, i.e, content of file `$HOME/.ssh/id_rsa.pub`
- In the "Title" field, specify a name for the key
- Click on the "Add key" button

- Try SSH connectivity against the Git server and add it to the list of known hosts
  > Answer "yes" to the question "Are you sure you want to continue connecting (yes/no)?"
   
```shell
    ssh -T git@github.com
```   

## Creating your project

### Create Git repository in Github web site

- Open the browser, navigate to https://github.com/ and log in.

- Click on https://classroom.github.com/a/Z8xbV4cY
  - Accept java-labs assignment. 
  - Refresh browser after some seconds.
  - Click on your repository link.   

### Initializing your local Git repository

```shell
	git clone git@github.com:redes-java-labs/java-labs-<user-login>.git
```

 NOTE that &lt;user-login&gt; must be changed by your user login.

### Working on your Git repository

- These are the basic commands to use when a change has been made in your project. Although "git status" is not mandatory, it can be very useful. The same happens with "git log". 

```shell
	cd java-labs-<user-login>
	git status
	git add . 
	git commit -m "commit message"	
	git push origin master
	git log
```

-  In order to create a tag, previous commands must be followed by these ones.

```shell	
	git tag -a <tag-name> -m "tag message"	
	git push origin <tag-name>
```

NOTE that it is important to add -a option to create an annotated tag (otherwise  a lightweight tag will be created). 

### Load the project in IntelliJ IDEA

- Click on "File" > "New" > "Project from Existing Sources" menu option.
- Select "java-labs-&lt;user-login&gt;" folder as the folder to import.
- Click on "Ok" button.
- Choose "Create project from existing sources" and click on "Next" button. 
- Set "java-labs-&lt;user-login&gt;" as "Project Name". The default values are correct for the remaining fields. NOTE that IntelliJ IDEA project should be created within java-labs-&lt;user-login&gt; (do not change the default value for the project location). This way a .iml file, an out/ folder (with .class files) and a .idea folder (with IntelliJ configuration) will appear within java-labs-&lt;user-login&gt;.
- Mark src folder and click on "Next" button. 
- Click on "Next" button until "Finish" button will appear, and click on "Finish" button.

### Modify .gitignore

- Go to java-labs-&lt;user-login&gt;/ folder.  
- The .out folder should not be versioned, but .iml file and .idea should. In consequence, it is necessary to check .gitignore files (there are one within java-labs/ and another withing java-labs/.idea) in order to version .iml file and the .idea folder (check that workspace.xml is included).


