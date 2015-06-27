# GIT

## 什么是Git？

如果你曾经使用过Github这样的网站或者在Bitbucket 购买过代码，把它展示给你的朋友，那么你可能知道Git是什么。至少，你肯定对它有过了解。

Git是软件开发中最广泛使用的版本控制系统，其最初发布于九年前的2005年4月7日，主要是为了保证一个大型的分布式开发项目的顺利进行。和客户端 - 服务器系统的开发不同，开发者独立于网络访问或中央服务器，因为每个Git的工作目录是一个全面的资料库。

创始人Linus Torvalds决定遵循[GNU通用公共许可证](http://zh.wikipedia.org/wiki/GNU%E9%80%9A%E7%94%A8%E5%85%AC%E5%85%B1%E8%AE%B8%E5%8F%AF%E8%AF%81)第二版的协议条款，免费的发布Git。维基百科中可以了解到，有许多语言来正在开发这个版本控制系统，如Perl, Bash, C and Tcl。

在GentOS7上安装Git之前，我必须明确Git支持主流的操作系统，如Linux，POSIX，Windows和OS X.

## GitHub 教程系列文章：

GitHub 使用教程图文详解  [http://www.linuxidc.com/Linux/2014-09/106230.htm](http://www.linuxidc.com/Linux/2014-09/106230.htm) 

Git 标签管理详解 [http://www.linuxidc.com/Linux/2014-09/106231.htm](http://www.linuxidc.com/Linux/2014-09/106231.htm) 

Git 分支管理详解 [http://www.linuxidc.com/Linux/2014-09/106232.htm](http://www.linuxidc.com/Linux/2014-09/106232.htm) 

Git 远程仓库详解 [http://www.linuxidc.com/Linux/2014-09/106233.htm](http://www.linuxidc.com/Linux/2014-09/106233.htm) 

Git 本地仓库（Repository）详解 [http://www.linuxidc.com/Linux/2014-09/106234.htm](http://www.linuxidc.com/Linux/2014-09/106234.htm) 

Git 服务器搭建与客户端安装  [http://www.linuxidc.com/Linux/2014-05/101830.htm](http://www.linuxidc.com/Linux/2014-05/101830.htm) 

Git 概述 [http://www.linuxidc.com/Linux/2014-05/101829.htm](http://www.linuxidc.com/Linux/2014-05/101829.htm) 

分享实用的GitHub 使用教程 [http://www.linuxidc.com/Linux/2014-04/100556.htm ](http://www.linuxidc.com/Linux/2014-04/100556.htm )

## GIT安装

### 1. 第一种方式 

软件包管理器安装：

> \# yum install git 

### 2. 第二种方式

源码编译安装：

 Git 的工作需要调用 curl，zlib，openssl，expat，libiconv 等库的代码，所以需要先安装这些依赖工具。在有 yum 的系统上（比如 Fedora）或者有 apt-get 的系统上（比如 Debian 体系），可以用下面的命令安装：

> \# **yum install curl-devel expat-devel gettext-devel openssl-devel zlib-devel**

> \# **yum install gcc-c++ perl-devel asciidoc xmlto docbook-utils docbook2X**

> \# **cd /usr/bin**

> \# **ln -s db2x_docbook2texi docbook2x-texi**

> \# **wget https://www.kernel.org/pub/software/scm/git/git-2.4.0.tar.gz git-2.4.0.tar.gz**

> \# **tar -zxf git-2.4.0.tar.gz**

> \# **cd git-2.4.0**

> \# **make prefix=/usr all doc info ;**

> \# **make prefix=/usr install install-doc install-html install-info ;**

## GIT设置

### 服务端

1. 创建用户 git

	> \# **adduser git**

2. 使用公私钥形式，每个人在自己的电脑上生成相关key文件，然后将公钥上传到服务器上：

	> \# **ssh-keygen -t rsa -C "shenchenbo@ddsoucai.cn"**

3. 将*id_rsa.pub*文件上传给服务器管理者

	在服务器上*~/.ssh*下有一个文件*"authorized_keys"*,用它来存贮公钥，例如我的公钥上传后存在于*/tmp/*下：

	> \# ** su git**

	> \# **cat /tmp/id_rsa.pub >> ~/.ssh/authorized_keys**

4. 安全防范

	为一个额外的防范措施，你可以用 Git 自带的 git-shell 工具限制 git 用户的活动范围。只要把它设为 git 用户登入的 shell，那么该用户就无法使用普通的 bash 或者 csh 什么的 shell 程序。编辑 /etc/passwd 文件：

	> \# **sudo vim /etc/passwd**

	在文件末尾，你应该能找到类似这样的行：

	> \# **git:x:1000:1000::/home/git:/bin/sh**

	把 ***bin/sh*** 改为 ***/usr/bin/git-shell*** （或者用 which git-shell 查看它的实际安装路径）。该行修改后的样子如下：

	> \# **git:x:1000:1000::/home/git:/usr/bin/git-shell**

	现在 git 用户只能用 SSH 连接来推送和获取 Git 仓库，而不能直接使用主机 shell。

5. 创建仓库

> \# **mkdir git_repo**

> \# **cd git_repo**

> \# **git --bare init**

### 客户端：

1. 创建 ***git*** 提交用户：

	> \# ** git config --global user.name "Shen ChenBo"**

	> \# **git config --global user.email zhiweik@gmail.com**

2. 创建用户公私钥：

	> \# **ssh-keygen -t rsa -C "shenchenbo@ddsoucai.cn"**

3. 忽略文件

	用以忽略一些不想提交的文件

	> \# **git config --global core.excludesfile ~/.gitignore_global**

4. 初始化并提交到本地仓库

	> \# **git init**

	> \# **git add it_technology_research/**

5. 提交到远程仓库

> \# **git remote add origin git@gitserver:/home/git_repo**

> \# **git push origin master**

6. 克隆远程仓库到本地

	> \# **git clone git@gitserver:/home/git_repo**

7. 本地配置

	如果服务器ssh端口不是22，需做相应的设置：
	
	- ssh 指定私钥的配置管理，为本地添加 ssh 别名，编辑 ~/.ssh/config ，如果没有该文件，创建一个:

		> \# **vi ~/.ssh/config**

	- 在 config 中添加：

		> \# **# 注释说明**
		> 
		> \# **Host 别名**
		> 
		> \# **HostName  域名或 ip**
		> 
		> \# **User 登陆服务器用的账号**
		> 
		> \# **Port 端口号(默认22，可以不填，如果服务器修改了 ssh 登录端口号，此处需要修改)**
		> 
		> \# **IdentityFile 密钥文件的位置**

