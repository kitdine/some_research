## SAMBA

Samba：将访问Liunx文件系统就像访问window文件系统一样方便、直观。

### Samba安装

> \# **yum -y install samba samba-client samba-common**

### Samba 匿名访问设置

1. 在修改配置文件之前先进行备份

	> \# **mv /etc/samba/smb.conf /etc/samba/smb.conf.bak**


2. 新建smb.conf配置文件：

	> \# **vi /etc/samba/smb.conf**

3. 写入以下内容：

		[global]
		workgroup = WORKGROUP
		server string = Samba Server %v
		netbios name = centos
		security = user
		map to guest = bad user
		dns proxy = no
		#============================ Share Definitions ============================== 
		[Anonymous]
		path = /samba/anonymous
		browsable =yes
		writable = yes
		guest ok = yes
		read only = no

4. 创建相关文件夹：

	> \# **mkdir -p /samba/anonymous**

5. 设置开机自启并重启服务

	> \# **systemctl enable smb.service**
	> \# **systemctl enable nmb.service**
	> \# **systemctl restart smb.service**
	> \# **systemctl restart nmb.service**

6. 防火墙设置

	> \# **firewall-cmd --permanent --zone=public --add-service=samba**

	> \# **firewall-cmd --reload**

7. 使用

	在windows下，按下“***win***”+“***R***”，在弹出的运行弹出框中输入 “***\\\\your  address***”，就可以访问了。

8. 给予相应权限

	> \# **cd /samba**

	> \# **chmod -R 0755 anonymous/**

	> \# **chown -R nobody:nobody anonymous/**

	> \# **chcon -t samba_share_t anonymous/**

### Samba 受限访问

1. 需先创建用户组和用户

	> \# **groupadd smbgrp**

	> \# **useradd test_samba -G smbgrp**

2. 将 ***test_samba*** 用户添加到Samba服务上，并设置密码：

	> \# **smbpasswd -a test_samba**

3. 在 ***samba*** 下新建一个目录 “***secured***”:

	> \# **mkdir -p /home/samba/secured**

	> \# **cd /home/samba**

	> \# **chmod -R 0777 secured/**

	> \# **chcon -t samba_share_t secured/**

4. 给予相关权限

	> \# **chown -R test_samba:smbgrp secured/**

4. 修改配置文件：

	> \# **vi /etc/samba/smb.conf**

	添加以下内容：

		[secured]
		 path = /samba/secured
		 valid users = @smbgrp
		 guest ok = no
		 writable = yes
 		 browsable = yes

5. 重启服务

	> \# **systemctl restart smb.service**
	> \# **systemctl restart nmb.service**

