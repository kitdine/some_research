## Linux 安装

	服务器环境一般情况下我们都会选择Linux作为操作系统，这样能更方便的进行管理。

### 准备工作 ###

	这里我们选择Centos 7 作为Linux系统进行安装，并且使用其最小安装镜像进行安装，iso下载地址请[点击这里](http://isoredirect.centos.org/centos/7/isos/x86_64/CentOS-7-x86_64-Minimal-1503-01.iso "Centos 7 下载")。

### 开始安装 ###

1. 选择“Install Centos 7”

     ![图片1 start](Linux_install/start.png)
2. 语言选择“**English**”

     ![图片2 language ](Linux_install/choose_language.png)
3. 时区、时间设置

     ![图片3 time zone](Linux_install/choose_time_zone.png)

     "*点击* **Date&TIme**"

     ![图片4 time choose](Linux_install/choose_ut8.png) 

     "分别选择 ***'Asia'*** 和 ***'Shanghai'***"

4. 磁盘分区

     ![图片5 disk](Linux_install/choose_disk.png) 

     "点击 ***Installation Destination***"

     ![图片6 disk](Linux_install/choose_disk_2.png) 

     "在 ***'Other Storage Options'*** 的 ***'Partitioning'*** 中选择 ***'I Will configure parturition'***，然后点击上方的 ***'Done'*** 按钮进入自主分配磁盘页面。"

     ![图片7 disk](Linux_install/choose_disk_1.png) 

     "选择 ***‘LVM’***，然后点击上方的 ***'Click here to create them automatically'***，进入下一个页面，进行分配。"

     ![图片8 disk](Linux_install/choose_disk_3.png) 

     我的硬盘是50GB的，大家可以根据自己的情况进行调整，具体分配方案如下：

    	-  System
    	  - /			12.5GB		根目录
    	  - /var		7.5GB		*yum install*的软件会安装在这里
    	  - /BIOS Boot	2048Kib		
    	  - /boot		500MB
    	  - /usr		7.5GB		大量*yum install*的软件会安装在这里
    	  - swap		2048MB		交换分区
  	    -  DATA
  	   	  - /home		20GB		自己存储数据的地方，尽量不要放在*System*分区下。
  	 
     ![图片9 disk](Linux_install/choose_disk_4.png)

	 "点击 ***'Accept Changes'***"

5. 网络设置

     ![图片10 network](Linux_install/choose_network.png) 

	 "点击选择 ***'NETWORK & HOST NAME'***"

     ![图片11 network](Linux_install/choose_network_1.png) 

	 "点击 ***'Configure'***"

     ![图片11 network](Linux_install/choose_network_2.png)

	 "在***'IPV4 Settings'***选项卡中配置相关ip信息，由于我是在虚拟机中安装，并且选择了**Bridge**模式，因此和宿主机的网段一样。然后点击***'SAVE'***"。   

     ![图片12 network](Linux_install/choose_network_3.png) 

     "将 ***'ETHERNET'*** 右边的按钮移到***'ON'***，然后就会看到现在网络已经通了，点击*'Done'*"。

6. 开始安装

     ![图片13 install](Linux_install/install.png) 
	 
	 "点击 ***'Begin Installation'***开始安装"。

7. 设置root密码

     ![图片14 root](Linux_install/root_pwd.png) 

	 "点击 ***'Root Password'***，进入root密码设置界面"

	 ![图片15 root](Linux_install/root_pwd_1.png)

     "输入自己的密码，然后点击 ***'Done'***"。

8. 安装完成，重启

	 ![图片16 finish](Linux_install/finish.png)

	 "点击 ***'Reboot'*** 重启服务器，然后就可以登入系统了。"

	 ![图片17 login](Linux_install/login.png) 