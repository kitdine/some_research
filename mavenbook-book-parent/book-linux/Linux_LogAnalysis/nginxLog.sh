#!/bin/bash
#
# Filename:    nginxLog.sh
# Author:      ShenChenBo
# Description: 解压nginx日志
# Notes:       设置crontab，每天01点01分定时执行
#
ROOT_UID=0
if [ "$UID" -ne "$ROOT_UID" ];then
    echo "Error: 必须以root用户运行此程序！"
    exit 1
fi
 
nginx_logs_dir="/var/log/nginx"
nginx_logs_savedir="/var/log/awstats"
nginx_pid_file="/var/run/nginx.pid"
# 待解压nginx日志文件
nginx_log_waitting_file="$nginx_logs_dir/access.log-`date -d -1day +%Y%m%d`.gz"
# 待转移nginx日志文件
nginx_log_copy_file="$nginx_logs_dir/access.log-`date -d -1day +%Y%m%d`"
# 复制后的日志文件名，例如access_20141022.log
nginx_log_today="access_`date -d -1day +%Y%m%d`.log"
 
[ -f "$nginx_log_today" ] && exit 1
# 解压
gunzip -c $nginx_log_waitting_file >  $nginx_log_copy_file
# 复制到指定路径
mv $nginx_log_copy_file $nginx_logs_savedir/$nginx_log_today
# 删除
#rm -rf $nginx_log_copy_file