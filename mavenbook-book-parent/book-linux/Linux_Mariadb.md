## CENTOS7 编译安装Mariadb

由于之前都是通过yum install 的形式进行安装，现在将尝试通过编译安装的形式进行安装Mariadb数据库软件。

### 下载Mariadb 二进制文件

前往Mariadb[官网](http://mariadb.org)下载用于Linux系统的64位二进制文件。

### 将文件上传到服务器上、解压

将二进制文件解压到 /usr/local/ 下，

> \# cd **/usr/local**

> \# **tar -zxvpf /path-to/mariadb-VERSION-OS.tar.gz**

> \# **ln -s mariadb-VERSION-OS mysql** #建立软连接，方便操作

### 准备工作

> \# **yum install jemalloc**

### 安装

> \# **groupadd mysql**

> \# **useradd -g mysql mysql**

> \# **cd mysql**

> \# **./scripts/mysql_install_db --user=mysql**

> \# **chown -R root .**

> \# **chown -R mysql data**